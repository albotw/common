package com.generic.misc;

public class Nombre_Stirling {
	// pour vérification regarder nombres de 2e espece
	public static int method(int n, int k) {
		if (k == 1 || k == n) {
			return 1;
		} else if (1 < k && k < n) {
			return method(n - 1, k - 1) + k * method(n - 1, k);
		} else {
			return 0;
		}
	}
}
