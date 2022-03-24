package com.leecode.code;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.code
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/3/23 19:44
 * @version: 1.0.0
 */
public class Code5_LinkedListToQueue {

    public static class Node<V> {
        public V value;
        public Node next;

        public Node(int value) {
            value = value;
        }
    }

    public static class LinkedListToQueue<V> {
        public Node<V> head;
        public Node<V> tail;
        public int size;

        public boolean isEmpty() {
            return size == 0;
        }

        public int getSize() {
            return size;
        }

        public void offer(int value) {
            Node cur = new Node(value);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public V poll() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            if (head == null) {
                tail = null;
            }
            return ans;
        }
    }

}
