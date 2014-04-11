/**   
* @Title: Classes.java
* @Package com.guotingchao.mb.model
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-7 下午3:26:49
* @version V1.0   
*/
package com.guotingchao.mb.model;

import java.io.Serializable;

/**
 * @ClassName: Classes
 * @Description: TODO(商品类型)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-7 下午3:26:49
 * 
 */
public class Classes implements Serializable{
	private static final long serialVersionUID = -7224375179927352422L;
	private int id;
	private String className;
	private int flag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
