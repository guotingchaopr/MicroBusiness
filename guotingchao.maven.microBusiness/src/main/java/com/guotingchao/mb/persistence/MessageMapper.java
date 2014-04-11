/**   
* @Title: MessageMapper.java
* @Package com.guotingchao.mb.persistence
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-7 下午11:49:29
* @version V1.0   
*/
package com.guotingchao.mb.persistence;

import java.util.List;

import com.guotingchao.mb.model.Message;

public interface MessageMapper {
	public int addMessage(Message message);

	public List<Message> findMessage(int start,int size);
}
