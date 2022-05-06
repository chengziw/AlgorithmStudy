package com.leecode.month.month_04;

import com.leecode.dto.ListNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/13 20:57
 * @version: 1.0.0
 */
public class Day04_13 {
    List<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;

    public Day04_13() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        int index = indices.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index, last);
        indices.put(last, index);
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        Queue<ListNode> s = new ArrayDeque<>();
        Queue<ListNode> b = new ArrayDeque<>();
        ListNode curNode = head;
        while (curNode != null) {
            if (curNode.val < x) {
                s.offer(new ListNode(curNode.val));
            } else {
                b.offer(new ListNode(curNode.val));
            }
            curNode = curNode.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!s.isEmpty()) {
            dummy.next = s.poll();
            dummy = dummy.next;
        }

        while (!b.isEmpty()) {
            dummy.next = b.poll();
            dummy = dummy.next;
        }
        return cur.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> hashMap = new HashMap<>();
        Node curNode = head;
        while (curNode != null) {
            hashMap.put(curNode, new Node(curNode.val));
            curNode = curNode.next;
        }

        curNode = head;
        while (curNode != null) {
            hashMap.get(curNode).next = hashMap.get(curNode.next);
            hashMap.get(curNode).random = hashMap.get(curNode.random);
            curNode = curNode.next;
        }

        return hashMap.get(head);
    }


    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode s = head;
        ListNode q = head;
        while (q != null && q.next != null) {
            s = s.next;
            q = q.next.next;
        }

        ListNode dummy = s.next;
        s.next = null;

        ListNode pre = null;
        ListNode next = null;
        while (dummy != null) {
            next = dummy.next;
            dummy.next = pre;
            pre = dummy;
            dummy = next;
        }

        // 3. 合并链表head和head2
        ListNode curr = head;
        ListNode curr2 = pre;
        mergeListNode(curr, curr2);

    }

    public void mergeListNode(ListNode l1, ListNode l2) {
        ListNode t1;
        ListNode t2;
        while (l1 != null && l2 != null) {
            t1 = l1.next;
            t2 = l2.next;

            l1.next = l2;
            l1 = t1;

            l2.next = l1;
            l2 = t2;
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode s = head;
        ListNode q = head;
        while (q.next != null) {
            s = s.next;
            q = q.next.next;
        }
        s.next=s.next.next;

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
//        ListNode result = partition(listNode1, 3);
//        while (result != null) {
//            System.out.println(result.val);
//            result = result.next;
//        }
        reorderList(listNode1);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
