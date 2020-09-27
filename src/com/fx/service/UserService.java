package com.fx.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fx.dao.UserDao;
import com.fx.entity.Chart;
import com.fx.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	//添加
	public int insert(User user) {
		return userDao.insert(user);
	}

	//删除
	public Object delete(Map<String, Object> map) {
		return userDao.delete(map);
	}

	//更新
	public Object update(Map<String, Object> map) {
		return userDao.update(map);
	}

	//查询所有记录
	public List<User> list(){
		return userDao.list();
	}
	
	//查询记录总数
	public int count(Map<String, Object> map) {
		return userDao.count(map);
	}

	//分页
	public List<User> listByPage(Map<String, Object> map) {
		return userDao.listByPage(map);
	}
	
	//条件查询
	public List<User> listBy(Map<String, Object> map) {
		return userDao.listBy(map);
	}
	
	//条件查询总额，数量总和
	public String listBySum(Map<String, Object> map) {
		return userDao.listBySum(map);
	}

	//饼状图
	public List<Chart> bingChart(Map<String, Object> map) {
		return userDao.bingChart(map);
	}
	
	//柱状图
	public List<Chart> zhuChart(Map<String, Object> map) {
		return userDao.zhuChart(map);
	}
	
	//验证订单号是否存在
	public List<User> listByOrderNum(Map<String, Object> map) {
		return userDao.listByOrderNum(map);
	}

}
