/**   
 * @Title: TestController.java
 * @Package controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-4 下午11:41:50
 * @version V1.0   
 */
package com.guotingchao.mb.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guotingchao.mb.model.Classes;
import com.guotingchao.mb.model.GolbalConfig;
import com.guotingchao.mb.model.Merchant;
import com.guotingchao.mb.model.Message;
import com.guotingchao.mb.model.Reply;
import com.guotingchao.mb.services.MerchantService;
import com.guotingchao.mb.services.UnitRecordService;
import com.guotingchao.mb.services.UserService;
import com.guotingchao.mb.util.WeiXinUtil;

/**
 * @ClassName: WxController
 * @Description: TODO(微信功能入口)	
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-4 下午11:41:50
 * 
 */
@Controller
public class WxController {
	private Logger log = Logger.getLogger(WxController.class.getClass());
	
	
	@Autowired
	UserService userService;
    
	@Autowired
	MerchantService merchantService;
	
	@Autowired
	UnitRecordService unitRecordService;
	
	@RequestMapping(value = "/microBusiness_wx")
	@ResponseBody
	public String doWeiXin(HttpServletRequest request,
			HttpServletResponse response) {
		// 处理微信请求
		@SuppressWarnings("unchecked")
		Map<String, String> requestMap = (Map<String, String>) request.getAttribute("XML");
		if (null != requestMap) {
			Message message = WeiXinUtil.mapToMessage(requestMap);
			log.info("\nClient Message:  \n" + message.toString());
			String rep_xml = "";
			int UR_LEVEL = ((Long) request.getAttribute("UR_LEVEL")).intValue(); 
			StringBuffer UR_LEVEL_PROCESSED = new StringBuffer((String)request.getAttribute("UR_LEVEL_PROCESSED")); //获取栏目级预处理字符串
			Reply reply = wxEventProcess(message); 
			if(null != UR_LEVEL_PROCESSED  &&  message.getMsgType().equals("event") && message.getEvent().equals("subscribe")){
					UR_LEVEL_PROCESSED.insert(0, GolbalConfig.GC.get("WELCOME_STR").toString());
					reply.setContent(UR_LEVEL_PROCESSED.toString()); //用户添加直接吐回
			}else{
				try{
					reply = contetnProcess(reply,UR_LEVEL);
				}catch(NumberFormatException ne){
					UR_LEVEL_PROCESSED.append("没有'"+ message.getContent() +"'选项 请输入对应选项]");
					reply.setContent(UR_LEVEL_PROCESSED.toString());
				}
			}
			
			// 拼装回复消息
			rep_xml = WeiXinUtil.replyToXml(reply);
			
			log.info("\nReply Message:  \n" + rep_xml);
			return rep_xml;
		} else {
			return "REQUEST ERROR";
		}
	}

	
	
	/**
	 * 
	 * @Title: wxEventProcess
	 * @Description: 消息事件处理
	 * @param @param event
	 * @param @return 设定文件
	 * @return Reply 返回类型
	 * @throws
	 */
	private Reply wxEventProcess(Message msg) {
		Reply reply = null;
		// 拼装回复消息
		reply = new Reply();
		reply.setToUserName(msg.getFromUserName());
		reply.setFromUserName(msg.getToUserName());
		reply.setCreateTime(new Date());
		reply.setContent(msg.getContent());
		reply.setMsgType("text");
		return reply;
	}

	/**
	 * 
	* @Title: contetnProcess
	* @Description: 客户内容选择
	* @param @param chooseCode
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public Reply contetnProcess(Reply reply,int UR_LEVEL){
		int chooseCode = Integer.parseInt(reply.getContent());
		StringBuffer content = null;
		switch(UR_LEVEL){
			case 0:
				for(Classes classes : (List<Classes>)GolbalConfig.GC.get("CLASSES_ALL")){
					 if(chooseCode == classes.getId()){
						 content = new StringBuffer(merchantProcess(chooseCode));
					 }
				}
				break;
		}
		if(content == null) throw new NumberFormatException();
		reply.setContent(content.toString());
		return reply;
	}
	
	
	/**
	 * 
	* @Title: merchantProcess
	* @Description: TODO(商铺类型选择处理)
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	private String merchantProcess(int chooseCode){
		List<Merchant> mcs = merchantService.getMerchantsByClassId(chooseCode);
		StringBuffer mc_buffer = new StringBuffer();
		for(Merchant mc : mcs){
			mc_buffer.append("商铺名：" +mc.getName()+"\n");
			mc_buffer.append("商铺介绍：" +mc.getTrade_description()+"\n");
			mc_buffer.append("商铺地址：" +mc.getTradeAddress()+"\n");
			mc_buffer.append("店 长 ：" +mc.getTradeName()+" 联系方式： " + mc.getTradeContact());
		}
		return mc_buffer.toString();
	}
	
	/*
	 * @RequestMapping("/getUser") public ModelAndView
	 * doGetUser(HttpServletRequest request,HttpServletResponse response){ Long
	 * id = Long.parseLong(request.getParameter("uid")); Users user =
	 * userService.getUserById(id); ModelAndView mav = new ModelAndView();
	 * mav.addObject("userinfo", user); mav.setViewName("user"); return mav; }
	 */
}
