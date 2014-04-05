/**   
* @Title: UserMapper.java
* @Package com.guotingchao.mb.attg
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-5 上午11:00:45
* @version V1.0   
*/
package com.guotingchao.mb.persistence;

import com.guotingchao.mb.model.Users;

/**
 * @ClassName: UserMapper
 * @Description: TODO(用户对象接口)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-5 上午11:00:45
 * 
 */
public interface UsersMapper {
	public void insertUser(Users user);
	public void updateUser(Users user);
	public Users getUserById(Long id);
	public Users getUserByWxId(String wx_id);
}
