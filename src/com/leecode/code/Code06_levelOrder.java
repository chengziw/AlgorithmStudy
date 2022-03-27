package com.leecode.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.code
 * @author: wangzicheng
 * @description: 二叉树
 * @date: 2022/3/26 11:09
 * @version: 1.0.0
 */
public class Code06_levelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * create by: wangzicheng
     * description: 二叉树层序遍历
     * create time: 2022/3/26 11:10
     * version: v1.0.0
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                cur.add(head.val);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }

            ans.add(0, cur);
        }
        return ans;
    }


    /**
     * create by: wangzicheng
     * description: 层序遍历二： https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
     * create time: 2022/3/26 11:22
     * version: v1.0.0
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curAns = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                curAns.add(head.val);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
            ans.add(0, curAns);
        }
        return ans;
    }

    /**
     * create by: wangzicheng
     * description: 是否是平衡树
     * create time: 2022/3/26 14:23
     * version: v1.0.0
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(rightHeight, leftHeight) + 1;
        }
    }

    long pre = Long.MIN_VALUE;

    /**
     * create by: wangzicheng
     * description: 验证是否是二叉搜索树
     * create time: 2022/3/26 15:03
     * version: v1.0.0
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }


    /**
     * create by: wangzicheng
     * description: 指定路径和
     * create time: 2022/3/26 15:12
     * version: v1.0.0
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        if (root.right != null) {
            ans.addAll(binaryTreePaths(root.right));
        }

        if (root.left != null) {
            ans.addAll(binaryTreePaths(root.left));
        }
        return ans;
    }

    /**
     * create by: wangzicheng
     * description: 中序遍历
     * create time: 2022/3/26 15:46
     * version: v1.0.0
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * create by: wangzicheng
     * description: https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
     * create time: 2022/3/26 15:52
     * version: v1.0.0
     */
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        sum(root,0,sum);
        return sum;
    }

    public void sum(TreeNode root, int index, int sum) {
        if (root == null) {
            return;
        }

        sum(root.right, index++, sum);
        sum += root.val + 10 * index;
        sum(root.left, index++, sum);
    }

    public int helper(TreeNode root, int i){
        if (root == null) return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null)
            return temp;
        return helper(root.left, temp) + helper(root.right, temp);
    }



}
