/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package num;

/**
 *
 * @author Guest
 */
public interface Tabler {

    /**
     * The cycle of integers that unhappy numbers of the second power eventually
     * devolve into, in numerical (<b>not</b> relative) order.
     */
    int[] UNHAPPYCYCLE = {4, 16, 20, 37, 42, 58, 89, 145};

    /**
     * Powers of two, n (sub i) : n = 2 ^ i.
     */
    long[] POW2
            = {1, 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576,
                4194304, 16777216, 67108864, 268435456, 1073741824, 4294967296L,
                17179869184L, 68719476736L, 274877906944L, 1099511627776L,
                4398046511104L, 17592186044416L, 70368744177664L,
                281474976710656L, 1125899906842624L, 4503599627370496L,
                18014398509481984L, 72057594037927936L, 288230376151711744L,
                1152921504606846976L, 4611686018427387904L};

    /**
     * Powers of ten, n (sub i) : n = 10 ^ i.
     */
    long[] POW10
            = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000,
                1000000000, 10000000000L, 100000000000L, 1000000000000L,
                10000000000000L, 100000000000000L, 1000000000000000L,
                10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /**
     * Factorials n : n = n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
     */
    long[] FACTORIAL
            = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800,
                479001600, 6227020800L, 87178291200L, 1307674368000L,
                20922789888000L, 355687428096000L, 6402373705728000L,
                121645100408832000L, 2432902008176640000L};

    /**
     * All powers that involve the natural numbers only, up to 10^10.
     */
    long[][] XPOWY
            = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024},
                {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049},
                {1, 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576},
                {1, 5, 25, 125, 625, 3125, 15625, 78125, 390625, 1953125,
                    9765625},
                {1, 6, 36, 216, 1296, 7776, 46656, 279936, 1679616, 10077696,
                    60466176},
                {1, 7, 49, 343, 2401, 16807, 117649, 823543, 5764801, 40353607,
                    282475249},
                {1, 8, 64, 512, 4096, 32768, 262144, 2097152, 16777216,
                    134217728, 1073741824},
                {1, 9, 81, 729, 6561, 59049, 531441, 4782969, 43046721,
                    387420489, 3486784401L},
                {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000,
                    1000000000, 10000000000L}
            };

    /**
     * The lowest strong pseudoprimes of the Miller-Rabin test for the first i 
     * primes as bases. (The last value exceeds the maximum that can be
     * held by a {@code long} value, so {@code Long.MAX_VALUE} is used in place
     * of it.)
     */
    long[] LSPSP = {Long.MIN_VALUE, 2047, 1373653, 25326001, 2152302898747L, 3474749660383L,
        341550071728321L, 3825123056546413051L, Long.MAX_VALUE};

    boolean[] isHappy
            = {false, true, false, false, false, false, false, true, false,
                false, true, false, false, true, false, false, false, false,
                false, true, false, false, false, true, false, false, false,
                false, true, false, false, true, true, false, false, false,
                false, false, false, false, false, false, false, false, true,
                false, false, false, false, true, false, false, false, false,
                false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, true, false, true, false,
                false, false, false, false, false, false, false, true, false,
                false, true, false, false, false, true, false, false, false,
                false, true, false, false, true, false, false, true, false,
                false, true, false, false, true, false, false, false, false,
                false, true, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false,
                false, false, false, true, true, false, false, true, false,
                false, false, false, false, true, false, false, false, false,
                false};

    long[] REPDIGIT
            = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99,
                111, 222, 333, 444, 555, 666, 777, 888, 999, 1111, 2222, 3333,
                4444, 5555, 6666, 7777, 8888, 9999, 11111, 22222, 33333, 44444,
                55555, 66666, 77777, 88888, 99999, 111111, 222222, 333333,
                444444, 555555, 666666, 777777, 888888, 999999, 1111111, 2222222,
                3333333, 4444444, 5555555, 6666666, 7777777, 8888888, 9999999,
                11111111, 22222222, 33333333, 44444444, 55555555, 66666666,
                77777777, 88888888, 99999999, 111111111, 222222222, 333333333,
                444444444, 555555555, 666666666, 777777777, 888888888, 999999999,
                1111111111};
}
