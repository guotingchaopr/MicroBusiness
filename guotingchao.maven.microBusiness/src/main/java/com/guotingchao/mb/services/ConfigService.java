/**   
* @Title: ConfigService.java
* @Package com.guotingchao.mb.services
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-6 下午9:13:46
* @version V1.0   
*/
package com.guotingchao.mb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guotingchao.mb.model.Config;
import com.guotingchao.mb.persistence.ConfigMapper;


/**
 * @ClassName: ConfigService
 * @Description: TODO(读取Config数据)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-6 下午9:13:46
 * 
 */
@Service
public class ConfigService{

	@Autowired
	private ConfigMapper configMapper;

	public void insertConfig() {
	}
	
	public void updateConfig() {
	}
	
	public Config getConfigById(Long id) {
		Config config = configMapper.getConfigById(id);
		return config;
	}
	
	public List<Config> getConfig(){
		return configMapper.getConfig();
	}
}
