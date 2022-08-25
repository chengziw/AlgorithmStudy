package com.leecode.pratice.format;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    public static void main(String args[]) {
        //TODO 测试待补充
        Node[] root = initNode2();
        deleteNullRoot(root);
    }

    public static void deleteNullRoot(Node[] root) {
        if (root == null || root.length < 1) {
            return;
        }

        //构建节点 map缓存
        HashMap<Node, Integer> nodeMap = new HashMap<>();
        Set<Integer> indexSet = new HashSet<>();

        for (int i = 0; i < root.length; i++) {
            Node dummy = root[i];
            while (null != dummy && !nodeMap.containsKey(dummy)) {
                nodeMap.put(dummy, dummy.index);
                indexSet.add(dummy.index);
                dummy = dummy.next;
            }
        }


        for (int i = 0; i < root.length; i++) {
            Node dummy = root[i];
            //判断当前节点是否被他人引用
            if (null != dummy && !indexSet.contains(i)) {
                root[i] = null;
            }
        }

        System.out.println();
    }


    public static class Node {
        public int index;

        public Node next;

        public Node() {
        }

        public Node(int index) {
            this.index = index;
        }
    }


    private static Node[] initNode2() {

        Node[] array = new Node[5];

        Node node0 = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        node0.index = 0;
        node0.next = node1;
        array[0] = node0;

        node1.index = 1;
        node1.next = node1;
        array[1] = node1;

        node2.index = (2);
        node2.next = node2;
        array[2] = node2;

        node3.index = (3);
        node3.next = node1;
        array[3] = node3;

        node4.index = 4;
        node4.next = node3;
        array[4] = node4;

        return array;
    }


}

