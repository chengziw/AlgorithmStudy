package com.leecode.tree;

import com.leecode.dto.ListNode;
import com.leecode.dto.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.tree
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/18 21:34
 * @version: 1.0.0
 */
public class Day04_18 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        constructPaths(root, "", ans);
        return ans;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(sb.toString());
        } else {
            sb.append("->");
            constructPaths(root.left, sb.toString(), paths);
            constructPaths(root.right, sb.toString(), paths);
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return root == null ? 0 : sumOfLeftLeavesDFS(root);
    }

    public int sumOfLeftLeavesDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.left != null) {
            ans += isLastNode(root.left) ? root.left.val : sumOfLeftLeavesDFS(root.left);
        }

        if (root.right != null && !isLastNode(root.right)) {
            ans += sumOfLeftLeavesDFS(root.right);
        }
        return ans;
    }

    public boolean isLastNode(TreeNode root) {
        return root.left == null && root.right == null;
    }


    @Test
    public void test() {
        TreeNode listNode1 = new TreeNode(1);
        TreeNode listNode2 = new TreeNode(2);
        TreeNode listNode3 = new TreeNode(3);
        TreeNode listNode4 = new TreeNode(4);
        TreeNode listNode5 = new TreeNode(6);
        listNode2.left = listNode1;
        listNode2.right = listNode3;
        listNode4.left = listNode2;
        listNode4.right = listNode5;
        sumOfLeftLeaves(listNode4);
    }
}
