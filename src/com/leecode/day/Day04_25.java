package com.leecode.day;

import com.leecode.dto.ListNode;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/25 21:53
 * @version: 1.0.0
 */
public class Day04_25 {

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = res << 1;
            res |= head.val;
            head = head.next;
        }
        return res;
    }
}
