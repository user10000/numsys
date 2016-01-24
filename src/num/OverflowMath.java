/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package num;

import static java.lang.Math.*;

/**
 *
 * @author Guest
 */
public class OverflowMath {
        
    public static Long multiply(Long x, Long y) {
        if (x == null || y == null) return null;
        long p = x * y;
        long ax = abs(x);
        long ay = abs(y);
        if (((ax | ay) >>> 31 != 0)) {
            // Some bits greater than 2^31 that might cause overflow
            // Check the result using the divide operator
            // and check for the special case of Long.MIN_VALUE * -1
            if (((y != 0) && (p / y != x))
                || (x == Long.MIN_VALUE && y == -1)) {
                return null;
            }
        }
        return p;
    }
    
    public static Long subtract(Long x, Long y) {
        if (x == null || y == null) return null;
        long diff = x - y;
        // HD 2stop2 Overflow iff the arguments have different signs and
        // the sign of the result is different than the sign of x
        if (((x ^ y) & (x ^ diff)) < 0) {
            return null;
        }
        return diff;
    }
    
    public static Long add(Long x, Long y) {
        if (x == null || y == null) return null;
        long r = x + y;
        // HD 2-12 Overflow iff both arguments have the opposite sign of the result
        if (((x ^ r) & (y ^ r)) < 0) {
            return null;
        }
        return r;
    }
    
    public static Long multiply(Integer x, Long y) {
        if (x == null || y == null) return null;
        long p = x * y;
        long ax = abs(x);
        long ay = abs(y);
        if (((ax | ay) >>> 31 != 0)) {
            // Some bits greater than 2^31 that might cause overflow
            // Check the result using the divide operator
            // and check for the special case of Long.MIN_VALUE * -1
            if (((y != 0) && (p / y != x))
                || (x == Long.MIN_VALUE && y == -1)) {
                return null;
            }
        }
        return p;
    }
    
    public static Long subtract(Integer x, Long y) {
        if (x == null || y == null) return null;
        long diff = x - y;
        // HD 2stop2 Overflow iff the arguments have different signs and
        // the sign of the result is different than the sign of x
        if (((x ^ y) & (x ^ diff)) < 0) {
            return null;
        }
        return diff;
    }
    
    public static Long add(Integer x, Long y) {
        if (x == null || y == null) return null;
        long r = x + y;
        // HD 2-12 Overflow iff both arguments have the opposite sign of the result
        if (((x ^ r) & (y ^ r)) < 0) {
            return null;
        }
        return r;
    }
    
    public static Long multiply(Long x, Integer y) {
        if (x == null || y == null) return null;
        long p = x * y;
        long ax = abs(x);
        long ay = abs(y);
        if (((ax | ay) >>> 31 != 0)) {
            // Some bits greater than 2^31 that might cause overflow
            // Check the result using the divide operator
            // and check for the special case of Long.MIN_VALUE * -1
            if (((y != 0) && (p / y != x))
                || (x == Long.MIN_VALUE && y == -1)) {
                return null;
            }
        }
        return p;
    }
    
    public static Long subtract(Long x, Integer y) {
        if (x == null || y == null) return null;
        long diff = x - y;
        // HD 2stop2 Overflow iff the arguments have different signs and
        // the sign of the result is different than the sign of x
        if (((x ^ y) & (x ^ diff)) < 0) {
            return null;
        }
        return diff;
    }
    
    public static Long add(Long x, Integer y) {
        if (x == null || y == null) return null;
        long r = x + y;
        // HD 2-12 Overflow iff both arguments have the opposite sign of the result
        if (((x ^ r) & (y ^ r)) < 0) {
            return null;
        }
        return r;
    }
    
    public static Integer multiply(Integer x, Integer y) {
        if (x == null || y == null) return null;
        int p = x * y;
        int ax = abs(x);
        int ay = abs(y);
        if (((ax | ay) >>> 31 != 0)) {
            // Some bits greater than 2^31 that might cause overflow
            // Check the result using the divide operator
            // and check for the special case of Integer.MIN_VALUE * -1
            if (((y != 0) && (p / y != x))
                || (x == Integer.MIN_VALUE && y == -1)) {
                return null;
            }
        }
        return p;
    }
    
    public static Integer subtract(Integer x, Integer y) {
        if (x == null || y == null) return null;
        int diff = x - y;
        // HD 2stop2 Overflow iff the arguments have different signs and
        // the sign of the result is different than the sign of x
        if (((x ^ y) & (x ^ diff)) < 0) {
            return null;
        }
        return diff;
    }
    
    public static Integer add(Integer x, Integer y) {
        if (x == null || y == null) return null;
        int r = x + y;
        // HD 2-12 Overflow iff both arguments have the opposite sign of the result
        if (((x ^ r) & (y ^ r)) < 0) {
            return null;
        }
        return r;
    }
    
}
