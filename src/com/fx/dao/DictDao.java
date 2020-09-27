package com.fx.dao;

import java.util.List;
import java.util.Map;

import com.fx.entity.Dictionary;

public interface DictDao {

	public List<Dictionary> listDict(Map<String, Object> map);

}
