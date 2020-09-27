package com.fx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fx.entity.Dictionary;
import com.fx.service.DictService;
import com.google.gson.Gson;

@Controller
@RequestMapping
public class DictCtrl {
	@Autowired
	private DictService dictService;
	private Dictionary dict;
	
	private static Gson gson = new Gson();	
	List<Dictionary> dictList = new ArrayList<Dictionary>();

	@ResponseBody
	@RequestMapping(value = "/listDict.action")
	public Object listBy(String dict_type) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dict_type", dict_type);
		return dictService.listDict(map);
	}
}
