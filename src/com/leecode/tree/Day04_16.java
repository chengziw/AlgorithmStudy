package com.leecode.tree;

import com.leecode.dto.TreeNode;

import java.util.*;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.tree
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/16 20:58
 * @version: 1.0.0
 */
public class Day04_16 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        inTar(root, ans);
        return ans;
    }

    public void inTar(TreeNode node, List<Integer> ans) {

        if (node == null) {
            return;
        }

        inTar(node.left, ans);
        ans.add(node.val);
        inTar(node.right, ans);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int maxDepth = 1;
        HashMap<TreeNode, Integer> level = new HashMap<>();
        level.put(root, 1);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            Integer curLevel = level.get(curNode);
            if (curNode.left != null) {
                queue.add(curNode.left);
                level.put(curNode.left, curLevel + 1);
            }

            if (curNode.right != null) {
                queue.add(curNode.right);
                level.put(curNode.right, curLevel + 1);
            }

            maxDepth = curLevel > maxDepth ? curLevel : maxDepth;
        }
        return maxDepth;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);

        return root;
    }


    public boolean isBalanced(TreeNode root) {
        return height(root) < 0;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right);
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            int left = minDepth(root.left);
            min = Math.min(left, min);
        }

        if (root.right != null) {
            int right = minDepth(root.right);
            min = Math.min(right, min);
        }

        return min + 1;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        beforeTar(root, ans);
        return ans;
    }

    public void beforeTar(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        ans.add(node.val);
        inTar(node.left, ans);
        inTar(node.right, ans);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
