package com.itheima.datastructure.linkedlist;

public class E01Leetcode206 {
    // 方法1
    public static ListNode reverseList1(ListNode head) {
        ListNode n1 = null;
        ListNode p = head;

        while (p != null) {
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;
    }

    // 方法2
    public static ListNode reverseList2(ListNode head) {
        List list1 = new List(head);
        List list2 = new List(null);

        while (true) {
            ListNode first = list1.removeFirst();
            if (first == null) {
                break;
            }
            list2.addFirst(first);
        }
        return list2.head;
    }

    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (first != null) {
                head = first.next;
                return first;
            }
            return null;
        }
    }

    // 方法3 -递归
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(head);
        ListNode reversed = reverseList(head);
        System.out.println(reversed);
    }
}
