package com.generic.misc;

public class Gen_Bin_Gray {
	public static String method(int index, String s) {
		return left(index, s);
	}

	private static String left(int index, String s) {
		if (index == 0) {
			s += " ";
			return s;
		} else {
			return left(index - 1, s + "0") + right(index - 1, s + "1");
		}

	}

	private static String right(int index, String s) {
		if (index == 0) {
			s += " ";
			return s;
		} else {

			return left(index - 1, s + "1") + right(index - 1, s + "0");
		}
	}
}
