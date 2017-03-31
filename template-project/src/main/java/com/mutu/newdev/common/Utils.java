package com.mutu.newdev.common;

public class Utils {
	
	public static boolean isEmpty(String val) {
		if(val != null && !val.isEmpty()) {
			return true;
		}
		return false;
	}
}
