package com.leecode.pratice;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/15 11:56
 * @Poject: AlgorithmStudy
 */
public class Pratice3 {

    public void quickSort(int[] arr) {
        int temp;
        for(int i=1;i<arr.length;i++){
            temp=arr[i];
            for(int j=i;j>=0;j--){
                if(j>0&&arr[j-1]>temp){
                    arr[j] = arr[j-1];
                }else {
                    arr[j] = temp;
                    break;
                }
            }
        }
    }

    @Test
    public void test() {
        int arr[] = {65, 58, 95, 10, 57, 62, 13, 106, 78, 23, 85};
       // quickSort(arr, 0, arr.length - 1);
        quickSort(arr);
        IntStream.of(arr).boxed().collect(Collectors.toList()).stream().forEach(System.out::println);
    }
}

