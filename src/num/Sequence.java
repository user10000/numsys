/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package num;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.lang.Math.*;
import static num.OverflowMath.*;

/**
 *
 * @author Guest
 */
public class Sequence {

    public static LongStream lucasU(int P, int Q) {
        return recursive(
                (long... arg) -> subtract(multiply(P, arg[1]), multiply(Q, arg[0])),
                0, 1
        );
    }

    public static LongStream lucasV(int P, int Q) {
        return recursive(
                (long... arg) -> subtract(multiply(P, arg[1]), multiply(Q, arg[0])),
                2, P
        );
    }
    
    public static LongStream[] lucasUV(int P, int Q) {
        return new LongStream[] {lucasU(P, Q), lucasV(P, Q)};
    }
    
    private static final int[] initFib = {1, 1};

    public static LongStream fibonacci() {
        return fibonacci(initFib[0], initFib[1]);
    }
    
    public static LongStream fibonacci(int f0, int f1) {
        return recursive(
                (long... arg) -> add(arg[1], arg[0]),
                f0, f1
        );
    }

    public static LongStream recursive(MultiLongFunction f, long... initialTerms) {
        if (initialTerms.length == 0) {
            throw new IllegalArgumentException("Recursion needs initial terms");
        }
        else try {
            f.of(initialTerms);
        } catch (ArrayIndexOutOfBoundsException indexc) {
            throw new IllegalArgumentException(
                    "Number of initial terms < Number of function inputs");
        }

        Iterator<Long> it = new Iterator() {
            MultiLongFunction func = f;
            long[] args = initialTerms.clone();
            Long nextCache = null;
            long current;
            int i = 0;

            @Override
            public boolean hasNext() {
                return peek() != null;
            }

            @Override
            public Long next() {
                if (nextCache != null) {
                    current = nextCache;
                    if (i < args.length) i++;
                    nextCache = null;
                }
                else {
                    if (i < args.length) {
                        return args[i++];
                    }
                    else {
                        current = func.of(args);
                    }
                }
                updateArgs(current);
                return current;

            }

            private void updateArgs(long next) {
                System.arraycopy(args, 1, args, 0, args.length - 1);
                args[args.length - 1] = next;
            }

            private Long peek() {
                if (nextCache != null) {
                    return nextCache;
                }
                else if (i < args.length) {
                    return nextCache = args[i];
                }
                else {
                    Long next = func.of(args);
                    nextCache = next;
                    return next;
                }
            }
        };

        int cnt = 0;
        try {
            LongStream.Builder builder = LongStream.builder();
            for (long e : (Iterable<Long>) (() -> it)) {
                builder.add(e);
                cnt++;
            }
            return builder.build();
        }
        catch (OutOfMemoryError memerr) {
            System.out.println(cnt);
            return LongStream.generate(it::next);
        }
    }

    /**
     * Returns an iterative (i.e., index-based) sequence with index beginning at
     * 0 and ending at {@link Integer.MAX_VALUE} inclusive, represented by a
     * {@link java.util.Iterator}.
     *
     * <p>
     * Note: overflow can only be checked in the provided
     * {@linkplain MultiLongFunction}, such as by providing an impossible dummy
     * value.
     *
     *
     * @param f a function operating on and returning {@code long} values
     * @return anM {@code Iterator} representing an iterative sequence
     */
    public static Iterator<Long> iterative(LongUnaryOperator f) {
        return iterative(f, 0);
    }

    public static Iterator<Long> iterative(LongUnaryOperator f, long start) {
        return iterative(f, start, 1);
    }

    public static Iterator<Long> iterative(LongUnaryOperator f, long start, long step) {
        return iterative(f, start, step, Integer.MAX_VALUE);
    }

    public static Iterator<Long> iterative(LongUnaryOperator f, long start, long step, long stop) {
        return new Iterator<Long>() {
            LongUnaryOperator func = f;

            long i = start;

            @Override
            public boolean hasNext() {
                return abs(i) <= stop;
            }

            @Override
            public Long next() {
                return func.applyAsLong(i = +start);
            }

        };

    }

}
