package com.bjsxt.common.dao;

import java.util.List;
import java.util.Map;


public interface IBasicDao<T>
{
	/**
	 * 数据的添加
	 * @param t
	 * @return
	 */
	int insert(T t);
	/**
	 * 数据的删除
	 * @param condMap
	 * @return
	 */
	int delete(Map<String,Object> condMap);
	/**
	 * 查询一条数据
	 * @param t
	 * @return
	 */
	T findOne(Map<String,Object> condMap);
	/**
	 * 更新一条数据
	 * @param condMap
	 * @return
	 */
	int update(T t);
	/**
	 * 根据条件查询多条数据
	 * @param pageInfoUtil
	 * @param condMap
	 * @return
	 */
	List<T> findList(Map<String,Object> condMap);
}
