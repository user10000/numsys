package num;

import static java.lang.Math.pow;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.*;
import static num.Analyzer.*;
import static num.NumArrayer.sigma;
import static num.PrimeTester.LLT;

/**
 *
 * @author Guest
 */
public class Main implements Tabler, OEISUser {

    static boolean verbose = true;

    public static void main(String[] args) {
        IntToDoubleFunction f = x -> pow(0.5, x - 1);
        System.out.println(sigma(f));
        
    }

    public static void test() {
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.HALF_UP);

        double maxpcnt = 0;
        int mod, count;

        for (int i = 2; i < 5000; i += 2) {
            mod = i;
            count = count(mod);
            double pcnt = 100 * (1 - (1.0 * count / mod));
            if (pcnt > maxpcnt) {
                String percent = df.format(pcnt) + "%";
                System.out.
                        println(percent + " of numbers are filtered modulo " + mod);
                maxpcnt = pcnt;
            }
        }
    }

    public static int count(int mod) {
        Set<Integer> sqrmods = new HashSet(mod);
        for (int i = 0; i < mod; i++) {
            // sqrmods.add(SQUARE[i] % mod);
        }
        return sqrmods.size();
    }

    public static String formatInts(List<Integer> lst) {
        StringBuilder buf = new StringBuilder();
        buf = buf.append("{");
        for (int i = 0; i < lst.size(); i++) {
            buf = buf.append(lst.get(i));

            buf = buf.append(",");
        }
        return buf.substring(0, buf.length() - 1) + "};";
    }

    public static String formatLongs(List<Long> lst) {
        StringBuilder buf = new StringBuilder();
        buf = buf.append("{");
        for (int i = 0; i < lst.size(); i++) {
            buf = buf.append(lst.get(i));
            if (lst.get(i) != (int) (long) lst.get(i)) {
                buf = buf.append("L");
            }
            buf = buf.append(",");
        }
        return buf.substring(0, buf.length() - 1) + "};";
    }

    public static List<Long> getFirst(int amt, LongPredicate p) {
        List<Long> lst = new ArrayList();
        for (long i = 0; lst.size() < amt && i <= Long.MAX_VALUE; i++) {
            if (p.test(i)) {
                lst.add(i);
            }
        }
        return lst;
    }

    public static List<Integer> getAllUnder(int max, LongPredicate p) {
        final int THREADS = 64;
        final int INTERVAL = max / THREADS;
        List<Integer> lst = new ArrayList();
        for (int i = 0; i < THREADS; i++) {
            final int fi = i;
            Thread t = new Thread(() -> {
                List<Integer> ans = new ArrayList();
                int j = fi * INTERVAL, k = 0;
                while (k < INTERVAL) {
                    if (p.test(j)) {
                        ans.add(j);
                    }
                    j++;
                    k++;
                }
                lst.addAll(ans);
            });

            t.setPriority(1 + i / (int) Math.ceil(THREADS / 10.0));
            t.start();
        }

        while (Thread.activeCount() > 1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {

            }
            System.out.println("Threads: " + Thread.activeCount());
        }
        Collections.sort(lst);
        return lst;
    }

    public static void filterAgainstRange(LongPredicate p, int lo, int hi) {
        double t = System.nanoTime();
        long cnt = 0;

        for (int i = lo; i <= hi; i++) {
            if (p.test(i)) {
                cnt++;
                if (verbose) {
                    System.out.println(i);
                }
            }
        }

        t = (System.nanoTime() - t) / Math.pow(10, 9);
        System.out.
                printf("%s satsifying the predicate between %s and %s (inclusive).\n", cnt, lo, hi);
        System.out.
                println("Took " + String.valueOf(t).substring(0, 4) + " seconds");
    }

    /*long x = 1, z = 1;
     long y = 1;
     String ans = "{";
     while (x >= z) {
     ans += x;
     if (x != (int) x) ans += "L";
     ans += ", ";
            
     z = x;
     x *= y;
     y++;
     }
     ans = ans.substring(0, ans.lastIndexOf(","));
     ans += "};";
     System.out.println(ans);
     System.out.println(2432902008176640000L / 121645100408832000L);*/
}
