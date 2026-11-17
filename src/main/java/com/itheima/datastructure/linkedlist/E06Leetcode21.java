package com.itheima.datastructure.linkedlist;

public class E06Leetcode21 {
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode s = new ListNode(-1, null);
        ListNode p = s;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 != null) {
            p.next = list1;
        }

        if (list2 != null) {
            p.next = list2;
        }
        return s.next;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list1;
        }
        if (list2 == null) {
            return list2;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }


    public static void main(String[] args) {
        ListNode p1 = ListNode.of(1, 3, 8, 9);
        ListNode p2 = ListNode.of(2, 4);

        ListNode listNode = mergeTwoLists(p1, p2);
        System.out.println(listNode);
    }
}
