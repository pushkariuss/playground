package ru.pushkariuss.playground.collections;

import java.util.LinkedList;
import java.util.List;

/**
 * Item of the singly-linked list.
 *
 * @param <T>
 */
public class Item<T> {

    private Item next;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Item<T> getNext() {
        return next;
    }

    public void setNext(Item<T> next) {
        this.next = next;
    }

    public Item(T data) {
        this.data = data;
    }

    public boolean isCycled() {
        int k = 1;
        int c = 0;
        List<Item<T>> visited = new LinkedList<Item<T>>();
        Item<T> tmp = this;
        while (tmp != null) {
            if (visited.contains(tmp)) {
                System.out.println(String.format("steps: %d, visited: %d", c, visited.size()));
                return true;
            }
            if (c + 1 == k) {
                visited.add(tmp);
                k <<= 1;
            }
            tmp = tmp.getNext();
            ++c;
        }
        System.out.println(String.format("steps: %d, visited: %d", c - 1, visited.size()));
        return false;
    }
}
