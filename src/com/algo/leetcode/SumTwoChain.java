package com.algo.leetcode;


public class SumTwoChain {

    static class ListNode {

        public ListNode(ListNode next, int value) {
            this.next = next;
            this.value = value;
        }

        ListNode next;
        int value;
    }


    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(null, 0);
        ListNode result = head;

        ListNode p = l1;
        ListNode q = l2;

        int outSize = 0;

        while (p != null || q != null) {
            int tmp = 0;
            if (p != null) {
                tmp += p.value;
            }
            if (q != null) {
                tmp += q.value;
            }
            outSize += tmp;
            outSize /= 10;

            ListNode newNode = new ListNode(null, outSize % 10);
            result.next = newNode;
            result = newNode;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        if (outSize > 0) {
            result.next = new ListNode(null, outSize);
        }

        return head.next;
    }
}
