/**   
* @Title: ClassesMapper.java
* @Package com.guotingchao.mb.persistence
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-7 下午3:30:24
* @version V1.0   
*/
package com.guotingchao.mb.persistence;

import java.util.List;

import com.guotingchao.mb.model.Classes;

/**
 * @ClassName: ClassesMapper
 * @Description: TODO(商圈类型功能类)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-7 下午3:30:24
 * 
 */
public interface ClassesMapper {
	Classes getClassesById(int id);
	List<Classes> getClassesAll();
	int deleteClassesById(int id);
}
