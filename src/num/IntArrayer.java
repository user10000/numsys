/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package num;

import java.util.Arrays;

/**
 *
 * @author Guest
 */
public class IntArrayer {

    int[] arr;
    public final int length;

    private static final int DEFAULT_LENGTH = 20;
    
    public IntArrayer() {
        throw new UnsupportedOperationException("");
    }
    
    public IntArrayer(int[] arr) {
        this.arr = arr;
        this.length = arr.length;
    }
    
    public static IntArrayer of(int... ints) {
        return new IntArrayer(ints);
    }
    
    public int at(int i) {
        return arr[i];
    }
    
    public boolean contains(int n) {
        return indexOf(n) != -1;
    }
    
    public int indexOf(int n) {
        for (int j = 0; j < arr.length; j++) {
            if (n == arr[j]) {
                return j;
            }
        }
        return -1;
    }

    public double average() {
        return 1.0 * sum() / length;
    }
    
    public int max() {
        int max = arr[0];
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

    public int min() {
        int min = arr[0];
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
    
    public IntArrayer sorted() {
        int[] copy = arr.clone();
        Arrays.sort(copy);
        return new IntArrayer(copy);
    }
    
    
}
