package com.itheima.datastructure.linkedlist;

public class E04Leetcode83 {
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }


    public static void main(String[] args) {
        ListNode p = ListNode.of(1, 1, 3, 3, 2);
        System.out.println(p);
        ListNode q = deleteDuplicates(p);
        System.out.println(q);
    }
}
