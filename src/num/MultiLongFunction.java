/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package num;

import java.util.function.LongUnaryOperator;

/**
 *
 * @author Guest
 */
@FunctionalInterface
public interface MultiLongFunction {
    
    Long of(long... args);
    
}
