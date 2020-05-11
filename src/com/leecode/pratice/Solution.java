package com.leecode.pratice;

import com.leecode.dto.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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
    public void shellSort(int[] ints){
        int N=ints.length;
        int h=1;

        while(h<N/3) h=3*h+1;

        while(h>1){

            for(int i=h;i<ints.length;i++){

                for(int j=i;j>0;j=j-i){

                }
            }
            h=3*h;
        }
    }

    @Test
    public void test(){
        int[] ints=new int[]{10,1,2,7,6,1,5};

        ExecutorService executorsService=Executors.newCachedThreadPool();

    }
}