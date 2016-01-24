/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package num;

import java.util.function.*;

/**
 *
 * @author Guest
 */
public class NumArrayer {

    public static long sum(int[] arr) {
        return sigma(arr, (IntToLongFunction) null);
    }


    public static long sigma(int[] arr, IntToLongFunction f) {
        long sum = 0;

        if (f == null) {
            for (int i : arr) {
                sum += i;
            }
        }
        else {
            for (int i : arr) {
                sum += f.applyAsLong(i);
            }
        }

        return sum;
    }

    /**
     * Calculates the sum of an strictly decreasing infinite sequence beginning with index of
     * summation 1 and ending when the maximum {@code double} precision is
     * reached - or, if that is never reached, index {@link Integer.MAX_VALUE}.
     * @param f
     * @return
     */
    public static double sigma(IntToDoubleFunction f) {
        int x = 1;
        double sum = 0.0;
        double prev;
        double diff = Double.MAX_VALUE;
        do {
            prev = sum;
            sum += f.applyAsDouble(x);
            if (sum - prev > diff) {
                throw new IllegalArgumentException("sequence does not converge");
            }
            diff = sum - prev;
            x++;
        } while (diff > 0 && x <= Integer.MAX_VALUE);
        return sum;
    }

    public static long product(int[] arr) {
        return pi(arr, (IntToLongFunction) null);
    }

    public static long pi(int[] arr, IntToLongFunction f) {
        long product = 1;

        if (f == null) {
            for (int i : arr) {
                product *= i;
            }
        }
        else {
            for (int i : arr) {
                product *= f.applyAsLong(i);
            }
        }

        return product;
    }

    public static long sum(long[] arr) {
        long sum = 0;
        for (long l : arr) {
            sum += l;
        }
        return sum;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
