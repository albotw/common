package com.generic.misc;

public class Triangle_Pascal {
	public static int[][] method(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (i == 0 || j == 0) {
					array[i][j] = 1;
				} else {
					array[i][j] = array[i][j - 1] + array[i - 1][j];
				}
			}
		}
		return array;
	}

	public static void displayArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length - i; j++) {
				System.out.print(" " + array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
