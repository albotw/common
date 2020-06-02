package com.generic.misc;

public class Gen_Fibo {
	public static String method(int index, String s) {
		if (index == 0) {
			s += " ";
			return s;
		} else if (index == 1) {
			return method(index - 1, s + "0") + method(index - 1, s + "1");
		} else {
			return method(index - 1, s + "0") + method(index - 2, s + "10");
		}
	}
}
