package com.leecode.day;

import com.leecode.dto.ListNode;

import java.util.Stack;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/26 20:10
 * @version: 1.0.0
 */
public class Day04_26 {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyArea = 0, yzArea = 0, zxArea = 0;
        for (int i = 0; i < n; i++) {
            int yzHeight = 0, zxHeight = 0;
            for (int j = 0; j < n; j++) {
                xyArea += grid[i][j] > 0 ? 1 : 0;
                yzHeight = Math.max(yzHeight, grid[j][i]);
                zxHeight = Math.max(zxHeight, grid[i][j]);
            }
            yzArea += yzHeight;
            zxArea += zxHeight;
        }
        return xyArea + yzArea + zxArea;
    }

    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[]{};
        }

        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        for (int i = 0 ;i < ans.length;i++){
            ans[i] = stack.pop();
        }
        return ans;
    }
}
