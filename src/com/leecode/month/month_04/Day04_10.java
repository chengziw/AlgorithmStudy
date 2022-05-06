package com.leecode.month.month_04;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/10 13:06
 * @version: 1.0.0
 */
public class Day04_10 {

    public int uniqueMorseRepresentations(String[] words) {
        if (null == words) {
            return -1;
        }

        Set<String> ans = new HashSet<>();
        String[] mapString = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        for (int i = 0; i < words.length; i++) {
            StringBuilder res = new StringBuilder();
            char[] chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
               res.append(mapString[chars[j] - 'a' ]);
            }
            ans.add(res.toString());
        }
        return ans.size();
    }

    @Test
    public void test(){
        String[] words = {"gin","zen","gig","msg"};
        uniqueMorseRepresentations(words);
    }
}
