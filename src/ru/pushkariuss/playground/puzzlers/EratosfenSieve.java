package ru.pushkariuss.playground.puzzlers;

import java.util.BitSet;

public class EratosfenSieve {


    public static void main(String[] args) {
        int n = 113;
        BitSet primes = findPrimes(n);
        System.out.println(primes.cardinality());
        System.out.println(primes);
    }

    static BitSet findPrimes(int n) {
        BitSet x = new BitSet(n + 1);
        x.flip(2, n + 1);

        int lastPrime = 2;
        while (lastPrime <= n && lastPrime > 0) {
            int i = 2;
            int trash;
            while ((trash = i * lastPrime) <= n) {
                if (x.get(trash)) x.flip(trash);
                i++;
            }
            lastPrime = x.nextSetBit(lastPrime + 1);
        }
        return x;
    }


}
