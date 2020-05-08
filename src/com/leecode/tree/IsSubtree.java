package com.leecode.tree;

import com.leecode.dto.TreeNode;

/**
 * @Author: wangzicheng
 * @Date: 2020/5/7 19:07
 * @Poject: AlgorithmStudy
 */
public class IsSubtree {

    public boolean isSubtree(TreeNode left,TreeNode right){
        if(left==null) return true;
        if(right==null) return false;
        return isSubtree(right.left,left)||isSubtree(right.right,left)||isSameTree(left,right);
    }

    public boolean isSameTree(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        if(left.val!=right.val) return false;
        return isSubtree(left.left,right.left)&&isSubtree(left.right,right.right);
    }
}
