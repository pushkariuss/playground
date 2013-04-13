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
        DoublyLinkedList<T> sorted = sort(this);
        this.head = sorted.head;
        this.tail = sorted.tail;
        this.length = sorted.length;
    }

    private DoublyLinkedList<T> sort(DoublyLinkedList<T> list) {
        if (list.size() < 2) {
            return list;
        } else {
            DoublyLinkedList<T> left = new DoublyLinkedList<T>();
            DoublyLinkedList<T> right = new DoublyLinkedList<T>();
            int middle = list.length / 2;
            for (int i = 0; i < middle; ++i) {
                left.add(list.get(i));
            }
            for (int i = middle; i < list.length; ++i) {
                right.add(list.get(i));
            }
            left = sort(left);
            right = sort(right);
            return merge(left, right);
        }
    }

    private DoublyLinkedList<T> merge(DoublyLinkedList<T> left, DoublyLinkedList<T> right) {
        DoublyLinkedList<T> result = new DoublyLinkedList<T>();
        while (left.size() > 0 || right.size() > 0) {
            if (left.size() > 0 && right.size() > 0) {
                if (left.get(0).compareTo(right.get(0)) <= 0) {
                    result.add(left.get(0));
                    left.remove(0);
                } else {
                    result.add(right.get(0));
                    right.remove(0);
                }
            } else if (left.size() > 0) {
                result.add(left.get(0));
                left.remove(0);
            } else {
                result.add(right.get(0));
                right.remove(0);
            }
        }
        return result;
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

    public DoublyLinkedList() {
        head = null;
        tail = null;
        length = 0;
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
