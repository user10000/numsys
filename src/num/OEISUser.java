/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package num;

/**
 * Contains numerical tables (arrays) as provided by OEIS
 * ({@link www.oeis.com}), expanded upon or truncated as necessary. Unless
 * stated otherwise, these tables contain all of their elements representable by
 * {@code long} (-2<sup>63</sup> &le; n &le; 2<sup>63</sup> - 1).
 *
 * <p>
 * Classes implementing this interface declare their use of the tables contained
 * within.
 *
 * @author Guest
 */
public interface OEISUser extends Tabler {

    /**
     * Primes n : n has no divisors except 1 and itself.
     *
     * Contains the first 100 elements.
     */
    long[] A000040
            = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
                61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127,
                131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193,
                197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269,
                271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
                353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431,
                433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503,
                509, 521, 523, 541};

    /**
     * Perfect numbers n : n is equal to the sum of the proper divisors of n.
     */
    long[] A000396
            = {6, 28, 496, 8128, 33550336, 8589869056L, 137438691328L,
                2305843008139952128L};

    /**
     * Primordials n : n is the product of the first i primes.
     */
    long[] A002110
            = {1, 2, 6, 30, 210, 2310, 30030, 510510, 9699690, 223092870,
                6469693230L, 200560490130L, 7420738134810L, 304250263527210L,
                13082761331670030L, 614889782588491410L};

    /**
     * Lucas-Lehmer sequence :
     * <p>
     * n<sub>0</sub> = 4,
     * <p>
     * n<sub>i</sub>= n<sub>i-1</sub><sup>2</sup> - 2.
     */
    long[] A003010
            = {4, 14, 194, 37634, 1416317954, 2005956546822746114L};

    /**
     * Happy numbers n: the sum of the squares of the digits of n equals another
     * happy number, or 1.
     *
     * <p>
     * The positive integer powers of 10 are the only numbers which fulfill the
     * second condition.
     *
     * <p>
     * Contains the first 100 elements.
     */
    long[] A007770
            = {1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91,
                94, 97, 100, 103, 109, 129, 130, 133, 139, 167, 176, 188, 190,
                192, 193, 203, 208, 219, 226, 230, 236, 239, 262, 263, 280, 291,
                293, 301, 302, 310, 313, 319, 320, 326, 329, 331, 338, 356, 362,
                365, 367, 368, 376, 379, 383, 386, 391, 392, 397, 404, 409, 440,
                446, 464, 469, 478, 487, 490, 496, 536, 556, 563, 565, 566, 608,
                617, 622, 623, 632, 635, 637, 638, 644, 649, 653, 655, 656, 665,
                671, 673, 680, 683, 694};

    /**
     * Factorions n : n is equal to the sum of the factorials of each of its
     * digits.
     */
    long[] A014080
            = {1, 2, 145, 40585};

    /**
     * Perfect digit invariants (PDIs) n : n is equal to the sum of some
     * constant power of each of its digits. (0 ^ 0 is considered to be 0 in
     * this and similar contexts.)
     *
     * <p>
     * Note: this naming does not agree with that established by that kept by
     * OEIS, which titles these numbers as the <i>powerful numbers</i>.
     *
     */
    long[] A023052
            = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 4150,
                4151, 8208, 9474, 54748, 92727, 93084, 194979, 548834, 1741725,
                4210818, 9800817, 9926315, 14459929, 24678050, 24678051,
                88593477, 146511208, 472335975, 534494836, 912985153,
                4679307774L, 32164049650L, 32164049651L, 40028394225L,
                42678290603L, 44708635679L, 49388550606L, 82693916578L,
                94204591914L, 564240140138L, 28116440335967L, 233411150132317L,
                4338281769391370L, 4338281769391371L, 21897142587612075L,
                35641594208964132L, 35875699062250035L, 1517841543307505039L,
                3289582984443187032L, 4498128791164624869L, 4929273885928088826L};

    /**
     * Sum-product numbers n : n is equal to the sum of its digits multiplied by
     * the product of its digits.
     *
     */
    long[] A038369
            = {0, 1, 135, 144};

    /**
     * Canouchi numbers n : n is equal to the sum of its digits, each raised to
     * the power of itself. (0 ^ 0 is considered to be 0 in this and similar
     * contexts.)
     */
    long[] A046253
            = {0, 1, 3435, 438579088};

    /**
     * Smallest abundant number n<sub>i</sub> indivisible by any of the first i
     * primes.
     */
    long[] A047802
            = {12, 945, 5391411025L};

    /**
     * Dudeney numbers n : n is equal to the cube of the sum of its digits.
     */
    long[] A061209
            = {1, 512, 4913, 5832, 17576, 19683};

}
