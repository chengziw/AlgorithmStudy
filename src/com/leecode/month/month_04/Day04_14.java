package com.leecode.month.month_04;


import com.leecode.dto.ListNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/14 22:45
 * @version: 1.0.0
 */
public class Day04_14 {

    public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            maxWealth = Math.max(maxWealth, Arrays.stream(account).sum());
        }
        return maxWealth;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode s = head;
        ListNode q = head;
        Stack<ListNode> stack = new Stack<>();
        while (s != null) {
            stack.push(new ListNode(s.val));
            s = s.next;
        }

        while (q != null) {
            if (q.val != stack.pop().val) {
                return false;
            }
            q = q.next;
        }
        return true;
    }

    public int[] nextLargerNodes(ListNode head) {
        // step1
        // 链表转数组
        List<Integer> ls = new LinkedList<>();
        // 辅助哈希表，记录各元素的索引位置，相同元素可能出现多次。方便回溯查找。
        HashMap<Integer, LinkedList<Integer>> valIndexMap = new HashMap<>();
        int index = 0;
        while (head != null) {
            int val = head.val;
            ls.add(val);
            // 记录各元素索引位置
            if (valIndexMap.get(val) == null) {
                valIndexMap.put(val, new LinkedList<>());
            }
            // 重复元素，按顺序记录索引位置
            valIndexMap.get(val).add(index);
            index++;
            head = head.next;
        }
        int[] rs = ls.stream().mapToInt(Integer::intValue).toArray();

        // step2
        // 单调递减栈
        LinkedList<Integer> drabQueue = new LinkedList<>();
        // 遍历数组
        for (int i = 0; i < rs.length; i++) {
            int val = rs[i];
            // 在单调递减栈中，遇到下一个更大元素
            while (!drabQueue.isEmpty() && val > drabQueue.peek()) {
                // 弹出栈顶，从辅助哈希表中找到元素索引列表
                Queue<Integer> queue = valIndexMap.get(drabQueue.poll());
                while (!queue.isEmpty() && i >= queue.peek()) {
                    // 更新当前索引之前的元素
                    rs[queue.poll()] = val;
                }
            }
            // 单调递减栈入队
            drabQueue.addFirst(val);
        }

        // step3
        // 最后栈尾元素处理，剩余元素都是匹配不到下一个最大值
        while (!drabQueue.isEmpty()) {
            int key = drabQueue.poll();
            Queue<Integer> queue = valIndexMap.get(key);
            while (!queue.isEmpty()) {
                // 依题意全部置0
                rs[queue.poll()] = 0;
            }
        }

        return rs;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            tail.next = minNode;
            tail = minNode;
            if (tail.next != null){
                queue.offer(tail.next);
            }
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = null;
        nextLargerNodes(listNode1);
//        while (ans != null) {
//            System.out.println(ans.val);
//            ans = ans.next;
//        }
    }
}
