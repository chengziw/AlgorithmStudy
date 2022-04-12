package com.leecode.day;

import com.leecode.dto.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/12 19:40
 * @version: 1.0.0
 */
public class Day04_12 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head.next;

        ListNode curNode = dummy;
        while (curNode != null && curNode.next != null && curNode.next.next != null) {
            ListNode h = curNode;
            ListNode o = curNode.next;
            ListNode t = o.next;

            h.next = t;
            o.next = t.next;
            t.next = o;
            curNode = curNode.next.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;

        return newHead;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>();
        ListNode curNode = head;
        while (curNode != null) {
            if (queue.size() < 1) {
                queue.offer(curNode);
                curNode = curNode.next;
            } else {
                ListNode node = queue.peek();
                if (node.val != curNode.val) {
                    queue.offer(curNode);
                    curNode = curNode.next;
                }
            }
        }

        for (int i = 0; i < queue.size(); i++) {
            dummy.next = queue.poll();
            dummy = dummy.next;
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode s = head;
        ListNode q = head.next;
        while (q != null) {
            if (s.val != q.val) {
                pre.next = s;
                pre = pre.next;
                s = s.next;
                q = q.next;
            } else {
                s = q;
                q = q.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(-101);
        ListNode pre = dummyHead;
        pre.next = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }


    public ListNode deleteDuplicate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curNode = dummy;
        while (curNode.next != null) {
            if (curNode.val == curNode.next.val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode;
            }
        }
        return dummy.next;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode sNode = head;
        ListNode qNode = head;

        while (qNode.next != null) {
            sNode = sNode.next;
            qNode = qNode.next.next;
            if (qNode == sNode) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     ListNode fast = head, slow = head;
     while (true) {
     if (fast == null || fast.next == null) return null;
     fast = fast.next.next;
     slow = slow.next;
     if (fast == slow) break;
     }
     fast = head;
     while (slow != fast) {
     slow = slow.next;
     fast = fast.next;
     }
     return fast;
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode sNode = head;
        ListNode qNode = head;
        while (true){
            if (qNode==null || qNode.next == null){
                return  null;
            }
            sNode = sNode.next;
            qNode = qNode.next.next;
            if (sNode == qNode){
                break;
            }
        }

        sNode = dummy.next;
        while (sNode != qNode){
            sNode = sNode.next;
            qNode = qNode.next;
        }

        return sNode;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }

        while (headB!=null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

}
