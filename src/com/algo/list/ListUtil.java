package com.algo.list;

/**
 * Created by geng
 * on 2017/8/14.
 */
public class ListUtil {

    public static Node buildList() {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        return a;
    }
}
