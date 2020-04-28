package com.leecode.study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/16 19:09
 * @Poject: AlgorithmStudy
 * @description:合并区间
 */
public class Solution7 {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0 || intervals == null) return result.toArray(new int[0][]);

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] > right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }

            result.add(new int[]{left,right});
            i++;
        }
        return result.toArray(new int[0][]);
    }

    @Test
    public void testMerge() {
        int[][] a = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] b = merge(a);
        for (int x = 0; x < b.length; x++)
        //循环输出二维数组的for循环嵌套
        //有多少维度就有多少个for循环（嵌套在其中），一般不大于三维
        {
            for (int y = 0; y < b[x].length; y++) {
                System.out.print(b[x][y] + ",");
            }
        }

    }

}
