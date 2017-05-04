package com.company;

/**
 * Created by pushkariuss on 10.04.2017.
 */
public class ArrayClassCheckingElements {
    public static void main (String[] args){
    int[] ar = {15, 74, 673, 23, 9, 0, 2, -332, 42, 17, 79, -45};
    for (int i = 0; i < ar.length; i++) {
        if (ar[i] < 0) {
            System.out.println("Number " + ar[i] + " is negative");
        } else if (ar[i] % 2 > 0) {
            System.out.println("Number " + ar[i] + " is positive and odd");
        } else {
            if (ar[i] > 0) {
                System.out.println("Number " + ar[i] + " is positive and even");
            } else System.out.println(ar[i]+" is Zero!");
        }
    }
}}
