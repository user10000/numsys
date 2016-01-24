package num;

import static java.lang.Math.*;
import java.util.Arrays;
import static num.Analyzer.*;
import java.math.BigInteger;
import static num.NumArrayer.*;
import static num.PrimeTester.millerRabin;

/**
 * Validates titles of positive integers commonly found in both recreational
 * mathematics and number theory.
 *
 * <p>
 * For types of numbers that have accrued multiple titles, the follow
 * prioritization is followed :
 * <ol>
 * <li>
 * The shortest name is used. If they are of the same length then the
 * lexicographically first name is used.
 *
 * <li>
 * If a type of number has a title which is capitalized - due to being named
 * after its observer, or for whatever other reason - that title is used.
 *
 * <li>
 * If a type of number has both titles of multiple and singular words, the
 * singular word is used.
 *
 * <li>
 * Only alphabetic characters are kept, i.e., non-English characters, hyphens,
 * whitespaces, etc., are removed. Accented characters are replaced with their
 * most visually similar counterpart in the English alphabet.
 * <li>
 * If a type of number's title as thus established is longer than 12 characters,
 * it may be shortened by
 * <ul>
 * <li>removing end syllables from the end of multisyllabic words, in order of
 * occurrence until the length limitation is satisfied.
 * <li>acronym (especially if one is already used).
 * </ul>
 * </ol>
 *
 * The documentation of each titling method in this class serves to
 * describe the type of number it will return {@code true} for and provide
 * remarks regarding those numbers that the user may find interesting.
 *
 *
 * @author Guest
 */
public class Titler implements Tabler, OEISUser {

    private Titler() {
    }

    /**
     * 
     * @param n
     * @return
     */
    public static boolean armstrong(long n) {
        if (negative(n)) return false;
        int[] digits = digits(n);
        return n == sigma(digits, x -> XPOWY[x][digits.length]);
    }

    public static boolean abundant(long n) {
        if (!positive(n) || perfect(n)) return false;

        if (n % 2 != 0) {
            if (n < A047802[1]) return false;

            if (n % 3 != 0) {
                if (n < A047802[2]) return false;

                if (n % 5 != 0) return false;
            }
        }

        return abundance(n) > 0;
    }

    public static boolean automorphic(long n) {
        return (n * n - n) % POW10[len(n)] == 0;
    }

    public static boolean canouchi(long n) {
        return n == 0 || n == 1 || n == 3435 || n == 438579088;
        /*
         if (negative(n) || n > A046253[A046253.length - 1]) return false;
         return Arrays.binarySearch(A046253, n) >= 0;
         */
    }

    public static boolean carol(long n) {
        int shift = 0;
        while (n % 2 == 1) {
            n >>
        }
    }

    public static boolean deficient(long n) {
        return !perfect(n) && !abundant(n);
    }

    public static boolean happy(long n) {
        if (negative(n)) return false;
        n = sigma(digits(n), i -> i * i);

        while (n > UNHAPPYCYCLE[UNHAPPYCYCLE.length - 1]) {
            n = sigma(digits(n), i -> i * i);
        }

        return isHappy[(int) n];
    }

    public static boolean perfect(long n) {
        return Arrays.binarySearch(A000396, n) >= 0;
    }

    public static boolean pernicious(long n) {
        return prime(digsum(n, 2));
    }

    public static boolean emirp(long n) {
        return prime(reverse(n)) && prime(n);
    }

    public static boolean prime(long n) {
        return millerRabin(n);
    }

    public static boolean even(long n) {
        return n % 2 == 0;
    }

    public static boolean odd(long n) {
        return n % 2 != 0;
    }

    public static boolean positive(long n) {
        return n > 0;
    }

    public static boolean negative(long n) {
        return n < 0;
    }

    public static boolean square(long n) {
        if (negative(n)) return false;
        double sqrt = Math.sqrt(n);
        return sqrt == (int) sqrt;
    }

    public static boolean mersenne(long n) {
        if (negative(n)) return false;
        return (n & (n + 1)) == 0;
    }

    public static boolean proth(long n) {
        return mersenne(n - 2);
    }

    public static boolean leyland(long n) {
        int x = 2, y = 2;
        long guess;
        throw new UnsupportedOperationException("");
    }

    public static boolean curious(long n) {
        if (n < 0) return false;
        return Arrays.binarySearch(A014080, n) >= 0;
        /* 
         Implementation by definition.
         
         long sum = 0;
         for (int i : digits(n)) {
         sum += FACTORIAL[i];
         }
         return n == sum;
         */
    }

    public static boolean dudeney(long n) {
        if (n < 0) return false;
        return Arrays.binarySearch(A061209, n) >= 0;
        /*
         Implementation by definition.
         
         if (n < 1) return false;
         int sum = digitsum(n);
         return n == digitsum(n) * digitsum(n) * digitsum(n);
         */
    }

    public static boolean sumproduct(long n) {
        if (n < 0) return false;
        return Arrays.binarySearch(A038369, n) >= 0;
        /*
         Implementation by definiton.
        
         return n === sum(digits(n)) * product(digits(n));
         */
    }

    public static boolean pdi(long n) {
        if (negative(n) || n > A023052[A023052.length - 1]) return false;
        return Arrays.binarySearch(A023052, n) >= 0;

        /*
         /*
         Implementation by definition, with basic optimizations.
         Essentially applies this formula :
         c * d ^ k
         where d is a digit 0-9 and c is its count in the number. k is the power 
         that this method attempts to establish. The sum S is then computed 
         against all digits d. k is incremented until n no longer exceeds S
         and n and S are then compared to provide the final result.
        
         */
        /*
         int[] digits = digits(n);
         // count of each digit 0...9 (then raised to a power)
         long[] count = new long[10];
         long sum = count[1]; // 1^k is constant
         for (int i : digits) {
         count[i]++;
         sum += i;
         }
        O(log n)
         if (count[0] + count[1] == digits.length) {
         return false; // 0^k and 1^k never change. 
         // 0 and 1 are caught by the second statement
         }
        O(1)
         

         while (sum < n) {
         sum = count[1]; 
         for (int i = 2; i < count.length; i++) {
         count[i] *= i;
         sum += count[i];
         }
         }
        
         return n == sum;
         */
    }

    public static boolean constantbase(long n) {
        if (negative(n)) return false;

        final BigInteger N = BigInteger.valueOf(n);

        int[] digits = digits(n);

        BigInteger base = BigInteger.ZERO;

        BigInteger sum = BigInteger.ZERO;

        while (sum.compareTo(N) < 0) {
            sum = BigInteger.ZERO;
            base = base.add(BigInteger.ONE);
            for (int i = 0; i < digits.length; i++) {
                sum = sum.add(base.pow(digits[i]));
            }

        }

        return N.compareTo(sum) == 0;
    }

    public static boolean palindromic(long n) {
        int[] digits = digits(n);
        for (int l = 0, r = digits.length - 1; l < digits.length / 2; l++, r--) {
            if (digits[l] != digits[r]) {
                return false;
            }
        }
        return true;
    }

    public static boolean triangular(long n) {
        if (negative(n)) return false;
        long discriminant = 1 + 8 * n;
        return square(discriminant);
    }

    public static boolean pentagonal(long n) {
        if (negative(n)) return false;
        long discriminant = 1 + 24 * n;
        int sqrt = (int) sqrt(discriminant);
        return sqrt * sqrt == discriminant && sqrt % 6 == 5;
    }

    public static boolean fibonacci(long n) {
        return square(5 * n * n - 4) || square(5 * n * n + 4);
    }

    public static boolean repdigit(long n) {
        return Arrays.binarySearch(REPDIGIT, n) >= 0;
        /*
         Implementation by definition.
        
         int digit = (int) n % 10;
         long repdigit = digit * ((POW10[len(n)] - 1) / 9);
         return n == repdigit;
         */
    }

    public static boolean pandigital(long n) {
        if (n % 9 != 0) return false;
        int[] digits = digits(n);
        boolean[] digitPresent = new boolean[10];
        for (int i : digits) {
            if (digitPresent[i]) {
                return false;
            }
            digitPresent[i] = true;
        }
        return true;
    }

    public static boolean hcn(long n) {
        if (n == 0) return false;
        boolean flag = false;
        int lastcnt = 0, cnt;
        for (long i : A000040) {
            cnt = 0;
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                    cnt++;
                }

                if (cnt > lastcnt && lastcnt != 0) {
                    return false;
                }
            }
            else {
                return n == 1 || lastcnt != 0;
            }
        }
        return false;
    }

    public static boolean niven(long n) {
        if (!positive(n)) return false;
        return n % digsum(n) == 0;
    }

    public static boolean nivenmorphic(long n) {
        // All positive integers are provably nivenmorphic, except 11.
        return positive(n) && n != 11;
    }

    public static boolean mhn(long n) {
        int digsum = digsum(n);
        return n % digsum == 0 && niven(n / digsum);
    }

    public static boolean keith(long n) {
        if (n < 10) return false;

    }
}
