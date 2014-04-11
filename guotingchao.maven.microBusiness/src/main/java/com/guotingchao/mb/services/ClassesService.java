/**   
* @Title: ClassesService.java
* @Package com.guotingchao.mb.services
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-7 下午3:32:38
* @version V1.0   
*/
package com.guotingchao.mb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guotingchao.mb.model.Classes;
import com.guotingchao.mb.persistence.ClassesMapper;

/**
 * @ClassName: ClassesService
 * @Description: TODO(商圈类型Service)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-7 下午3:32:38
 * 
 */
@Service
public class ClassesService implements ClassesMapper{

	
	@Autowired
	ClassesMapper classesMapper;
	/**
	 * [重载方法]
	 * <p>Title: getClassesById</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.guotingchao.mb.persistence.ClassesMapper#getClassesById(int)
	 */
	@Override
	public Classes getClassesById(int id) {
		return classesMapper.getClassesById(id);
	}

	/**
	 * [重载方法]
	 * <p>Title: getClassesAll</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.guotingchao.mb.persistence.ClassesMapper#getClassesAll()
	 */
	@Override
	public List<Classes> getClassesAll() {
		return classesMapper.getClassesAll();
	}

	/**
	 * [重载方法]
	 * <p>Title: deleteClassesById</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.guotingchao.mb.persistence.ClassesMapper#deleteClassesById(int)
	 */
	@Override
	public int deleteClassesById(int id) {
		return classesMapper.deleteClassesById(id);
	}

}
