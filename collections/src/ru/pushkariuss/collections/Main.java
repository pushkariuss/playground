package ru.pushkariuss.collections;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        testDoublyLinkedList();
    }

    public static void testSinglyLinkedList() {
        Item<String> head = new Item<String>(String.valueOf(0));
        Item<String> tmp = head;
        Item<String> cycledOn = null;
        Random random = new Random();
        final int n = 1000;
        int randomCycleIndex = random.nextInt(n);
        for (int i = 0; i < n; ++i) {
            tmp.setNext(new Item<String>(String.valueOf(i)));
            if (i == randomCycleIndex) {
                cycledOn = tmp;
            }
            tmp = tmp.getNext();
        }
        tmp.setNext(cycledOn);

        System.out.println(String.format("cycled on: %d", randomCycleIndex));
        System.out.println(String.format("cycled: %s", head.isCycled()));
    }

    public static void testDoublyLinkedList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        Random random = new Random();
        final int n = 10;
        for (int i = 0; i < n; ++i) {
            list.add(random.nextInt(n));
        }
        final long start = System.currentTimeMillis();
        list.sort();
        System.out.format(String.format("seconds: %.3f%n",(System.currentTimeMillis()-start) /(double) 1000));
    }
}
