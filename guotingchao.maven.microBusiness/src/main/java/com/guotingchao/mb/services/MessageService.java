/**   
* @Title: MessageService.java
* @Package com.guotingchao.mb.services
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-7 下午11:51:13
* @version V1.0   
*/
package com.guotingchao.mb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guotingchao.mb.model.Message;
import com.guotingchao.mb.persistence.MessageMapper;

@Service
public class MessageService implements MessageMapper{
	@Autowired
	MessageMapper messageMapper;

	/**
	 * [重载方法]
	 * <p>Title: addMessage</p>
	 * <p>Description: </p>
	 * @param message
	 * @return
	 * @see com.guotingchao.mb.persistence.MessageMapper#addMessage(com.guotingchao.mb.model.Message)
	 */
	@Override
	public int addMessage(Message message) {
		return messageMapper.addMessage(message);
	}

	/**
	 * [重载方法]
	 * <p>Title: findMessage</p>
	 * <p>Description: </p>
	 * @param start
	 * @param size
	 * @return
	 * @see com.guotingchao.mb.persistence.MessageMapper#findMessage(int, int)
	 */
	@Override
	public List<Message> findMessage(int start, int size) {
		return messageMapper.findMessage(start, size);
	}
	
	
}
