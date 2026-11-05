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
}

