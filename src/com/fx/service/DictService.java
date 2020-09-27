package com.fx.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fx.dao.DictDao;
import com.fx.entity.Dictionary;

@Service
public class DictService {
	@Autowired
	private DictDao dictDao;
	
	//条件查询
	public List<Dictionary> listDict(Map<String, Object> map) {
		return dictDao.listDict(map);
	}

}
