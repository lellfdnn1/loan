package com.bjsxt.common.dao;

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
}
