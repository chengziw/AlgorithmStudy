package com.leecode.month.month_04;

import com.leecode.dto.ListNode;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/28 20:09
 * @version: 1.0.0
 */
public class Day04_28 {
    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;

        int temp = -1;
        while (left != right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            temp = nums[left];

            while (right > left && nums[right] % 2 == 1) {
                right--;
            }
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1;
        }

        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        int pre = 0;

        while (node1 != null && node2 != null) {
            int value = node1.val + node2.val + pre;
            ans.next = new ListNode(value % 10);
            pre = value / 10;

            node1 = node1.next;
            node2 = node2.next;
            ans = ans.next;
        }

        while (node1 != null) {
            int value = node1.val + pre;
            ans.next = new ListNode(value % 10);
            pre = value / 10;

            node1 = node1.next;
            ans = ans.next;
        }

        while (node2 != null) {
            int value = node2.val + pre;
            ans.next = new ListNode(value % 10);
            pre = value / 10;

            node2 = node2.next;
            ans = ans.next;
        }

        if (pre > 0) {

            ans.next = new ListNode(pre);
        }
        return head.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

}
