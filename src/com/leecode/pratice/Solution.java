package com.leecode.pratice;

import com.leecode.dto.ListNode;
import com.leecode.dto.Node;
import com.leecode.dto.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/29 11:54
 * @Poject: AlgorithmStudy
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 */
class Solution {

    public static void main(String[] args) {

        TreeNode t1=new TreeNode(5);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(6);
        TreeNode t5=new TreeNode(7);
        TreeNode t6=new TreeNode(18);
        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;
        t4.left=t6;
        List<List<Integer>> re =levelOrder(t1);
        re.stream().forEach(System.out::println);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        // 层次数组
        List<Integer> level = new ArrayList<>();

        // 辅助遍历的队列
        LinkedList<TreeNode> help = new LinkedList<>();

        // 分节符，用于区分层次结构
        TreeNode dummyNode = new TreeNode(Integer.MIN_VALUE);

        help.addLast(root);

        // 如果为空则直接返回
        if (root == null){
            return ans;
        }
        // 根节点直接推入分界符
        help.addLast(dummyNode);

        // 当辅助队列不为空
        while (help.size()>0){
            // 从队列中取出头节点
            TreeNode node = help.getFirst();
            help.removeFirst();

            // 如果当前节点是分界符
            if (node == dummyNode){
                // 说明这一层遍历完毕，将数组加入结果
                ans.add(level);
                // 创建新数组
                level = new ArrayList<>();
                // 此时下一层所有节点应该都进入了队列
                // 当队列非空插入分界符
                if (!help.isEmpty()){
                    help.addLast(dummyNode);
                }
            }else {
                // 未到分界符就不断加入数
                level.add(node.val);
                // 节点左右不为空则入队
                if (node.left!=null){
                    help.addLast(node.left);
                }
                if (node.right!=null){
                    help.addLast(node.right);
                }
            }

        }
        return ans;
    }

}