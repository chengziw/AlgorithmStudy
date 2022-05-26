package com.leecode.month.month_05;

import com.leecode.dto.TreeNode;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_05
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/5/24 19:00
 * @version: 1.0.0
 */
public class Day_24 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left != null){
            if (root.val != root.left.val){
                return false;
            }
        }

        if (root.right != null){
            if (root.val != root.right.val){
                return false;
            }
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

}
