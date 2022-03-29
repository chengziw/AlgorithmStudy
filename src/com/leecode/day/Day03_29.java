package com.leecode.day;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/3/29 19:29
 * @version: 1.0.0
 */
public class Day03_29 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    /**
     * create by: wangzicheng
     * description: 反转指定位置的链表
     * create time: 2022/3/29 20:32
     * version: v1.0.0
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode curNode = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = curNode.next;
            curNode.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    /**
     * create by: wangzicheng
     * description: https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
     * create time: 2022/3/29 20:33
     * version: v1.0.0
     */
    public ListNode deleteNode(ListNode head, int val) {
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
