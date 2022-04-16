package com.leecode.day;

import com.leecode.dto.ListNode;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/15 19:43
 * @version: 1.0.0
 */
public class Day04_15 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int quotient = n / k, remainder = n % k;

        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            parts[i] = curr;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return parts;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode s = head;
        ListNode q = head;

        while (s != null) {
            s = s.next;
            if (q == null || q.next == null) {
                return null;
            }
            q = q.next.next;
            if (s == q) {
                q = head;
                while (s!=q){
                    s=s.next;
                    q=q.next;
                }
                return s;
            }
        }

        return null;
    }

}