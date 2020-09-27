package com.fx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fx.entity.User;
import com.fx.service.UserService;
import com.fx.util.DateUtil;
import com.fx.util.IpUtil;
import com.fx.util.PageUtil;
import com.google.gson.Gson;

@Controller
@RequestMapping
public class UserCtrl {
	@Autowired
	private UserService userService;
	private User user = new User();
	
	private static Gson gson = new Gson();	
	Map<String, Object> map = new HashMap<String, Object>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	List<User> userList = new ArrayList<User>();
	float sum = 0;
	int status = 0;
	
	
	@ResponseBody
	@RequestMapping(value = "/insert.action") //添加数据
	public Object insert(String payment_type, String taobao_id, String order_num, @RequestParam(defaultValue = "0") Float price, 
			String user_id, HttpServletRequest request) {
		String uuid = UUID.randomUUID().toString();
		String create_time = sdf.format(new Date());
		String user_ip = IpUtil.getIpAddr(request);
		status = 1;
		System.out.println(uuid+",  "+create_time+",  "+user_ip);
		User user = new User();
		user.setUuid(uuid);
		user.setPayment_type(payment_type);
		user.setTaobao_id(taobao_id);
		user.setOrder_num(order_num);
		user.setPrice(price);
		user.setUser_id(user_id);
		user.setCreate_time(create_time);
		user.setUser_ip(user_ip);
		user.setStatus(status);
		return userService.insert(user);
	}
	
	@ResponseBody
	@RequestMapping(value = "/listByOrderNum.action") //验证订单号是否存在
	public Object listByOrderNum(String order_num) {
		map.put("order_num", order_num);
		return userService.listByOrderNum(map);
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete.action") //删除
	public Object delete(String uuid) {
		status=0;
		map.put("uuid", uuid);
		map.put("status", status);
		return userService.delete(map);
	}
	
	@ResponseBody
	@RequestMapping(value = "/update.action") //更新
	public Object update(String uuid, String payment_type, String taobao_id, String order_num, Float price, 
			String user_id, HttpServletRequest request) {
		String modify_time = sdf.format(new Date());
		String user_ip = IpUtil.getIpAddr(request);
		System.out.println(modify_time+",  "+user_ip);
		map.put("uuid", uuid);
		map.put("payment_type", payment_type);
		map.put("taobao_id", taobao_id);
		map.put("order_num", order_num);
		map.put("price", price);
		map.put("user_id", user_id);
		map.put("modify_time", modify_time);
		map.put("user_ip", user_ip);
		return userService.update(map);
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateOrDelete.action") //更新或删除
	public Object upordel(int id, String uuid, String oper, String payment_type, String taobao_id, String order_num, Float price, 
			String user_id, HttpServletRequest request) {
		System.out.println("========= id: "+ id +"========");
		if(oper.equals("del")) {
			status=0;
			map.put("uuid", uuid);
			map.put("status", status);
			return userService.delete(map);
		}else if(oper.equals("edit")){
			String modify_time = sdf.format(new Date());
			String user_ip = IpUtil.getIpAddr(request);
			System.out.println(modify_time+",  "+user_ip);
			map.put("uuid", uuid);
			map.put("payment_type", payment_type);
			map.put("taobao_id", taobao_id);
			map.put("order_num", order_num);
			map.put("price", price);
			map.put("user_id", user_id);
			map.put("modify_time", modify_time);
			map.put("user_ip", user_ip);
			return userService.update(map);
		}
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list.action") //查询所有
	public Object list(){	
		return userService.list();
	}
	
	@ResponseBody
	@RequestMapping(value = "/listByPage.action") //分页
	public Map<String, Object> listByPage(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int pageSize, 
			HttpServletRequest request){	
		System.out.println("currentPage:  "+currentPage+"pageSize:  "+pageSize+ "Time:  "+new Date()+"ip:  "+IpUtil.getIpAddr(request));
		int total = userService.count(map);
		PageUtil.pager(currentPage, pageSize, total, request);
		map.put("currentNum", PageUtil.currentNum(currentPage, pageSize));
		map.put("pageSize", pageSize);
		userList = userService.listByPage(map); 
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", total);
		result.put("rows", userList);
		result.put("currentPage", currentPage);	
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/listBy.action") //条件查询+分页
	public Map<String, Object> listBy(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int pageSize, 
			String uuid, String start_time, String end_time, String taobao_id, String user_id, String order_num,
			HttpServletRequest request) throws Exception {
		String endTime = DateUtil.addOneDay(end_time);
		int total = userService.count(map);
		PageUtil.pager(currentPage, pageSize, total, request);
		map.put("currentNum", PageUtil.currentNum(currentPage, pageSize));
		map.put("pageSize", pageSize);
		map.put("uuid", uuid);
		map.put("start_time", start_time);
		map.put("end_time", endTime);
		map.put("taobao_id", taobao_id);
		map.put("user_id", user_id);
		map.put("order_num", order_num);	
		userList = userService.listBy(map);
		String sumPrice = userService.listBySum(map);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", total);
		result.put("rows", userList);
		result.put("currentPage", currentPage);	
		result.put("sumPrice", sumPrice);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/bingChart.action") //饼状图
	public Object bingChart(String start_time, String end_time) throws Exception {
		String endTime = DateUtil.addOneDay(end_time);
		map.put("start_time", start_time);
		map.put("end_time", endTime);
		return userService.bingChart(map);
	}
	
	@ResponseBody
	@RequestMapping(value = "/zhuChart.action") //柱状图
	public Object zhuChart(String start_year, String end_year) {
		map.put("start_year", start_year);
		map.put("end_year", end_year);
		return userService.zhuChart(map);
	}
}
