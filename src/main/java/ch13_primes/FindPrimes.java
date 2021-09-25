package ch13_primes;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FindPrimes {
    public static Set<Integer> findNaive(int n) {
        var set = new HashSet<Integer>();
        for (int i = 2; i < n; i++) {
            set.add(i);
        }

        for (int i = 2; i < n; i++)
            for (int k = 2; k < n; k++) {
                set.remove(i * k);
            }
        return set;
    }

    public static Set<Integer> findBetter(int n) {
        var set = new HashSet<Integer>();
        for (int i = 2; i < n; i++) {
            set.add(i);
        }

        for (int i = 2; i < Math.sqrt(n); i++) // n restricted <= sqrt(n)
            for (int k = i; k < (n/i); k++) { //k restricted to >= i <= n/i
                set.remove(i * k);
            }
        return set;
    }

    public static Set<Integer> findBest(int n) {
        var set = new HashSet<Integer>();
        for (int i = 2; i < n; i++) {
            set.add(i);
        }

        for (int i = 2; i < Math.sqrt(n); i++) // n restricted <= sqrt(n)
            if (set.contains(i)) // only execute the 2nd loop if i is prime
                for (int k = (n/i); k >= i ; k--) //k restricted to >= i <= n/i and runs backwards
                    if (set.contains(k)) // only execute removal if k is prime
                        set.remove(i * k);

        return set;
    }

    static public void logTime(Function<Integer, Set<Integer>> func, int n) {
        var start = System.nanoTime();
        var result = func.apply(n);
        System.out.println(result + "\nfound in " + ((System.nanoTime() - start)/1000_000) + "ms.");
    }

    static public int myAdd(int a, int b) {
        return a+b;
    }

    public static void log(BiFunction<Integer, Integer, Integer> func, int a, int b) {
        var start = System.nanoTime();
        var result = func.apply(a, b);
        System.out.println(result + "\nfound in " + ((System.nanoTime() - start)/1000_000) + "ms.");
    }


    public static void main(String[] args) {
        int n = 10000;
        logTime(FindPrimes::findNaive, n);
        logTime(FindPrimes::findBetter, n);
        logTime(FindPrimes::findBest, n);

        log(FindPrimes::myAdd, 1, 2);
    }
}
