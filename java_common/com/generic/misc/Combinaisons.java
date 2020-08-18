package com.generic.misc;

public class Combinaisons {
	public static String method(int n, int k, String s) {
		if (k == 0) {
			s += " ";
			return s;
		} else if (1 <= k && k <= n) {
			return method(n - 1, k, s) + method(n - 1, k - 1, n + "" + s);
		} else {
			return "";
		}
	}
}
