package com.generic.misc;

public class Composition {
	public static String method(int n, int k, String s) {
		if (k == 0) {
			s += " ";
			return s;
		} else if (k == 1) {
			return s + "" + n;
		} else {
			k = k - 1;
			String tmp = "";
			for (int i = 0; i <= n; i++) {
				tmp += " " + method(n - i, k, s + i);
			}
			return tmp;
		}

	}
}
