package com.itheima.datastructure.circular;

import java.util.Iterator;

/***
 * 循环双链表
 * @author taotao.zhou
 */
public class DoublyLinkedListSentinel implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, -1, null);

    public DoublyLinkedListSentinel() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(int value) {
        Node oldFirst = sentinel.next;
        Node newNode = new Node(sentinel, value, oldFirst);
        oldFirst.prev = newNode;
        sentinel.next = newNode;
    }

    public void addLast(int value) {
        Node oldLast = sentinel.prev;
        Node newNode = new Node(oldLast, value, sentinel);
        oldLast.next = newNode;
        sentinel.prev = newNode;
    }

    public void removeFirst() {
        Node oldFirst = sentinel.next;
        if (oldFirst == sentinel) {
            throw new IllegalArgumentException("List is empty");
        }
        sentinel.next = oldFirst.next;
        oldFirst.next.prev = sentinel;
    }

    public void removeLast() {
        Node oldLast = sentinel.prev;
        if (oldLast == sentinel) {
            throw new IllegalArgumentException("List is empty");
        }
        sentinel.prev = oldLast.prev;
        oldLast.prev.next = sentinel;
    }

    public void removeByValue(int value) {
        Node removed = findByValue(value);
        if (removed == null) {
            throw new IllegalArgumentException("Value not found");
        }
        removed.prev.next = removed.next;
        removed.next.prev = removed.prev;
    }

    private Node findByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel && p.value != value) {
            p = p.next;
        }
        return p;
    }


}
