package com.leecode.pratice;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/17 12:01
 * @Poject: AlgorithmStudy
 */
public class Pratice4 {
    public void qisort(int[] arr) {
        for(int gap=arr.length/2;gap>0;gap/=2){
            int i=gap;
            for(int j=gap;j<arr.length;j++){
                if(j-gap>0&&arr[j]>arr[j-gap]){
                    arr[j]=arr[j-gap];
                }else {
                    arr[j]=arr[i];
                    break;
                }
            }
        }
    }

    @Test
    public void testStr() {
        int[] arr = new int[]{1, 34, 1, 34, 2, 3, 3, 43, 423, 4234};
       qisort(arr);
        IntStream.of(arr).boxed().forEach(System.out::println);
    }
}
