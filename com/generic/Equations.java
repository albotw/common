package com.generic;

import java.util.ArrayList;
import static java.lang.Math.floor;

public class Equations {
    public static int RandomizedInt(int a, int b) {
        if (a < b) {
            b++;
            return (int) (a + (b - a) * Math.random());
        } else {
            a++;
            return (int) (b + (a - b) * Math.random());
        }
    }

    public static double VectorialDistance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0));
    }

    public static double pow_d(double a, double n) {
        if (n != 0) {
            if (n % 2 == 0) {
                return pow_d(a, floor(n / 2)) * pow_d(a, floor(n / 2));
            } else {
                return pow_d(a, floor(n / 2)) * pow_d(a, floor(n / 2)) * a;
            }
        } else {
            return 1;
        }
    }

    public static int pow_i(int a, int n) {
        ArrayList<Integer> al = new ArrayList<Integer>();

        while (n > 0) {
            al.add(n % 2);
            n = n / 2;
        }

        int nombre = 1;
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) == 1) {
                nombre = nombre * nombre * a;
            }
            if (al.get(i) == 0) {
                nombre = nombre * nombre;
            }
        }
        al.clear();

        return nombre;
    }

    public int[][] matrix_pow(int[][] m, int n) {
        if (n == 0) {
            int[][] id = new int[2][2];
            id[0][0] = 1;
            id[1][1] = 1;
            return id;
        } else {
            int[][] temp = matrix_pow(m, n / 2);
            temp = matrix_prod(temp, temp);
            if (n % 2 != 0) {
                temp[0][0] *= n;
                temp[0][1] *= n;
                temp[1][0] *= n;
                temp[1][1] *= n;
            }

            return temp;
        }
    }

    public int[][] matrix_prod(int[][] m, int[][] n) {
        int[][] output = new int[2][2];
        output[0][0] = m[0][0] * n[1][0];
        output[0][1] = m[0][0] * n[1][1];
        output[1][0] = m[0][1] * n[1][0];
        output[1][1] = m[1][1] * n[1][1];
        return output;
    }
}