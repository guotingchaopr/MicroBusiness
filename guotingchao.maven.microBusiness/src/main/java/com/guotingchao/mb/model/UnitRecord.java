/**   
* @Title: UnitRecord.java
* @Package com.guotingchao.mb.model
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-8 下午2:31:21
* @version V1.0   
*/
package com.guotingchao.mb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UnitRecord
 * @Description: TODO(用户当前菜单位置记录)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-8 下午2:31:21
 * 
 */
public class UnitRecord implements Serializable{
	private static final long serialVersionUID = 7554786734343781315L;
	private Long id;
	private int   current_unit;
	private Long   unit_id;
	private String user_id;
	private Date sysdate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCurrent_unit() {
		return current_unit;
	}
	public void setCurrent_unit(int current_unit) {
		this.current_unit = current_unit;
	}
	public Long getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(Long unit_id) {
		this.unit_id = unit_id;
	}
	 
	 
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getSysdate() {
		return sysdate;
	}
	public void setSysdate(Date sysdate) {
		this.sysdate = sysdate;
	}
	
}
