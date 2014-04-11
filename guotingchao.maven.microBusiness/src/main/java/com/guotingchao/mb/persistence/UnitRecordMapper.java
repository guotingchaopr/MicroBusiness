/**   
* @Title: UnitRecordMapper.java
* @Package com.guotingchao.mb.persistence
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-8 下午2:35:57
* @version V1.0   
*/
package com.guotingchao.mb.persistence;

import com.guotingchao.mb.model.UnitRecord;

/**
 * @ClassName: UnitRecordMapper
 * @Description: TODO(获取用户菜单记录)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-8 下午2:35:57
 * 
 */
public interface UnitRecordMapper {
	UnitRecord getUnitRecordByUserId(String ur);
	UnitRecord updateUnitRecordById(UnitRecord un);
	int insertUnitRecord(UnitRecord ur);
}
