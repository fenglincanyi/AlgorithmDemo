package com.algo.base.tree;

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
     * 扩展：
     * Android 求view的最大层层级深度
     */
//    private int maxDeep(View view) {
//        //当前的view已经是最底层view了，不能往下累加层数了，返回0，代表view下面只有0层了
//        if (!(view instanceof ViewGroup)) {
//            return 0;
//        }
//        ViewGroup vp = (ViewGroup) view;
//        //虽然是viewgroup，但是如果并没有任何子view，那么也已经是最底层view了，不能往下累加层数了，返回0，代表view下面只有0层了
//        if (vp.getChildCount() == 0) {
//            return 0;
//        }
//        //用来记录最大层数
//        int max = 0;
//        //广度遍历view
//        for (int i = 0; i < vp.getChildCount(); i++) {
//            //由于vp拥有子view，所以下面还有一层，因为可以+1，来叠加一层，然后再递归几岁算它的子view的层数
//            int deep = maxDeep(vp.getChildAt(i)) + 1;
//            //比较哪个大就记录哪个
//            if (deep > max) {
//                max = deep;
//            }
//        }
//        return max;
//    }

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
