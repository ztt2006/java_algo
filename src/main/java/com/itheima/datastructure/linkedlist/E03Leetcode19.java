package com.itheima.datastructure.linkedlist;

public class E03Leetcode19 {
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        recursion(head, n);
        return head;
    }

    public static int recursion(ListNode p, int n) {
        if (p == null) {
            return 0;
        }
        int nth = recursion(p.next, n);
        if (nth == n) {
            p.next = p.next.next;
        }
        return nth + 1;
    }

    public static ListNode reverse(ListNode head) {
        ListNode n1 = head;
        ListNode o2 = head.next;
        while (o2 != null) {
            head.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = head.next;
        }
        return n1;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s;

        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }

    public static void main(String[] args) {
        ListNode p = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(p);
        ListNode result = removeNthFromEnd(p, 2);
        System.out.println(result);
    }
}
