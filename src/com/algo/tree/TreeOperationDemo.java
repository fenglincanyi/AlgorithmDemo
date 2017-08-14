package com.algo.tree;

/**
 * Created by geng
 * on 2017/8/14.
 */
public class TreeOperationDemo {

    public static void main(String[] args) {
        Node node = TreeUtil.buildTree();
//        System.out.println("二叉树的深度："+getTreeDepth(node));
//        System.out.println("计算二叉树第K层节点的个数：" + getTreeKLevelDepth(node, 3));
//        System.out.println("二叉树的节点总数："+getTreeNodeSize(node));
//        System.out.println("二叉树的叶子节点总数：" + getTreeLeavesSize(node));


        // 二叉树翻转
//        System.out.println("翻转之前:");
//        TraversalDemo.levelTraversal(node);
//        Node invertNode = invertTree(node);
//        System.out.println("\n翻转之后:");
//        TraversalDemo.levelTraversal(invertNode);

    }


    /**
     * 计算二叉树的深度
     */
    public static int getTreeDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);

        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }

    /**
     * 计算二叉树第K层节点的个数
     */
    public static int getTreeKLevelDepth(Node root, int key) {
        if (root == null || key < 1) {
            return 0;
        }

        if (key == 1) {
            return 1;
        }

        return (getTreeKLevelDepth(root.left, key - 1) + getTreeKLevelDepth(root.right, key - 1));
    }


    /**
     * 计算二叉树的节点总数
     */
    public static int getTreeNodeSize(Node root) {
        if (root == null) {
            return 0;
        }

        return getTreeNodeSize(root.left) + getTreeNodeSize(root.right) + 1;
    }

    /**
     * 计算二叉树的叶子节点总数
     */
    public static int getTreeLeavesSize(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            // 打印看看，叶子节点都是哪些
            System.out.print(root.value + " ");
            return 1;
        }

        return getTreeLeavesSize(root.left) + getTreeLeavesSize(root.right);
    }


    /**
     * 二叉树的翻转（镜像）
     */
    public static Node invertTree(Node root) {
        if (root == null) {
            return null;
        }

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }
}
