package com.algo.tree;

/**
 * Created by geng
 * on 2017/8/14.
 */
public class TreeUtil {

    public static Node buildTree() {
        Node root = new Node("a");

        /**
         * 随意构造一个二叉树
         *
         * 如图：resource/treedemo.png
         */
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");

        root.left = b;
        root.right = c;

        b.left = d;
        b.right = f;

        d.right = e;
        f.left = g;


        return root;
    }
}
