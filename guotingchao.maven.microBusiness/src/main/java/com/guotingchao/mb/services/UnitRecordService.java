/**   
* @Title: UnitRecordService.java
* @Package com.guotingchao.mb.services
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-8 下午3:15:03
* @version V1.0   
*/
package com.guotingchao.mb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guotingchao.mb.model.UnitRecord;
import com.guotingchao.mb.persistence.UnitRecordMapper;

/**
 * @ClassName: UnitRecordService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-8 下午3:15:03
 * 
 */
@Service
public class UnitRecordService implements UnitRecordMapper{
	
	@Autowired
    UnitRecordMapper unitRecordMapper;
	
	@Override
	public UnitRecord getUnitRecordByUserId(String userId) {
		return unitRecordMapper.getUnitRecordByUserId(userId);
	}

	@Override
	public UnitRecord updateUnitRecordById(UnitRecord un) {
		return updateUnitRecordById(un);
	}

	@Override
	public int insertUnitRecord(UnitRecord ur) {
		return unitRecordMapper.insertUnitRecord(ur);
	}
	
	
}
