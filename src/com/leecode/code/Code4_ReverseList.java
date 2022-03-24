package com.leecode.code;


/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.code
 * @author: wangzicheng
 * @description: 链表反转
 * @date: 2022/3/23 19:06
 * @version: 1.0.0
 */
public class Code4_ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    /**
     * create by: wangzicheng
     * description: 单链表反转
     * create time: 2022/3/23 19:07
     * version: v1.0.0
     */
    public static Node listReverse1(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public class DubboNode {
        public int value;
        public DubboNode last;
        public DubboNode next;

        public DubboNode(int value) {
            value = value;
        }
    }

    public DubboNode ReverseList2(DubboNode head) {
        DubboNode pre = null;
        DubboNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;

        }
        return pre;

    }
}
