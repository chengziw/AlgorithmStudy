package com.leecode.day;

import com.leecode.dto.ListNode;
import org.junit.jupiter.api.Test;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/11 19:39
 * @version: 1.0.0
 */
public class Day04_11 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }

    @Test
    public void test() {
        //91
        //739
        System.out.println(countNumbersWithUniqueDigits(3));
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int len1 = listLength(head1);
        int len2 = listLength(head2);
        ListNode l = len1 >= len2 ? head1 : head2;
        ListNode s = l == head1 ? head2 : head1;
        ListNode curL = l;
        ListNode curS = s;
        ListNode last = curL;
        int carry = 0;
        int curNum = 0;
        while (curS != null) {
            curNum = curL.val + curS.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while (curL != null) {
            curNum = curL.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        if (carry != 0) {
            last.next = new ListNode(1);
        }
        return l;
    }

    // 求链表长度
    public static int listLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * create by: wangzicheng
     * description: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
     * create time: 2022/4/11 21:15
     * version: v1.0.0
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode qNode = head;
        ListNode sNode = dummy;
        for (int i = 0; i < n; i++) {
            qNode = qNode.next;
        }

        while (qNode != null) {
            qNode = qNode.next;
            sNode = sNode.next;
        }
        sNode.next = sNode.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    /**
     * create by: wangzicheng
     * description: https://leetcode-cn.com/problems/rotate-list/
     * create time: 2022/4/11 21:17
     * version: v1.0.0
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

}
