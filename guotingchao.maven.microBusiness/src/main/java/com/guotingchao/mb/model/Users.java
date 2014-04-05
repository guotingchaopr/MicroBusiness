package com.guotingchao.mb.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ClassName: User
 * @Description: TODO(用户模型)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-5 上午11:03:24
 * 
 */
public class Users implements Serializable{
	private static final long serialVersionUID = 6519130049827650669L;
	private Long id;
	private String wx_id;
	private Timestamp sysdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWx_id() {
		return wx_id;
	}

	public void setWx_id(String wx_id) {
		this.wx_id = wx_id;
	}

	public Timestamp getSysdate() {
		return sysdate;
	}

	public void setSysdate(Timestamp sysdate) {
		this.sysdate = sysdate;
	}
}
