package com.leecode.code;

import java.util.List;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.code
 * @author: wangzicheng
 * @description: https://leetcode.com/problems/add-two-numbers/
 * @date: 2022/3/24 11:10
 * @version: 1.0.0
 */
public class Code05_AddTwoNumbers {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static int getLength(ListNode node) {
        int len = 0;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int l1 = getLength(head1);
        int l2 = getLength(head2);
        ListNode L = l1 > l2 ? head1 : head2;
        ListNode S = L == head1 ? head2 : head1;
        ListNode curl = L;
        ListNode curs = S;
        ListNode lastNode = curl;
        int sum = 0;
        int carry = 0;
        while (curs != null) {
            int num = curl.val + curs.val + carry;
            sum += num % 10;
            carry = num / 10;
            lastNode = curl;
            curl = curl.next;
            curs = curs.next;
        }
        while (curl != null) {
            int num = curl.val + carry;
            sum += num%10;
            carry = num/10;
            lastNode = curl;
            curl = curl.next;
        }
        if (carry != 0){
            lastNode.next= new ListNode(1);
        }
        return L;
    }
}
