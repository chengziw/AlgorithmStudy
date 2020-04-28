package com.leecode.pratice;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/16 10:07
 * @Poject: AlgorithmStudy
 */
public class Practice {

    public int[] aux;
    public int res=0;
    public void reversePairs(int[] nums){
        aux=new int[nums.length];
        sort(nums,0,nums.length-1);
    }
        public void merge(int[] arr, int lo, int mid, int hi) {
            int i=lo;
            int j=mid+1;
            for(int n=lo;n<=hi;n++){
                aux[n]=arr[n];
            }
            for(int n=lo;n<=hi;n++){
                if(i>mid){
                    arr[n]=aux[j++];
                }else if(j>hi){
                    arr[n]=aux[i++];
                    res+=j-(mid+1);
                }else if(aux[j]<aux[i]){
                    arr[n]=aux[j++];
                }else {
                    arr[n]=aux[i++];
                    res+=j-(mid+1);
                }
            }

        }
        public void sort(int[] arr, int lo, int hi) {
            if(hi<=lo) return;
            int mid=lo+(hi-lo)/2;
            sort(arr,lo,mid);
            sort(arr,mid+1,hi);
            merge(arr,lo,mid,hi);
        }


        public int getLost(int[] arr){

        int result=0;
        for(int n:arr){
            result^=n;
        }
        return result;
        }

    public int[] singleNumbers(int[] nums) {
        int result=0;

        for(int n:nums){
            result^=n;
        }

        int[] res=new int[2];
        int lowBit=1;
        for(int n:nums){
            if((lowBit&n)==0){
                res[0]^=n;
            }else {
                res[1]^=n;
            }
        }
        return res;
    }

    @Test
    public void testSort() {
        int[] ints = new int[]{1,2,3,4,3,2,0,0};
        reversePairs(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(singleNumbers(ints)));

    }
}
