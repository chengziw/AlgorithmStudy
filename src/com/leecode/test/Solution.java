package com.leecode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/9 19:09
 * @Poject: AlgorithmStudy
 */
public class Solution {

    ArrayList[] cache = new ArrayList[100];

    public List<String> generateParenthesis(int n) {
        return generate(n);
    }

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generate(c))
                    for (String right : generate(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        cache[n] = ans;
        return ans;
    }

}
