package com.generic.misc;

public class Gen_Dyck {
	// n = longueur de la chaine
	// k = nombre d'instances de 1/0
	public static String method(int n, int k, String s) {
		if (n == 0) {
			s += " ";
			return s;
		} else if (n == 2 * k && 2 * k >= 1) {
			return method(n - 1, k - 1, s + "1");
		} else if (k == 0 && n >= 1) {
			return method(n - 1, k, s + "0");
		} else if (n > k && k >= 1) {
			return method(n - 1, k, s + "0") + method(n - 1, k - 1, s + "1");
		} else {
			return s;
		}
	}
}
