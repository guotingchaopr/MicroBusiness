/**   
* @Title: UserService.java
* @Package com.guotingchao.mb.services
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-5 上午11:19:37
* @version V1.0   
*/
package com.guotingchao.mb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guotingchao.mb.model.Users;
import com.guotingchao.mb.persistence.UsersMapper;

/**
 * @ClassName: UserService
 * @Description: TODO(用户类服务)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-5 上午11:19:37
 * 
 */
@Service
public class UserService{
	@Autowired
	private UsersMapper usersMapper;

	public int insertUser(Users user) {
		return usersMapper.insertUser(user);
	}
    @Transactional(rollbackFor=Exception.class)
	public int updateUser(Users user) {
    	usersMapper.updateUser(user);
		throw new RuntimeException();
	}
	public Users getUserById(Long id) {
		return usersMapper.getUserById(id);
	}

	public Users getUserByWxId(String wx_id) {
		return usersMapper.getUserByWxId(wx_id);
	}
	
	
}
