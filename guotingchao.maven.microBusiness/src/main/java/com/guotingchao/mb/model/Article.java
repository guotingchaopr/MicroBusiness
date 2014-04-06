/**   
* @Title: Article.java
* @Package com.guotingchao.mb.model
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-6 下午12:11:29
* @version V1.0   
*/
package com.guotingchao.mb.model;

/**
 * @ClassName: Article
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-6 下午12:11:29
 * 
 */
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * 图文消息
 * @author guotingchao
 */
public class Article implements Serializable{
	private static final long serialVersionUID = 1817160388008208244L;

	@XStreamOmitField
	private int id;//数据库存储的id

    // 图文消息名称  
	@XStreamAlias("Title")
    private String title;  
    // 图文消息描述  
	@XStreamAlias("Description")
    private String description;  
    // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致  
	@XStreamAlias("PicUrl")
    private String picUrl;  
    // 点击图文消息跳转链接  
	@XStreamAlias("Url")
    private String url;

	@XStreamOmitField
	private int replyId;

	private Reply reply;

	public Article() {}

	public Article(String title, String description, String picUrl, String url) {
		this.title = title;
		this.description = description;
		this.picUrl = picUrl;
		this.url = url;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

    
    
}