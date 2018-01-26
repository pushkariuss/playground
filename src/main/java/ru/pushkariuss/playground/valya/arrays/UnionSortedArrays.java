package ru.pushkariuss.playground.valya.arrays;

/**
 * Created by pushkariuss on 10.04.2017.
 */
public class UnionSortedArrays {
    public static void main(String[] args) {
        int[] ar1 = {1, 2, 5, 9, 4, 2, 3};
        int[] ar2 = {2, 3, 3, 7, 8, 3, 1, 2, 3, 5};
        int arresult[] = new int[ar1.length + ar2.length];
        int common_length = ar1.length + ar2.length;
        for (int i = 0; i < common_length; i++) {
            if (i < ar1.length) {
                arresult[i] = ar1[i];
            } else arresult[i] = ar2[(i - ar1.length)];
        }
        for (int k = 0; k < common_length; k++)
            for (int l = (common_length - 1); l > k; l--) {
                if (arresult[l] < arresult[l - 1]) {
                    int temp = arresult[l];
                    arresult[l] = arresult[l - 1];
                    arresult[l - 1] = temp;
                }
            }
        for (int i = 0; i < common_length; i++) {
            System.out.print(arresult[i] + " ;");
        }
    }


}
