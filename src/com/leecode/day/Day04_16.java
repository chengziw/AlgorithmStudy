package com.leecode.day;

import com.leecode.dto.ListNode;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/16 11:25
 * @version: 1.0.0
 */
public class Day04_16 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = list1;

        ListNode curNode = list1;
        int i = 0;
        ListNode pre = null;
        ListNode next = null;
        while (list1 != null) {
            if (i == a - 1) {
                pre = list1;
            } else if (i == b) {
                next = list1;
            }
            i++;
            list1 = list1.next;
        }

        pre.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = next;

        return dummy.next;
    }

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int upper = (int) Math.pow(10, n) - 1;
        int ans = 0;
        for (int left = upper; ans == 0; --left) { // 枚举回文数的左半部分
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                p = p * 10 + x % 10; // 翻转左半部分到其自身末尾，构造回文数 p
            }
            for (long x = upper; x * x >= p; --x) {
                if (p % x == 0) { // x 是 p 的因子
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }


}
