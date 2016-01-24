/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package num;

import static java.lang.Math.*;
import java.util.*;
import java.util.function.IntFunction;
import java.util.function.LongToIntFunction;
import static num.Analyzer.gcd;
import static num.Titler.positive;
import static num.Titler.square;

/**
 *
 * @author Guest
 */
public class Algorithms {

    public static class Factors {

        public static int pollardrho(int n) {
            return pollardrho(n, 2);
        }

        /**
         * Returns a factor of an
         *
         * @param n
         * @param seed
         * @return
         */
        public static int pollardrho(int n, int seed) {
            if (!positive(n))
                throw new IllegalArgumentException("Untestable for factors: " + n);
            if (n == 1) return 1;
            int x = seed, y = seed, d = 1;
            LongToIntFunction f = z -> (int) (z * z + 1) % n;
            while (d == 1) {
                x = f.applyAsInt(x);
                y = f.applyAsInt(f.applyAsInt(y));
                d = gcd(abs(x - y), n);
            }
            return d;
        }

        public static int fermatfact(int n) {
            int a = (int) sqrt(n);
            int b2 = a * a - n;
            while (!square(b2)) {
                a++;
                b2 = a * a - n;
            }
            return a + (int) sqrt(b2);
        }
    }

    public static int euclideangcd(int... arr) {
        if (arr.length == 0) return 1;
        if (arr.length == 1) return arr[0];

        Arrays.sort(arr);

        int gcd = Algorithms.euclideangcd(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            if (gcd == 1) break;
            gcd = Algorithms.euclideangcd(arr[i], arr[i - 1], gcd);
            while (i < arr.length && arr[i] == arr[i - 1]) i++;
        }

        return gcd;
    }

    private static int euclideangcd(int x, int y, int z) {
        return euclideangcd(euclideangcd(x, y), z);
    }

    public static int euclideangcd(int x, int y) {
        // Swaps the two variables so that x >= y
        if (x < y) {
            int t = x;
            x = y;
            y = t;
        }

        if (x == y || y == 0) {
            return x;
        }

        int r = x % y;

        while (r != 0) {
            x = y;
            y = r;
            r = x % y;
        }

        return abs(y == 0 ? x : y);
    }

    public static int binarygcd(int... arr) {
        if (arr.length == 0) return 1;
        if (arr.length == 1) return arr[0];

        Arrays.sort(arr);

        int gcd = binarygcd(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            if (gcd == 1) break;
            gcd = binarygcd(arr[i], arr[i - 1], gcd);
            while (i < arr.length && arr[i] == arr[i - 1]) i++;
        }

        return gcd;
    }

    private static int binarygcd(int x, int y, int z) {
        return binarygcd(binarygcd(x, y), z);
    }

    /**
     * Returns the greatest common divisor (GCD) of two integers.
     *
     * @param x an {@code int} value
     * @param y an {@code int} value
     * @return the greatest common divisor of the two values provided
     */
    public static int binarygcd(int x, int y) {
        if (x == 0) return y;
        if (y == 0) return x;

        x = abs(x);
        y = abs(y);

        int k = 0;

        // while x and y are both even
        while (((x | y) & 1) == 0) {
            x >>= 1;
            y >>= 1;
            k++;
        }

        // x and y share no common multiples of 2 now
        while ((x & 1) == 0) x >>= 1;

        do {
            // x and y share no common multiples of 2 now
            while ((y & 1) == 0) y >>= 1;
            // Swaps the two variables so that x <= y
            if (x > y) {
                int t = x;
                x = y;
                y = t;
            }

            // gcd(x, y) == gcd(x, y - x) (y >= x)
            y -= x;
        } while (y != 0);
        return x << k; // equivalent to (1 << k) * x, or 2^k * x
    }

    /**
     * Modular exponentiation.
     *
     * @param base the base
     * @param exp the exponent
     * @param mask the modulus
     * @return
     */
    public static long powmod(long base, long exp, long mask) {
        base = base % mask;
        if (base == 0 || base == 1) return base;

        long product = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                product = schragemult(product, base, mask);
                exp--;
            }
            base = schragemult(base, base, mask);
            exp /= 2;
        }

        return product;
    }

    /**
     * Calculates the product of two {@code long} values against a given modulus
     * in such a way that the result is still accurate (to the maximum
     * {@code long} precision} even if the product overflows.
     *
     * @param a
     * @param b
     * @param m
     * @return
     */
    static long schragemult(long a, long b, long m) {
        long result;
        if (b > m - 1) {
            result = schragemult(a, b % m, m);
        }
        else if (b == m - 1) {
            result = (m - a) % m;
        }
        else {
            long quot = m / a;
            long rem = m % a;
            if (rem >= quot) {
                result = schragemult(a / 2, b, m);
                result = Long.remainderUnsigned(result + result, m);
                if (a % 2 == 1) {
                    result = Long.remainderUnsigned(result + b, m);
                }
            }
            else {

                result = a * (b % quot) - rem * (b / quot);
                if (result < 0) {
                    result += m;
                }
            }
        }
        return result;
    }

    public static int log2(long bits) {

        int log = 0;

        if ((bits & 0xffffffff00000000L) != 0) { // 2 ^ 32
            bits >>>= 32;
            log = 32;
        }

        if ((bits & 0xffff0000) != 0) { // 2 ^ 16
            bits >>>= 16;
            log += 16;
        }

        if (bits >= 256) {
            bits >>>= 8;
            log += 8;
        }

        if (bits >= 16) {
            bits >>>= 4;
            log += 4;
        }

        if (bits >= 4) {
            bits >>>= 2;
            log += 2;
        }

        return log + (int) (bits >>> 1);
    }

}
