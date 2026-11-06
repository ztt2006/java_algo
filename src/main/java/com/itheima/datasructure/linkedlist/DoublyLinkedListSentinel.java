package com.itheima.datasructure.linkedlist;

import java.util.Iterator;

public class DoublyLinkedListSentinel implements Iterable<Integer> {
    static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;// 头哨兵
    private Node tail;// 尾哨兵

    public DoublyLinkedListSentinel() {
        head = new Node(null, 666, null);
        tail = new Node(null, 888, null);
        head.next = tail;
        tail.prev = head;
    }

    //  根据索引查找节点
    private Node findNode(int index) {
        int i = -1;
        Node p = head;
        while (p != tail) {
            if (i == index) {
                return p;
            }
            p = p.next;
            i++;
        }
        return null;
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    //  插入节点
    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            illegalIndex(index);
            return;
        }
        Node newNode = new Node(null, value, null);
        newNode.prev = prev;
        newNode.next = prev.next;
        prev.next.prev = newNode;
        prev.next = newNode;
    }

    public void removeFirst() {
        remove(0);
    }

    //    删除节点
    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            illegalIndex(index);
            return;
        }
        if (prev.next == tail) {
            illegalIndex(index);
            return;
        }
        Node next = prev.next.next;
        prev.next = next;
        next.prev = prev;
    }

    public void addLast(int value) {
        Node newNode = new Node(null, value, null);
        Node prev = tail.prev;
        newNode.prev = prev;
        newNode.next = tail;
        prev.next = newNode;
        tail.prev = newNode;
    }

    public void removeLast() {
        Node last = tail.prev;
        if (last == head) {
            return;
        }
        last.prev.next = tail;
        tail.prev = last.prev;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {

                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static void illegalIndex(int index) {
        throw new IllegalArgumentException(String.format("索引超出范围，索引为：%d", index));
    }

}
