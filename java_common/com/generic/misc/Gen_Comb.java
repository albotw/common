package com.generic.misc;

public class Gen_Comb {
	public static String method(int n, int k, String s) {
		if (n == 0) {
			s += " ";
			return s;
		} else if (k == 0 && n != 0) {
			return method(n - 1, k, s + "0");
		} else if (k == n && k != 0) {
			return method(n - 1, k - 1, s + "1");
		} else if (n > k && k > 0) {
			return method(n - 1, k, s + "0") + method(n - 1, k - 1, s + "1");
		} else {
			return s;
		}
	}
}
