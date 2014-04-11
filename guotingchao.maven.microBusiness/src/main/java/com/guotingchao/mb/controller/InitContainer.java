/**   
 * @Title: InitContainer.java
 * @Package com.guotingchao.mb.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-6 下午5:16:58
 * @version V1.0   
 */
package com.guotingchao.mb.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.guotingchao.mb.model.Config;
import com.guotingchao.mb.model.GolbalConfig;
import com.guotingchao.mb.services.ClassesService;
import com.guotingchao.mb.services.ConfigService;

/**
 * @ClassName: InitContainer
 * @Description: TODO(容器组装完成后 自动调用进行配置)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-6 下午5:16:58
 * 
 */
public class InitContainer {

	private Logger log = Logger.getLogger(InitContainer.class.getClass());

	@Autowired
	ConfigService configSevice;
	
	@Autowired
	ClassesService classesService;
	public void init() {
		log.info("-------------初始化数据开始-----------------");
		List<Config> clist = configSevice.getConfig();
		for (Config config : clist) {
			GolbalConfig.GC.put(config.getConf_key(), config.getConf_value());
		}
		
		GolbalConfig.GC.put("CLASSES_ALL", classesService.getClassesAll());
		log.info("-------------初始化数据结束-----------------");
	}
}
