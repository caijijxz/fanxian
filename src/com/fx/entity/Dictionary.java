package com.fx.entity;

public class Dictionary {
	private Integer dict_id;		//主键
	private Integer dict_value;		//
	private String dict_typename;	//主类
	private Integer dict_type;		//主类编号
	private String dict_name;		//子类
	private Integer dict_order;		//
	
	public Integer getDict_id() {
		return dict_id;
	}
	public void setDict_id(Integer dict_id) {
		this.dict_id = dict_id;
	}
	public Integer getDict_value() {
		return dict_value;
	}
	public void setDict_value(Integer dict_value) {
		this.dict_value = dict_value;
	}
	public String getDict_typename() {
		return dict_typename;
	}
	public void setDict_typename(String dict_typename) {
		this.dict_typename = dict_typename;
	}
	public Integer getDict_type() {
		return dict_type;
	}
	public void setDict_type(Integer dict_type) {
		this.dict_type = dict_type;
	}
	public String getDict_name() {
		return dict_name;
	}
	public void setDict_name(String dict_name) {
		this.dict_name = dict_name;
	}
	public Integer getDict_order() {
		return dict_order;
	}
	public void setDict_order(Integer dict_order) {
		this.dict_order = dict_order;
	}
	
}
