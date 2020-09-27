package com.fx.dao;

import java.util.List;
import java.util.Map;

import com.fx.entity.Chart;
import com.fx.entity.User;

public interface UserDao {

	public int insert(User user);

	public Object delete(Map<String, Object> map);

	public Object update(Map<String, Object> map);
	
	public List<User> list();

	public int count(Map<String, Object> map);

	public List<User> listByPage(Map<String, Object> map);
	
	public List<User> listBy(Map<String, Object> map);
	
	public String listBySum(Map<String, Object> map);

	public List<Chart> bingChart(Map<String, Object> map);
	
	public List<Chart> zhuChart(Map<String, Object> map);

	public List<User> listByOrderNum(Map<String, Object> map);

}
