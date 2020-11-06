using System;
using System.Collections;
using System.Collections.Generic;
using static System.Math;

namespace csharp_common
{
    public class Equations
    {
        public static int RandomizedInt(int a, int b)
        {
            Random rand = new Random();
            if (a < b)
            {
                return rand.Next(a, ++b);
            }
            else
            {
                return rand.Next(b, a++);
            }
        }

        public static double RandomizedDouble(double a, double b)
        {
            Random rand = new Random();
            if (a < b)
            {
                return a + (rand.NextDouble() * b);
            }
            else
            {
                return b + (rand.NextDouble() * b);
            }
        }

        public static double VectorialDistance(double x1, double y1, double x2, double y2)
        {
            return Sqrt(Pow(x2 - x1, 2.0) + Pow(y2 - y1, 2.0));
        }

        public static double VectorialDistance(int x1, int y1, int x2, int y2)
        {
            return VectorialDistance(Convert.ToDouble(x1), Convert.ToDouble(y1), Convert.ToDouble(x2), Convert.ToDouble(y2));
        }

        public static double pow_d(double a, double n)
        {
            if (n != 0)
            {
                if (n % 2 == 0)
                {
                    return pow_d(a, Floor(n / 2)) * pow_d(a, Floor(n / 2));
                }
                else
                {
                    return pow_d(a, Floor(n / 2)) * pow_d(a, Floor(n / 2)) * a;
                }
            }
            else
            {
                return 1;
            }
        }

        public static double pow_i(int a, int n)
        {
            List<int> list = new List<int>();

            while(n > 0)
            {
                list.Add(n % 2);
                n = n / 2;
            }

            int nombre = 1;
            foreach(int i in list)
            {
                if (i == 1)
                {
                    nombre = nombre * nombre * a;
                }

                if (i == 0)
                {
                    nombre = nombre * nombre;
                }
            }

            list.Clear();

            return nombre;
        }
    }
}
