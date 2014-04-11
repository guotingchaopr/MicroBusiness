/**   
 * @Title: Config.java
 * @Package com.guotingchao.mb.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-6 下午5:19:37
 * @version V1.0   
 */
package com.guotingchao.mb.model;

import java.io.Serializable;

/**
 * @ClassName: Config
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-6 下午5:19:37
 * 
 */
public class Config implements Serializable {
	private static final long serialVersionUID = 9053826918741243075L;
	private Long id;
	private String conf_key;
	private String conf_value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConf_key() {
		return conf_key;
	}

	public void setConf_key(String conf_key) {
		this.conf_key = conf_key;
	}

	public String getConf_value() {
		return conf_value;
	}

	public void setConf_value(String conf_value) {
		this.conf_value = conf_value;
	}

}
