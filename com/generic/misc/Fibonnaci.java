package com.generic.misc;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Fibonnaci {
    public static int FibonacciRecursive(int n) {
        if (n > 2) {
            return (FibonacciRecursive(n - 1) + FibonacciRecursive(n - 2));
        } else {
            if (n == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static int FibonacciIterative(int n) {
        int a = 0;
        int b = 1;

        // int totalC = 0;
        for (int i = 1; i < n; i++) {

            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static double FibonacciNbOr(double n) {
        double val = ((sqrt(5) / 5) * pow(((1 + sqrt(5)) / 2), n) - (sqrt(5) / 5) * pow(((1 - sqrt(5)) / 2), n));
        return val;
    }
}