package com.itheima.datastructure.linkedlist;

public class E02Leetcode203 {
    public static ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }

    // 方法二-递归

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 6, 3, 4, 5, 6);
        System.out.println(head);
        ListNode removed = removeElements(head, 6);
        System.out.println(removed);
    }
}
