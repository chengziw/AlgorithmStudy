package com.leecode.pratice;

import com.leecode.dto.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wangzicheng
 * @Date: 2020/5/15 10:01
 * @Poject: AlgorithmStudy
 */
public class PraticeDemo {
    @Test
    public void testDemo() {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);

        List<ListNode> listNodes = new ArrayList<>();
        listNodes.add(listNode);
        listNodes.add(listNode1);
        Map<String, List<ListNode>> map = new HashMap<>();
        map.put("data", listNodes);
    }

    @Test
    public void testN() {
        Long start = System.currentTimeMillis();
        int n = 100000;
        long k = 0;
        for (long i = 0; i < n; i++) {
            for (long j = i; j < n; j++) {
                k++;
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    @Test
    public void testAddDigits() {
        System.out.println(addDigits(123123123));
    }

    public int addDigits(int num) {
        //1232323
        int x = num % 10;
        int y = (num - x) / 10;
        if (x + y < 10) {
            return x + y;
        } else {
            int temp = x + addDigits(y);
            if (temp < 10) {
                return temp;
            } else {
                return addDigits(temp);
            }
        }
        //return (num - 1) % 9 + 1;
    }


}
