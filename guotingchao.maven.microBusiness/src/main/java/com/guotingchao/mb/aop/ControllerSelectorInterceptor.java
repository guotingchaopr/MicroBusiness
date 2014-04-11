package com.guotingchao.mb.aop;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.guotingchao.mb.model.GolbalConfig;
import com.guotingchao.mb.model.Message;
import com.guotingchao.mb.model.UnitRecord;
import com.guotingchao.mb.model.Users;
import com.guotingchao.mb.services.MessageService;
import com.guotingchao.mb.services.UnitRecordService;
import com.guotingchao.mb.services.UserService;
import com.guotingchao.mb.util.WeiXinUtil;

/**
 * @ClassName: ControllerSelectorInterceptor
 * @Description: TODO(将do开头的所有方法拦截)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-5 上午11:26:26
 * 
 */

@Aspect
@Component
public class ControllerSelectorInterceptor {
	@Autowired
	UserService userService;
    
	@Autowired
    MessageService messageService;
	
    @Autowired
    UnitRecordService unitRecordService;
    
    
    
	Logger log = Logger.getLogger(ControllerSelectorInterceptor.class
			.getClass());
	@Test
	@Before("execution(* com.guotingchao.mb.controller.*Controller.do*(..,javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse))")
	public void doBefore(JoinPoint jp) throws IOException {
		long startTime=System.nanoTime();   //获取开始时间  
		UnitRecord ur = null ;
		HttpServletRequest request = (HttpServletRequest) jp.getArgs()[jp.getArgs().length - 2];
		log.info("----------微信入口拦截--------------");
		if (WeiXinUtil.checkWeixinReques(request)) {
			log.info("--【验证用户是否存在】--");
			Map<String, String> xml = WeiXinUtil.parseXml(request);
			Message message = WeiXinUtil.mapToMessage(xml);
			String wx_id = xml.get("FromUserName");
			request.setAttribute("XML", xml);
			Users user = userService.getUserByWxId(wx_id);
			if (user == null) {
				log.info("此用户未添加");
				user = new Users();
				user.setWx_id(wx_id);
				int updateFlag = userService.insertUser(user);
				log.info("UserId:  "+user.getId());
				if (updateFlag > 0) {
					log.info("添加用户 [" + wx_id + "] 成功");
					ur = new UnitRecord();
					ur.setUser_id(user.getWx_id());
					unitRecordService.insertUnitRecord(ur);
				} else {
					log.info("添加用户 [" + wx_id + "] 失败");
				}
			} else {
				log.info("此用户已经添加");
			}
			ur = unitRecordService.getUnitRecordByUserId(user.getWx_id()); //获取当前用户所在分类
			log.info("当前用户所在分类 "+ ur.getUnit_id());
			messageService.addMessage(message); //消息记录保存
			log.info("messageID " + message.getMsgId());
			request.setAttribute("UR_LEVEL", ur.getUnit_id()); //获取用户当前所在UR LEVEL
			 switch(ur.getUnit_id().intValue()){
			 	case 0:
			 		WeiXinUtil.level_0_process(request,GolbalConfig.GC.get("CLASSES_ALL"));
			 		break;
			 	case 1:
			 		WeiXinUtil.level_1_process(request,GolbalConfig.GC.get("CLASSES_ALL"));
			 		break;
			 }
		}else{
			log.warn("==================[非法请求]=================\n");
			log.warn("URL : " +request.getRequestURL());
			log.warn("=====Headers  Action=====");
			Enumeration<String> enumHeaders= request.getHeaderNames();
			while(enumHeaders.hasMoreElements()){
				String headrName = enumHeaders.nextElement();
				log.error(headrName + " : " + request.getHeader(headrName));
			}
			log.warn("=====Headers  END=====");
			log.warn("=====QueryString  Action=====");
			log.warn(request.getQueryString());
			log.warn("=====QueryString  END=====");
		}
		log.info("----------微信入口拦截结束-------------- ###耗时：" + (System.nanoTime() - startTime ) + "NS");
	}
	
	
	
	
	/*@After("execution(* com.guotingchao.mb.controller.*Controller.do*(..,javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse))")
	public void doAfter(JoinPoint jp) {
		// Object[] args = jp.getArgs();
		// HttpServletRequest request = (HttpServletRequest)
		// args[args.length-2];
	}*/
	 
}
