package com.leecode.string;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangzicheng
 * @Date: 2020/5/6 16:05
 * @Poject: AlgorithmStudy
 * leecode：6
 * 字形变换：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 */
public class Convert {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());
        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();

    }

    @Test
    public void testCouvert(){
        String s =convert("sfsdfaaefcaceffae",4);
        System.err.println(s);
    }
}
