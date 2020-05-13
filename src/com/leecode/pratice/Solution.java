package com.leecode.pratice;

import com.leecode.dto.ListNode;
import com.leecode.dto.Node;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/29 11:54
 * @Poject: AlgorithmStudy
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 */
class Solution {

    public static void main(String[] args) {

      //第一步：准备数据
        Node root = new Node("火车头") ;
        Node n1 = new Node("车厢A") ;
        Node n2 = new Node("车厢B") ;

        // 链接节点
        root.setNext(n1);
        n1.setNext(n2);

        //第二步：取出所有数据
        Node currentNode = root ;  //从当前根节点开始读取
        while( currentNode !=  null){
            System.out.println(currentNode.getData()) ;
            //将下一个节点设置为当前节点s
            currentNode = currentNode.getNext() ;
        }

        Node dummyHead = new Node("aa");
        Node tail = dummyHead;


        tail.setNext(n1);
        tail = n1;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummyHead.next;
    }

}