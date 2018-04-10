package com.wyh.p2p.util;

import java.lang.reflect.Field;

public class ParamUtil {

	public static boolean isNull(Object obj) {
		for (Field f : obj.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.get(obj) == null || f.get(obj).equals("")) { // 判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
					return false;
				}
			} catch (Exception e) {
			}
		}
		return true;
	}
}
