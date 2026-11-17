package com.itheima.datastructure.linkedlist;

public class E05Leetcode82 {
    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static ListNode deleteDuplicates(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            ListNode x = p.next.next;
            while (x != null && x.val == p.val) {
                x = x.next;
            }
            return deleteDuplicates(x);
        } else {
            p.next = deleteDuplicates(p.next);
            return p;
        }
    }

    public static void main(String[] args) {
        ListNode p = ListNode.of(1, 1, 3, 3, 2);
        System.out.println(p);
        ListNode q = deleteDuplicates(p);
        System.out.println(q);
    }
}
