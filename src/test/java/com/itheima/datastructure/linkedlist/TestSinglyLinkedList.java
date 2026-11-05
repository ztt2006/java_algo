package com.itheima.datastructure.linkedlist;

import com.itheima.datasructure.linkedlist.SinglyLinkedList;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class TestSinglyLinkedList {

    @Test
    @DisplayName("测试addFirst")
    public void test1() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.loop2(value -> {
            System.out.println(value);
        });
        // assertIterableEquals(List.of(4, 3, 2, 1), list);
    }

    @Test
    @DisplayName("测试addFirst")
    public void test2() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        for (Integer i : list) {
            System.out.println(i);
        }
        // assertIterableEquals(List.of(4, 3, 2, 1), list);
    }
}
