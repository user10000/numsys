/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package num;

import static num.NumArrayer.*;
import static java.lang.Math.*;

/**
 *
 * @author Guest
 */
public class Functions implements Tabler {

    public static double rzf(int exp) {
        return sigma(x -> 1 / pow(x, exp));
    }

    public static long fact(int base) {
        if (base < 0 || base > 20) {
            throw new IllegalArgumentException("ans > Long.MAX_VALUE");
        }
        return FACTORIAL[base];
    }
}
