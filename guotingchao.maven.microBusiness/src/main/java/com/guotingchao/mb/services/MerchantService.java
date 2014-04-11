/**   
* @Title: MerchantService.java
* @Package com.guotingchao.mb.services
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-11 下午5:54:04
* @version V1.0   
*/
package com.guotingchao.mb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guotingchao.mb.model.Merchant;
import com.guotingchao.mb.persistence.MerchantMapper;

/**
 * @ClassName: MerchantService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-11 下午5:54:04
 * 
 */
@Service
public class MerchantService implements MerchantMapper{

	@Autowired
	MerchantMapper merchantMapper;
	
	@Override
	public void insertMerchant() {
	}
	@Override
	public void updateMerchant() {
	}
	 
	@Override
	public List<Merchant> getMerchantAll() {
		return null;
	}
	@Override
	public List<Merchant> getMerchantsByClassId(int classId) {
		return merchantMapper.getMerchantsByClassId(classId);
	}
	@Override
	public Merchant getMerchantById(Long id) {
		return merchantMapper.getMerchantById(id);
	}

}
