package com.leecode.day;

import com.leecode.dto.ListNode;
import com.leecode.dto.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/19 21:12
 * @version: 1.0.0
 */
public class Day04_19 {

    public int[] shortestToChar(String s, char c) {
        char[] chas = s.toCharArray();
        int[] ans = new int[s.length()];
        for (int i = 0; i < chas.length; i++) {
            if (c == chas[i]) {
                ans[i] = 0;
            } else {
                ans[i] = minInt(chas, c, i);
            }
        }
        return ans;
    }

    public int minInt(char[] chars, char c, int i) {
        int l = i;
        int r = i;
        int result = 0;
        while (l - 1 >= 0 && r + 1 < chars.length) {
            l--;
            r++;
            result++;
            if (c == chars[l] || c == chars[r]) {
                return result;
            }
        }

        while (l - 1 >= 0) {
            l--;
            result++;
            if (c == chars[l]) {
                return result;
            }
        }

        while (r + 1 < chars.length) {
            r++;
            result++;
            if (c == chars[r]) {
                return result;
            }
        }
        return result;
    }


    public int[] shortestToCharAns(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        for (int i = 0, idx = -n; i < n; ++i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = i - idx;
        }

        for (int i = n - 1, idx = 2 * n; i >= 0; --i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = Math.min(ans[i], idx - i);
        }
        return ans;
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < k; i++) {
            left = left.next;
        }

        ListNode curNode = left;
        while (curNode.next != null) {
            right = right.next;
            curNode = curNode.next;
        }

        int value = right.val;
        right.val = curNode.val;
        curNode.val = value;
        return head;
    }

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }

        int res = 0;
        for (Map.Entry<Integer,Integer> map:hashMap.entrySet()
        ) {
            if (hashMap.containsKey(map.getKey() + 1)){
                res = Math.max(res, hashMap.get(map.getKey()) + hashMap.get(map.getKey() + 1));
            }
        }
        return res;
    }

    int ans = 0;
    public int findTilt(TreeNode root) {
       return dfs(root);
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumLeft = dfs(node.left);
        int sumRight = dfs(node.right);
        ans += Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + node.val;
    }

}
