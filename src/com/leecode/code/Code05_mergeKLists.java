package com.leecode.code;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.code
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/3/24 19:53
 * @version: 1.0.0
 */
public class Code05_mergeKLists {

    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null){
                heap.offer(lists[i]);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            heap.add(pre.next);
        }

        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return head;

    }

    public class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public ListNode mergeTwoNode(ListNode node1,ListNode node2) {
        if (node1 == null){
            return node2;
        }else if (node2 == null){
            return node1;
        }else if (node1.val < node2.val){
           node1.next  = mergeTwoNode(node1.next,node2);
           return node1;
        }else {
            node2.next = mergeTwoNode(node2.next,node1);
            return node2;
        }
    }

}
