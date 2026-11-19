package com.itheima.datastructure.linkedlist;

import java.util.ArrayList;

public class E08Leetcode876 {

    public static ListNode middleNode1(ListNode head) {
        int length = 0;
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            length++;
            list.add(cur);
            cur = cur.next;
        }
        return list.get(length / 2);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(middleNode(head));

        ListNode head2 = ListNode.of(1, 2, 3, 4, 5, 6);
        System.out.println(middleNode(head2));

    }
}
