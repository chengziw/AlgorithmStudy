package com.leecode.month.month_05;


import com.leecode.dto.ListNode;
import com.leecode.dto.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_05
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/5/5 17:42
 * @version: 1.0.0
 */
public class Day_05 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }

    @Test
    public void test() {
        int[] arr = new int[]{10, 5, 2, 6};
        int ans = numSubarrayProductLessThanK(arr, 10);
        System.out.println(ans);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        return isSubPathDFS(root, head) || isSubPathDFS(root.left, head) || isSubPathDFS(root.right, head);
    }

    public boolean isSubPathDFS(TreeNode root, ListNode head) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (head.val != root.val) {
            return false;
        }

        return isSubPathDFS(root.left, head.next) || isSubPathDFS(root.right, head.next);
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode s = head;
        ListNode q = head;
        for (int i = 0; i < k; i++) {
            q = q.next;
        }
        while (q != null) {
            s = s.next;
            q = q.next;
        }
        return s;
    }

    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            return -1;
        }

        ListNode s = head;
        ListNode q = head;
        for (int i = 0; i < k; i++) {
            q = q.next;
        }
        while (q != null) {
            s = s.next;
            q = q.next;
        }
        return s.val;
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
