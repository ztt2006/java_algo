package com.itheima.datasructure.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/***
 * 单向链表
 */
public class SinglyLinkedList implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
                // return p.value;
            }
        };
    }

    /***
     * 节点
     */
    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;

    //     在链表头添加节点
    public void addFirst(int value) {
        //     链表为空
        // head = new Node(value, null);
        //     链表非空
        head = new Node(value, head);
    }

    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    //     查找链表最后一个节点
    private Node findLast() {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    //     在链表尾添加节点
    public void addLast(int value) {
        Node last = findLast();
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }

    //     查找链表指定索引的节点
    private Node findNode(int index) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == index) {
                return p;
            }
            p = p.next;
            i++;
        }
        return null;
    }

    public int get(int index) {
        Node p = findNode(index);
        if (p == null) {
            illegalIndex(index);
        }
        return p.value;
    }

    //     在链表指定索引添加节点
    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node prev = findNode(index - 1);
        if (prev == null) {
            illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    private static void illegalIndex(int index) {
        throw new IllegalArgumentException(String.format("索引超出范围，索引为：%d", index));
    }

    //     删除链表头节点
    public void removeFirst() {
        if (head == null) {
            illegalIndex(0);
        }
        head = head.next;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node prev = findNode(index - 1);
        if (prev == null) {
            illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == null) {
            illegalIndex(index);
        }
        prev.next = removed.next;
    }
}

