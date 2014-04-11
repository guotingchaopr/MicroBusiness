/**   
* @Title: ConfigMapper.java
* @Package com.guotingchao.mb.persistence
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-6 下午9:05:00
* @version V1.0   
*/
package com.guotingchao.mb.persistence;

import java.util.List;

import com.guotingchao.mb.model.Merchant;

/**
 * @ClassName: MerchantMapper
 * @Description: TODO(获取MerchantMapper对象)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-11 下午9:05:00
 * 
 */
public interface MerchantMapper {
	void insertMerchant();
	void updateMerchant();
	List<Merchant> getMerchantsByClassId(int classId);
	Merchant getMerchantById(Long id);
	List<Merchant> getMerchantAll();
}
