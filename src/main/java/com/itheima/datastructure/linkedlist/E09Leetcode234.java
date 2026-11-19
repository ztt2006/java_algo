package com.itheima.datastructure.linkedlist;

public class E09Leetcode234 {

    public static boolean isPalindrome(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        ListNode n1 = null;
        ListNode o1 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }

        /* ListNode middle = p1;
        ListNode n1 = null;
        while (middle != null) {
            ListNode temp = middle.next;
            middle.next = n1;
            n1 = middle;
            middle = temp;
        }
        ListNode newHead = n1;

        while (newHead != null) {
            if (newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        } */
        return true;
    }


    public static void main(String[] args) {

        ListNode head1 = ListNode.of(1, 1, 2, 1);
        System.out.println(isPalindrome(head1));
        ListNode head2 = ListNode.of(1, 2, 3, 2, 1);
        System.out.println(isPalindrome(head2));
    }
}
