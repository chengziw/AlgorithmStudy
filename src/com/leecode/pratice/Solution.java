package com.leecode.pratice;

import com.leecode.dto.Util;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/29 11:54
 * @Poject: AlgorithmStudy
 */
public class Solution {

    public void shellSort(int[] arr){
        if(arr.length<1) return;

        int N=arr.length;
        int h=1;

        while(h<N/3) h=3*h+1;
        while (h>=1){
            for(int i=h;i<N;i++){
                for(int j=i;j-h>0&&arr[j]>arr[j-h];j=j-h){
                    Util.swap(arr,j,j-h);
                }
            }
        }
        h=h*3;

    }

    public void testShell(){

    }
}
