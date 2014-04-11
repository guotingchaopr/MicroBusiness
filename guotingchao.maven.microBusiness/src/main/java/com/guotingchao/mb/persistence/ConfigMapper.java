/**   
* @Title: ConfigMapper.java
* @Package com.guotingchao.mb.persistence
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-6 下午9:05:00
* @version V1.0   
*/
package com.guotingchao.mb.persistence;

import java.util.List;

import com.guotingchao.mb.model.Config;

/**
 * @ClassName: ConfigMapper
 * @Description: TODO(获取ConfigMapper对象)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-6 下午9:05:00
 * 
 */
public interface ConfigMapper {
	void insertConfig();
	void updateConfig();
	Config getConfigById(Long id);
	List<Config> getConfig();
}
