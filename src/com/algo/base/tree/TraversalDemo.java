package com.algo.base.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by geng
 * on 2017/8/14.
 */
public class TraversalDemo {


    public static void main(String[] args) {
        Node node = TreeUtil.buildTree();

        /**

         前序遍历：a b d e f g c
         中序遍历：d e b g f a c
         后序遍历：e d g f b c a
         后序遍历：a b c d f e g

         */

//        preTraversal(node);
//        System.out.println();
//        midTraversal(node);
//        System.out.println();
//        postTraversal(node);
//        System.out.println();


        /**
         * 使用非递归方式
         */

//        preTraversal1(node);
//        System.out.println();
//        midTraversal1(node);
//        System.out.println();
//        postTraversal1(node);


        /**
         * 层序遍历
         */

        levelTraversal(node);
    }


    /**
     * 递归实现
     */
    public static void preTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preTraversal(root.left);
        preTraversal(root.right);
    }

    public static void midTraversal(Node root) {
        if (root == null) {
            return;
        }
        midTraversal(root.left);
        System.out.print(root.value + " ");
        midTraversal(root.right);
    }

    public static void postTraversal(Node root) {
        if (root == null) {
            return;
        }
        postTraversal(root.left);
        postTraversal(root.right);
        System.out.print(root.value + " ");
    }

    //================================================


    /**
     * 非递归实现：使用 "栈" 存储节点，进行相关遍历
     *
     * 深度遍历
     */

    public static void preTraversal1(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.value + " ");

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void midTraversal1(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (node != null || !stack.isEmpty()) {
            // 找到最左侧的节点
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.value + " ");
                node = node.right;
            }
        }
    }


    /**
     * 思路：
     * <p>
     * 要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。如果P不存在左孩子和右孩子，则可以直接访问它；
     * 或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。
     * 若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了每次取栈顶元素的时候，左孩子在右孩子前面被访问，
     * 左孩子和右孩子都在根结点前面被访问。
     */
    public static void postTraversal1(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curNode, lastNode = null;// 当前节点，上一个节点
        stack.push(root);

        while (!stack.isEmpty()) {
            curNode = stack.peek();

            if ((curNode.left == null && curNode.right == null)
                    || (lastNode != null && (lastNode == curNode.left || lastNode == curNode.right))) {
                System.out.print(curNode.value + " ");
                stack.pop();
                lastNode = curNode;
            } else {
                if (curNode.right != null) {
                    stack.push(curNode.right);
                }
                if (curNode.left != null) {
                    stack.push(curNode.left);
                }
            }
        }
    }


    //================================================================================================

    /**
     * 层序遍历
     * <p>
     * 队列实现
     */
    public static void levelTraversal(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.value + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
