package com.generic.misc.test;

import com.generic.misc.*;

public class Main {
	public static void main(String[] args) {
		System.out.println("GEN BIN: " + Gen_Bin.method(3, ""));
		System.out.println("GEN BIN GRAY: " + Gen_Bin_Gray.method(3, ""));
		System.out.println("GEN FIBO: " + Gen_Fibo.method(3, ""));
		System.out.println("GEN COMB: " + Gen_Comb.method(4, 2, ""));
		System.out.println("GEN DYCK: " + Gen_Dyck.method(6, 3, ""));
		System.out.println("COMBINAISONS: " + Combinaisons.method(5, 3, ""));
		System.out.println("TRIANGLE PASCAL:");
		Triangle_Pascal.displayArray(Triangle_Pascal.method(new int[8][8]));
		System.out.println();
		System.out.println("COMPOSITIONS: " + Composition.method(3, 3, ""));
		System.out.println("NOMBRE STIRLING: " + Nombre_Stirling.method(6, 3));

		/////////////////////////////////////////////////////////////////////

		System.out.println("CRIBLE ERATOSTHENE: ");
		int[] tabb = CribleErastho.method(100);
		for (int i = 0; i < tabb.length; i++) {
			if (tabb[i] != 0) {
				System.out.print(tabb[i] + " ");
				System.out.println();
			}
		}

		System.out.println("FIBONNACI RECURSIVE: " + Fibonnaci.FibonacciRecursive(4));
		System.out.println("FIBONNACI ITERATIVE: " + Fibonnaci.FibonacciIterative(4));
		System.out.println("FIBONNACI NOMBRE D'OR: " + Fibonnaci.FibonacciNbOr(4.0));

		String m1 = "NICHE";
		String m2 = "CHIEN";

		System.out.println("LEVENSHTEIN: " + Levenshtein.method(m1, m2));

		System.out.println("PLSSC: ");
		int[] sequence = { 3, 5, 6, 1, 4, 2, 7, 4, 9, 6, 8, 5 };
		int[] result = PLSSC.PLSSC_func(sequence);
		PLSSC.display(result);

		System.out.println("PYRAMIDE NOMBRES: ");
		int[][] tab = PyramideNombres.generateRandomTab(10);
		PyramideNombres.display(tab);
		System.out.println();
		int[][] tab2 = PyramideNombres.resolution(tab);
		PyramideNombres.display(tab2);

		int[] tab3 = PyramideNombres.PLC(tab2, tab);
		System.out.println();
		PyramideNombres.display_single(tab3);
		System.out.println();
	}
}
