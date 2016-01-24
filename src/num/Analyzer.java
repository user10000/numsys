/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package num;

import static num.Titler.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static num.NumArrayer.*;
import static num.Algorithms.*;
import static java.lang.Math.*;

/**
 * Evaluates properties of numbers, as well as their relation to one other in
 * certain ways.
 *
 * @author Thurman
 */
public class Analyzer {

    private static final int DEFAULT_RADIX = 10;

    private static void radixCheck(int radix) {
        if (radix < 2) {
            throw new IllegalArgumentException("Invalid radix: " + radix);
        }
    }

    private static void radixCheck(int radix, int maxRadix) {
        radixCheck(radix);
        if (radix > maxRadix) {
            throw new IllegalArgumentException("Radix too large: " + radix);
        }
    }

    public static int abundance(int n) {
        return (int) sum(pdivs(n)) - n;
    }

    public static long abundance(long n) {
        return sum(pdivs(n)) - n;
    }

    public static int len(int n) {
        return len(n, DEFAULT_RADIX);
    }

    /**
     * Returns the number of digits needed to represents an {@code int} in the
     * given radix, disregarding any sign.
     */
    public static int len(int n, int radix) {
        radixCheck(radix);
        n = abs(n);

        int len = 1;
        long min = radix - 1;

        while (n > min) {
            n -= min;
            min *= radix;
            len++;
        }

        return len;
    }

    public static int len(long n) {
        return len(n, DEFAULT_RADIX);
    }

    /**
     * For radices 2 &le r &le Character.MAX_VALUE (36)
     */
    private static final long[] overflowpt = {-1, -1, 4611686018427387904L,
        8105110306037952534L, 3458764513820540928L, 5960464477539062500L,
        3948651115268014080L, 3351275184499704042L, 8070450532247928832L,
        1200757082375992968L, 9000000000000000000L, 5054470284992937710L,
        2033726847845400576L, 7984999310198158092L, 2022385242251558912L,
        6130514465332031250L, 1080863910568919040L, 2694045224950414864L,
        6371827248895377408L, 756953702320627062L, 1556480000000000000L,
        3089447554782389220L, 5939011215544737792L, 482121737504447062L,
        839967991029301248L, 1430511474609375000L, 2385723916542054400L,
        3902460517721977146L, 6269893157408735232L, 341614273439763212L,
        513726300000000000L, 762254306892144930L, 1116892707587883008L,
        1617347408439258144L, 2316231840055068672L, 3282671350683593750L,
        4606759634479349760L};

    public static int len(long n, int radix) {
        radixCheck(radix);
        n = abs(n);

        int len = 1;
        long min = radix - 1;
        while (n > min) {
            len++;
            if (min == overflowpt[radix]) break;
            n -= min;
            min *= radix;

        }

        return len;
    }

    public static int reverse(int n) {
        return reverse(n, DEFAULT_RADIX);
    }

    public static int reverse(int n, int radix) {
        radixCheck(radix);
        int r = n % radix;
        n /= radix;
        while (n > 0) {
            r *= radix;
            r += n % radix;
            n /= radix;
        }
        return r;
    }

    public static long reverse(long n) {
        return reverse(n, DEFAULT_RADIX);
    }

    public static long reverse(long n, int radix) {
        radixCheck(radix);
        long r = n % radix;
        n /= radix;
        while (n > 0) {
            r *= radix;
            r += n % radix;
            n /= radix;
        }
        return r;
    }

    public static int[] digits(long n) {
        return digits(n, DEFAULT_RADIX);
    }

    public static int[] digits(long n, int radix) {
        radixCheck(radix, Integer.MAX_VALUE);
        n = Math.abs(n);

        int[] digits = new int[len(n)];

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (int) (n % radix);
            n /= radix;
        }
        return digits;
    }

    public static byte[] byteDigits(long n) {
        return byteDigits(n, DEFAULT_RADIX);
    }

    public static byte[] byteDigits(long n, int radix) {
        radixCheck(radix, Byte.MAX_VALUE);
        n = Math.abs(n);

        byte[] digits = new byte[len(n)];

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (byte) (n % radix);
            n /= radix;
        }
        return digits;
    }

    public static int digsum(long n) {
        return Analyzer.digsum(n, DEFAULT_RADIX);
    }

    public static int digsum(long n, int radix) {
        radixCheck(radix);

        n = Math.abs(n);
        int sum = 0;
        while (n > 0) {
            sum += n % radix;
            n /= radix;
        }
        return sum;
    }

    public static int digroot(long n) {
        return digroot(n, DEFAULT_RADIX);
    }

    public static int digroot(long n, int radix) {
        radixCheck(radix);
        return (int) (1 + n % (radix - 1));
    }

    public static int[] divs(int n) {
        List<Integer> lst = new ArrayList();
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                lst.add(i);
                lst.add(n / i);
            }
        }
        Collections.sort(lst);
        return lst.stream().mapToInt(x -> x).toArray();
    }

    public static int[] pdivs(int n) {
        IntList lst = new IntList();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                lst.add(i);
            }
        }
        return lst.toArray();
    }

    public static long[] pdivs(long n) {
        List<Long> lst = new ArrayList();
        for (long i = (long) Math.sqrt(n); i > 1; i--) {
            if (n % i == 0) {
                lst.add(0, i);
            }
        }
        lst.add(0, 1L);
        return lst.stream().mapToLong(x -> x).toArray();
    }

    public static int gcd(int... arr) {
        return Algorithms.binarygcd(arr);
    }

    public static int gcd(int a, int b) {
        return Algorithms.binarygcd(a, b);
    }

    public static int[] pfactors(int n) {
        List<Integer> pfactors = new ArrayList();
        int i = 2;
        while (n > 1) {
            while (n % i == 0) {
                pfactors.add(i);
                n /= i;
            }
            i++;
        }
        return pfactors.stream().mapToInt(x -> x).toArray();
    }

    public static boolean quadres(int a, int p) {
        if (!prime(p)) throw new IllegalArgumentException(
                    "Nonprime modulus: " + p);
        return quadres0(a, p);
    }

    protected static boolean quadres0(int a, int p) {
        // break a down into the smallest positive representation of a mod p
        a %= p;
        if (a < 0) a += p;
        if (a > p / 2) a = p - a;
        for (int i = 0; i <= p / 2; i++) {
            if ((a - i * i) % p == 0) {
                return true;
            }
        }
        return false;
    }

    public static int legendre(int a, int p) {
        if (!prime(p)) throw new IllegalArgumentException(
                    "Nonprime modulus: " + p);
        return legendre0(a, p);
    }

    private static int legendre0(int a, int p) {
        a %= p;
        if (a == 0) return 0;
        return quadres(a, p) ? 1 : -1;
    }

    public static int jacobi(int a, int n) {
        System.out.printf("(%s, %s) = ", a, n);
        if (even(n)) throw new IllegalArgumentException("Even modulus: " + n);
        if (a == n - 1) return jacobin1(n);
        if (a == 2) return jacobi2(n);
        if (n == 1) return 1;
        a %= n;
        if (gcd(a, n) > 1) return 0;
        int[] sd = sdform(a);
        int coeff = (int) Math.pow(jacobi2(n), sd[0]);
        System.out.printf("%s *", coeff);
        return coeff * jacobi(n, sd[1]);
    }

    /**
     *
     */
    public static int jacobin1(int n) {
        if (n % 4 == 1) {
            return 1;
        }
        return -1;
    }

    /**
     * Returns jacobi(2, n).
     *
     * @param n an odd
     * @return
     */
    public static int jacobi2(int n) {
        if (n % 8 == 1 || n % 8 == 7) {
            return 1;
        }
        return -1;
    }

    public static int mersennepow(long n) {
        if (!mersenne(n)) return -1;
        n++;
        return log2(n);
    }

    /**
     * Returns a {@code long} array containing two values such that the
     * following equation is satisfied:
     * <p>
     * n = 2<sup>arr[0]</sup> * arr[1], where n is the value provided.
     *
     *
     * @param n the value to convert to s-d form
     * @return an array of two integers such that pow(2, arr[0]) * arr[1] equals
     * the value provided
     */
    public static long[] sdform(long n) {
        int s = 0;
        while (n % 2 == 0 && n != 0) {
            s++;
            n /= 2;
        }
        return new long[]{s, n};
    }

    private static int[] sdform(int n) {
        int s = 0;
        while (n % 2 == 0 && n != 0) {
            s++;
            n /= 2;
        }
        return new int[]{s, n};
    }

}
