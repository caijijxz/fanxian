package com.fx.entity;

public class Chart {
	String type;		//支付类型
	Float price_sum;	//价格总和
	String month;		//月份	
	String year;		//年份
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getPrice_sum() {
		return price_sum;
	}
	public void setPrice_sum(Float price_sum) {
		this.price_sum = price_sum;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

}
