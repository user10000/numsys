package num;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Guest
 */
public class LongArrayer {

    long[] arr;
    public final int length;

    public LongArrayer(long[] arr) {
        this.arr = arr;
        this.length = arr.length;
    }

    public static LongArrayer of(long[] arr) {
        return new LongArrayer(arr.clone());
    }

    public long at(int i) {
        return arr[i];
    }

    public boolean contains(long n) {
        return indexOf(n) != -1;
    }

    public long indexOf(long n) {
        for (int j = 0; j < arr.length; j++) {
            if (n == arr[j]) {
                return j;
            }
        }
        return -1;
    }

    public double average() {
        return 1.0 * NumArrayer.sum(arr) / length;
    }

    public long max() {
        long max = arr[0];
        if (max == Integer.MAX_VALUE) {
            return max;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public long min() {
        long min = arr[0];
        if (min == Integer.MIN_VALUE) {
            return min;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > min) {
                min = arr[i];
            }
        }

        return min;
    }

    public long sum() {
        return NumArrayer.sum(arr);
    }
}
