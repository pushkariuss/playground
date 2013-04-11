package ru.pushkariuss.collections;

/**
 * Represents a doubly-linked list.
 *
 * @param <T>
 */
public class DoublyLinkedList<T extends Comparable<T>> {

    public void add(T data) {
        if (length == 0) {
            head = tail = new Item(data, null, null);
        } else {
            tail.next = new Item(data, null, tail);
            tail.next.prev = tail;
            tail = tail.next;
        }
        ++length;
    }

    public T get(int i) {
        if (indexInBounds(i)) {
            if (i == 0) {
                return head.data;
            } else if (i == length - 1) {
                return tail.data;
            } else {
                Item tmp;
                if (i < length / 2) {
                    tmp = head;
                    for (int j = 0; j < i; ++j) {
                        tmp = tmp.next;
                    }
                } else {
                    tmp = tail;
                    for (int j = length - 1; j > i; --j) {
                        tmp = tmp.prev;
                    }
                }
                return tmp.data;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }


    public void remove(int i) {
        if (indexInBounds(i)) {
            if (length == 1) {
                head = tail = null;
            } else if (i == 0) {
                head.next.prev = null;
                head = head.next;
            } else if (i == length - 1) {
                tail.prev.next = null;
                tail = tail.prev;
            } else {
                Item tmp;
                if (i < length / 2) {
                    tmp = head;
                    for (int j = 0; j < i; ++j) {
                        tmp = tmp.next;
                    }
                } else {
                    tmp = tail;
                    for (int j = length - 1; j > i; --j) {
                        tmp = tmp.prev;
                    }
                }
                tmp.next.prev = tmp.prev;
                tmp.prev.next = tmp.next;
            }
            --length;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void clear() {
        head = tail = null;
        length = 0;
    }

    public int size() {
        return length;
    }

    public void sort() {
        sort(this);
    }

    private void sort(DoublyLinkedList<T> list) {
        Item tmp = head;
        while (tmp != null) {

        }
    }

    private boolean indexInBounds(int i) {
        return i >= 0 && i < length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < length; ++i) {
            sb.append(get(i));
            if (i != length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private Item head;
    private Item tail;
    private int length;

    private class Item {
        private Item next;
        private Item prev;
        private T data;

        private Item(T data, Item next, Item prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
