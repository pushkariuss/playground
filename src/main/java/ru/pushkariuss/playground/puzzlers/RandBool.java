package ru.pushkariuss.playground.puzzlers;

import java.util.Random;

/**
 * Probability problem: render a 1/2 true & 1/2 false bool function by a function,
 * which returns true with 1/4 and false with 3/4
 */
public class RandBool {

    private final Random R = new Random();
    private final float probabilityOfTrue;

    private RandBool(float probabilityOfTrue) {
        this.probabilityOfTrue = probabilityOfTrue;
    }

    private boolean get() {
        return R.nextFloat() <= probabilityOfTrue;
    }


    public static void main(String[] args) {
        RandBool quaterTrue = new RandBool(0.25f);

        int NUM = 100_000_000;
        int count = 0;
        for (int i = 0; i < NUM; ++i) {
            boolean a = quaterTrue.get();
            boolean b = quaterTrue.get();
            boolean c = quaterTrue.get();
            boolean d = quaterTrue.get();
            boolean func = !a && !b && !c && !d || // 81/256
                    !a && !b && !c ||  // 27/256
                    !a && !b && d || // 9/256
                    !a && b && !c && d || // 9/256
                    a && b && c && d; // 1/256
            if (func) count++;
        }
        System.out.println("achieved probability of true: "+(float) count / NUM);


    }

}
