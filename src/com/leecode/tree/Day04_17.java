package com.leecode.tree;

import com.leecode.dto.TreeNode;

import java.util.*;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.tree
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/17 11:23
 * @version: 1.0.0
 */
public class Day04_17 {

    public int[] findModeSelft(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            hashMap.put(curNode.val, hashMap.getOrDefault(curNode.val, 1));
            if (curNode.right != null) {
                queue.add(curNode.right);
            }

            if (curNode.left != null) {
                queue.add(curNode.left);
            }
        }

        int max = Integer.MIN_VALUE;

        for (Map.Entry map : hashMap.entrySet()) {
            max = Math.max(max, (int) map.getValue());
        }

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry map : hashMap.entrySet()) {
            if ((int) map.getValue() == max) {
                ans.add((Integer) map.getKey());
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }


    int base, count, maxCount;
    List<Integer> answer = new ArrayList<Integer>();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }


    public void update(int x) {
        if (x == base) {
            count++;
            return;
        }

        base = x;
        if (maxCount == count) {
            answer.add(x);
        } else if (maxCount < count) {
            answer.clear();
            answer.add(x);
            maxCount = count;
        }
        count = 1;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = root;
        while (true) {
            if (p.val < ans.val && q.val < ans.val) {
                ans = ans.left;
            } else if (p.val > ans.val && q.val > ans.val) {
                ans = ans.right;
            } else {
                break;
            }
        }
        return ans;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        return searchBST(val < root.val ? root.left : root.right, val);
    }





    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            TreeNode left = curr.left, right = curr.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = curr;
        }
    }
}
