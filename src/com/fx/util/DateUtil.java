package com.fx.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 十月
 * @date 2019年12月6日
 */
public class DateUtil {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String addOneDay(String date) throws Exception {
		String classDateString = date;
		Date classDate = sdf2.parse(classDateString);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(classDate);
		calendar.add(Calendar.DAY_OF_MONTH, +1);
		classDate = calendar.getTime();
		String newDate = sdf2.format(classDate);
		return newDate;
	}
}
