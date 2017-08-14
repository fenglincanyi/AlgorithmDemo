package com.algo.list;

/**
 * Created by geng
 * on 2017/8/14.
 */
public class ListDemo {

    public static void main(String[] args) {
        Node head = ListUtil.buildList();

        System.out.println("单链表打印： ");
        printList(head);



//        System.out.println("\n反转后：");
//        printList(reverseList(head));

        System.out.println("\n倒数第k个节点：" +getReverseKNode(head, 2).value);
    }


    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }

    }


    /**
     * 单链表反转
     */
    public static Node reverseList(Node head) {
        Node h = head;
        Node p = head.next;
        while (p != null) {
            Node tmp = p.next;
            p.next = h;
            h = p;
            p = tmp;
        }

        head.next = null;
        return h;
    }


    /**
     * 求倒数第K个节点
     */
    public static Node getReverseKNode(Node head, int k) {
        Node p = head;
        Node q = p.next;

        for (int i = 0; i < k - 1; i++) {
            q = q.next;
        }

        while(q != null) {
            q = q.next;
            p = p.next;
        }

        return p;
    }
}
