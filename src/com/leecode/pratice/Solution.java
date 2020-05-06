package com.leecode.pratice;

import com.leecode.dto.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        HashMap<Integer,Integer> hashMap=new HashMap();
        for(int i=0;i<candidates.length;i++){
            if(hashMap.containsKey(candidates[i])){
                List<Integer> temp=new ArrayList<>();
                temp.add(candidates[i]);
                temp.add(hashMap.get(candidates[i]));
                hashMap.remove(candidates[i]);
                result.add(temp);
            }else {
                hashMap.put(target-candidates[i],candidates[i]);
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] ints=new int[]{10,1,2,7,6,1,5};
        combinationSum2(ints,8).stream().forEach(System.out::println);
    }
}