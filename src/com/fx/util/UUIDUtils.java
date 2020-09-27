package com.fx.util;

import java.util.UUID;

public class UUIDUtils {
	//生成随机字符串
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
