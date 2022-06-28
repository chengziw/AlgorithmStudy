package com.leecode.month.month_06;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_06
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/6/8 19:14
 * @version: 1.0.0
 */
public class Day_08 {
    public boolean isBoomerang(int[][] points) {
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }

    @Test
    public void testQueue() {
        long start = System.currentTimeMillis();
        List<List<String>> lists = solveNQueens(4);
        lists.forEach(e -> {
            e.forEach(es -> System.out.println(es));
        });
        System.out.println(System.currentTimeMillis() - start);
    }


    public int queue(int n) {
        int[] recode = new int[n];
        return dealQueue(recode, 0, n);
    }

    public int dealQueue(int[] record, int index, int n) {
        if (index == n) {
            List<String> q = getString(record);
            res.add(q);
            return 1;
        }
        int res = 0;
        for (int i = 0; i < record.length; i++) {
            if (valid(record, index, i)) {
                record[index] = i;
                res += dealQueue(record, index + 1, n);

            }
        }
        return res;
    }

    public boolean valid(int[] ints, int index, int j) {
        for (int i = 0; i < index; i++) {
            if (ints[i] == j || (Math.abs(ints[i] - j) == Math.abs(i - index))) {
                return false;
            }
        }
        return true;
    }


    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] record = new int[n];
        dealQueueNew(record, 0, n);
        return res;
    }

    public void dealQueueNew(int[] record, int index, int n) {
        if (index == n) {
            List<String> q = getString(record);
            res.add(q);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (valid(record, n, i)) {
                record[index] = i;
                dealQueueNew(record, index + 1, n);
            }
        }
        System.out.println("-----");
        return;
    }

    //将满足要求的集合返回
    public List<String> getString(int[] cur) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < cur.length; i++) {
            char[] ch = new char[cur.length];
            Arrays.fill(ch, '.');
            ch[cur[i]] = 'Q';
            list.add(String.valueOf(ch));
        }
        return list;
    }

    public int queueBit(int n) {
        if (n < 0 || n > 32) {
            return -1;
        }
        int limit = (n == 32) ? -1 : (1 << n) - 1;
        return dealQueueBit(limit, 0, 0, 0);
    }

    public int dealQueueBit(int limit, int colLimit, int leftLimit, int rightLimit) {
        if (colLimit == limit) {
            return 1;
        }

        int pos = limit & (~(colLimit | leftLimit | rightLimit));

        int rightOne = 0;
        int res = 0;
        while (pos != 0) {
            rightOne = pos & (~pos + 1);

            pos = pos - rightOne;

            res += dealQueueBit(limit, (colLimit | rightOne), (leftLimit | rightOne) << 1, (rightLimit | rightOne) >> 1);
        }
        return res;
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        char[][] board = new char[8][8];
        for (int[] q : queens) {
            board[q[0]][q[1]] = 'Q';
        }

        int[][] dir = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        List<List<Integer>> ans = new ArrayList<>();

        for (int[] d : dir) {
            dealQueensAttacktheKing(board, king[0], king[1], d[0], d[1], ans);
        }
        return ans;
    }

    public boolean dealQueensAttacktheKing(char[][] queue, int x, int y, int crX, int crY, List<List<Integer>> ans) {
        if (x < 0 || x >= queue.length || y < 0 || y >= queue.length) {
            return false;
        }

        if (queue[x][y] == 'Q') {
            List<Integer> coordinate = new ArrayList<Integer>();
            coordinate.add(x);
            coordinate.add(y);
            ans.add(coordinate);
            return true;
        }
        return dealQueensAttacktheKing(queue, x + crX, y + crY, crX, crY, ans);
    }

}
