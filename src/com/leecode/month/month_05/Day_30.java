package com.leecode.month.month_05;

import com.leecode.dto.TreeNode;


/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_05
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/5/30 19:46
 * @version: 1.0.0
 */
public class Day_30 {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = (val << 1) | root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }


    public int maximumSwap(int num) {
        String str = String.valueOf(Integer.valueOf(num));
        int length = str.length();
        char[] chars = str.toCharArray();

        for (int i = 0; i < length; i++) {
            int max = i + 1;
            for (int j = i + 1; j < length; j++) {
                max = chars[max] > chars[j] ? max : j;
            }

            if (chars[max] > chars[i]) {
                char temp = chars[max];
                chars[max] = chars[i];
                chars[i] = temp;
                break;
            }
        }

        Integer integer = Integer.valueOf(new String(chars));
        return integer;
    }
}
