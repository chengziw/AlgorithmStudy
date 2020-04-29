package com.leecode.test;

import com.leecode.dto.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/14 15:22
 * @Poject: AlgorithmStudy
 *进阶要求 不能反转所以用stack实现
 *时间:O(max(m,n))
 *空间:O(m+n) m与n分别为两个链表的长度 把链表入栈所用的空间。
 */

public class Solution5 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //java stack源码 推荐栈相关的用ArrayDeque类来实现 遵循官方建议所以用ArrayDeque
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();

        //将两个链表分别入栈
        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2= l2.next;
        }

        int carry =0;
        ListNode after = null;
        while(!stack1.isEmpty()||!stack2.isEmpty()||carry!=0){
            //栈先进后出的性质 所以取出的是最后入栈的元素 并求和
            int n1 = stack1.isEmpty()?0:stack1.pop();
            int n2 = stack2.isEmpty()?0:stack2.pop();
            int sum = n1+n2+carry;

            //根据和求当前位置的值 和 进位的值 并连接上链表
            ListNode tmp = new ListNode(sum%10);
            tmp.next = after;
            after = tmp;
            carry=sum/10;
        }
        return after;
    }
}



