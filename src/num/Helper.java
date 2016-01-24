/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package num;

import java.math.BigInteger;

/**
 *
 * @author Guest
 */
public class Helper {
    public static BigInteger[] intToBigInt(int[] ints) {
        BigInteger[] bigints = new BigInteger[ints.length];
        for (int i = 0 ; i < ints.length ; i++) {
            bigints[i] = BigInteger.valueOf(ints[i]);
        }
        return bigints;
    }

    public static int clog(long bits) {
        
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
        
        return log + (int) ((bits & 2) + (bits & 1)) ;
    }
    
    private static final int DEFAULT_RADIX = 10;
    
    public static long digtonum(int[] digits) {
        return digtolong(digits);
    }

    public static long digtonum(byte[] digits) {
        return digtolong(digits);
    }

    public static int digtoint(int[] digits) {
        return digtoint(digits, DEFAULT_RADIX);
    }

    public static int digtoint(int[] digits, int radix) {
        if (digits.length == 0 || digits.length > DEFAULT_RADIX) {
            throw new IllegalArgumentException(
                    "Illegal int length: " + digits.length);
        }


        int num = 0;

        for (int digit : digits) {
            if (digit < 0 || digit >= radix) {
                throw new IllegalArgumentException(
                        "Illegal digit: " + digit);
            }
            num *= radix;
            num += digit;
        }

        if (num < 0) throw new IllegalArgumentException(
                    "Number greater than Integer.MAX_VALUE");
        return num;
    }

    public static long digtolong(int[] digits) {
        return digtolong(digits, DEFAULT_RADIX);
    }

    public static long digtolong(int[] digits, int radix) {
        if (digits.length == 0 || digits.length > 19) {
            throw new IllegalArgumentException(
                    "Illegal int length: " + digits.length);
        }


        int num = 0;

        for (int digit : digits) {
            if (digit < 0 || digit >= radix) {
                throw new IllegalArgumentException(
                        "Illegal digit: " + digit);
            }
            num *= radix;
            num += digit;
        }

        if (num < 0) throw new IllegalArgumentException(
                    "Number greater than Long.MAX_VALUE");
        return num;
    }

    public static int digtoint(byte[] digits) {
        return digtoint(digits, DEFAULT_RADIX);
    }

    public static int digtoint(byte[] digits, int radix) {
        if (digits.length == 0 || digits.length > DEFAULT_RADIX) {
            throw new IllegalArgumentException(
                    "Illegal int length: " + digits.length);
        }


        int num = 0;

        for (byte digit : digits) {
            if (digit < 0 || digit >= radix) {
                throw new IllegalArgumentException(
                        "Illegal digit: " + digit);
            }
            num *= radix;
            num += digit;
        }

        if (num < 0) throw new IllegalArgumentException(
                    "Number greater than Integer.MAX_VALUE");
        return num;
    }

    public static long digtolong(byte[] digits) {
        return digtolong(digits, DEFAULT_RADIX);
    }

    public static long digtolong(byte[] digits, int radix) {
        if (digits.length == 0 || digits.length > 19) {
            throw new IllegalArgumentException(
                    "Illegal int length: " + digits.length);
        }


        long num = 0;

        for (byte digit : digits) {
            if (digit < 0 || digit >= radix) {
                throw new IllegalArgumentException(
                        "Illegal digit: " + digit);
            }
            num *= radix;
            num += digit;
        }

        if (num < 0) throw new IllegalArgumentException(
                    "Number greater than Long.MAX_VALUE");
        return num;
    }

}
