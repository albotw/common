package com.generic.misc;

public class Gen_Bin {
	public static String method(int index, String s) {
		if (index == 0) {
			s += " ";
			return s;
		} else {
			return method(index - 1, s + "0") + method(index - 1, s + "1");
		}
	}
}
