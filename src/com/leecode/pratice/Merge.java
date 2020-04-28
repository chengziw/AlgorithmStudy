package com.leecode.pratice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/23 18:07
 * @Poject: AlgorithmStudy
 */
public class Merge {
    private int[] aux;

    public void sort(int[] a){
        aux=new int[a.length];
        sort(a,0,a.length-1);
    }

    public void sort(int[] a,int lo,int hi){
        if(hi<=lo) return;
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public void merge(int[] a,int lo,int mid,int hi){
        int i=lo,j=mid+1;
        for (int k=lo;k<=hi;k++){
            aux[k]=a[k];
        }
        for(int k=lo;k<=hi;k++){
            if(i>mid){
                a[k]=aux[j++];
            }else if(j>hi){
                a[k]=aux[i++];
            }else if(aux[j]<aux[i]){
                a[k]=aux[j++];
            }else {
                a[k]=aux[i++];
            }
        }
    }
    @Test
    public void testMerge(){
        int[] ints = new int[]{3, 2, 5, 3, 5, 25, 3, 5, 543, 535, 34, 53, 45,3,3,2,2,2,4324,2};
        System.out.println(Arrays.toString(ints));
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
