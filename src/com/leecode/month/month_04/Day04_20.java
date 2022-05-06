package com.leecode.month.month_04;

import com.leecode.dto.ListNode;
import com.leecode.dto.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/20 23:15
 * @version: 1.0.0
 */
public class Day04_20 {
    public int lengthLongestPath(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();

        while (pos < n) {
            /* 检测当前文件的深度 */
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            /* 统计当前文件名的长度 */
            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            /* 跳过当前的换行符 */
            pos++;

            while (stack.size() >= depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                len += stack.peek() + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                stack.push(len);
            }
        }
        return ans;
    }


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return buildTree(head,null);
    }

    public TreeNode buildTree(ListNode left, ListNode right){
        if (left == right){
            return null;
        }
        ListNode s = left;
        ListNode q = left;
        while (q != right && q.next != right){
            q = q.next.next;
            s = s.next;
        }

        TreeNode node = new TreeNode(s.val);
        node.left = buildTree(left,s);
        node.right = buildTree(s.next,right);
        return node;
    }

}
