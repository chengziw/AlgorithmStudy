package com.leecode.code;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.code
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/3/25 20:17
 * @version: 1.0.0
 */
public class Code05_TheSameTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * create by: wangzicheng
     * description: 是否相同
     * create time: 2022/3/25 20:29
     * version: v1.0.0
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * create by: wangzicheng
     * description: 镜面树
     * create time: 2022/3/25 20:29
     * version: v1.0.0
     */
    public boolean isSymmetric(TreeNode root) {
        return isMetric(root, root);
    }

    public boolean isMetric(TreeNode root, TreeNode root2) {
        if (root == null ^ root2 == null) {
            return false;
        }
        if (root == null && root2 == null) {
            return true;
        }

        return root.val == root2.val && isMetric(root.left, root2.right) && isMetric(root.right, root2.left);
    }

    /**
     * create by: wangzicheng
     * description: 树的最大深度
     * create time: 2022/3/25 20:54
     * version: v1.0.0
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length ) {
            return null;
        }
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] pre, int l1, int r1, int[] in, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[l1]);
        if (l1 == r1) {
            return head;
        }
        int find = l2;
        while (pre[l1] != in[find]) {
            find++;
        }

        head.left = build(pre, l1 + 1, l1 + find - l2, in, l2, find - 1);
        head.right = build(pre, l1 + find - l2 + 1, r1, in, find + 1, r2);
        return head;
    }
}