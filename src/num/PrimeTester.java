/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package num;

import static num.Algorithms.powmod;
import static num.Algorithms.schragemult;
import static num.Analyzer.*;
import static num.Titler.*;

/**
 * Contains various tests regarding the primality of numbers.
 *
 * @author Guest
 */
public class PrimeTester implements OEISUser, Tabler {

    /**
     * The most basic test for primality : trial division.
     *
     * <p>
     * This can be significantly improved by the following :
     *
     * <li> Testing for divisors only below sqrt(n).
     *
     * <li> Caching small primes.
     *
     * <li> A primorial sieve (pregenerated table). Denoting p<sub>k</sub># as
     * the product of the first k primes, we note that any prime must be of the
     * form p<sub>k</sub># ± c' where c' is a noncomposite (i.e., 1 or a prime)
     * less than p<sub>k</sub>#, not including up to and including the kth
     * prime. (This is equivalent to p mod p<sub>k</sub> = c'.)
     *
     *
     * @param n
     * @return
     */
    public static boolean prime(long n) {
        if (n < 1) return false;
        if (n == 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;

            }
        }
        return true;
    }

    /**
     * Returns the primality of a Mersenne number.
     *
     * @param n a value to test for primality
     * @return {@code true} if the value provided is a Mersenne prime, and
     * {@code false} otherwise
     */
    public static boolean LLT(long n) {
        if (n <= 2) return false;
        int p = mersennepow(n);
        if (p == -1) return false;
        int i = 0;
        long s = 4;
        while (i < p - 2) {
            s = (schragemult(s, s, n) - 2) % n;
            i++;
        }
        return s == 0;
    }

    /**
     * Returns the primality of a number based on a deterministic version of the
     * Miller-Rabin probabilistic primality test.
     *
     * @param n a value to test for primality
     * @return the primality of the value provided
     */
    public static boolean millerRabin(long n) {
        boolean isPrime = true;
        for (int i = 0; isPrime && n >= LSPSP[i]; i++) {
            isPrime = isPrime && millerRabinTestAgainst(n, A000040[i]);
        }
        return isPrime;
    }

    /**
     * Applies the Miller-Rabin probabilistic primality (probable prime) test
     * against a specified value to the base of another given value.
     *
     * @param n a value to test for primality
     * @param a the base of the test
     * @return {@code true} if n is a probable prime to base a and {@code false}
     * otherwise
     */
    public static boolean millerRabinTestAgainst(long n, long a) {
        if (n < 3 || n % 2 == 0) return n == 2;

        int s;
        long d;
        {
            long[] sd = sdform(n - 1);
            s = (int) sd[0];
            d = sd[1];
        }

        long x = powmod(a, d, n);
        if (x == 1 || x == n - 1) return true;


        for (; x != 1 && x != n - 1 && s > 0; s--) {
            x = powmod(x, 2, n);
        }

        return x == n - 1;
    }

}
