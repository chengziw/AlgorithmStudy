package com.leecode.sortStudy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/16 14:51
 * @Poject: AlgorithmStudy
 * @Description 堆排序
 * 最小时间复杂度：O(nlogn)
 * 最大时间复杂度：O(nlogn)
 * 平均时间复杂度：O(nlogn)         所有代码执行情况累计  /  所有情况数量
 * 额外空间：o(1)
 * 稳定性：不稳定
 */
public class HeapSort {
    public static void sort(int []arr){
        //1.构建小顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void heapSortApi(int[] arr){

        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->a-b);
        for(int i=0;i<arr.length;i++){
            queue.offer(arr[i]);
        }
        while (queue.size()!= 0){
            System.out.println(queue.poll());
        }
    }


    @Test
    public  void test(){
        int []arr = {1,9,3,35,45,2,346,547,57,45,6,743,8,664564,74,5,4235,645,477,4643,437,5,64,65464,56,47,43,645636,4654,654,7547,4,64563,73,47,43,643,6,333,734,7,436,3474,7347,435,63,74,7,53,745784,43,7,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
