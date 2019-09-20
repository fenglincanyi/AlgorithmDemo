package com.algo.leetcode;

import com.algo.base.tree.Node;

/**
 * 【14. 二叉树展开为链表】
 *
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class TreeToChian {

    public static void main(String[] args) {

    }

    public static void flatten(Node root) {
        while (root != null) {
            if (root.left != null) {
                // 1. 移动到左子树的最右侧子节点
                Node mostRight = root.left;
                while (mostRight.right != null) {
                    mostRight = mostRight.right;
                }

                // 2. 移动右子树到，并断掉原始链接
                mostRight.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            // 3. 继续遍历
            root = root.right;
        }
    }
}
