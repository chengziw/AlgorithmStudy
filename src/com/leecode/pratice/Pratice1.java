package com.leecode.pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/10 17:00
 * @Poject: AlgorithmStudy
 */
public class Pratice1 {
    public static void main(String []args){
        int []arr = {1,9,3,7,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr){
        //1.构建大顶堆
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
        System.out.println(Arrays.toString(arr));
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
        System.out.println(Arrays.toString(arr));
    }





    public static void bulleSort(int[] ints){
        if(ints.length<1) return;
        for(int i=0;i<ints.length-1;i++){
            for(int j=0;j<ints.length-1-i;j++){
                if(ints[j]>ints[j+1]){
                    int temp=ints[j];
                    ints[j]=ints[j+1];
                    ints[j+1]=temp;
                }
            }
        }
    }

    public static void selectSort(int[] ints){
        for(int i=0;i<ints.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<ints.length;j++){
                if(ints[j]<ints[minIndex]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                int temp=ints[minIndex];
                ints[minIndex]=ints[i];
                ints[i]=temp;
            }
        }
    }



    public static double getMediaArrays(int[] A,int[] B){
       int m=A.length;
        int n=B.length;
        if(m>n){
            int temp[]=A;
            A=B;
            B=temp;
            int tmp=m;
            m=n;
            n=tmp;
        }
        int iMin=0,iMax=m,halfLen=(m+n+1)/2;
        if(iMin<iMax){
            while(iMin<=iMax){
                int i=(iMin+iMax)/2;
                int j=halfLen-i;
                if(i<iMax&&B[j-1]>A[i]){
                    iMin=i+1;
                }else if(i>iMin&&A[i-1]>B[j]){
                    iMax=i-1;
                }else {
                    int maxLeft=0;
                    if(i==0){
                        maxLeft=B[j-1];
                    }else if(j==0){
                        maxLeft=A[i-1];
                    }else {
                        maxLeft=Math.max(A[i-1],B[j-1]);
                    }

                    if((m+n)%2==1){
                        return maxLeft;
                    }

                    int minRight=0;
                    if(i==m){
                        minRight=B[j];
                    }else if(j==n){
                        minRight=A[i];
                    }else {
                        minRight=Math.min(A[i],B[j]);
                    }
                    return (minRight+maxLeft)/2.0;
                }
            }
        }
        return 0.0;

    }


    public static List<Integer> getMin(int[] ints, int k){
        List<Integer> result=new ArrayList<>();
        if(ints.length<k||ints.length<1){
            return result;
        }

        for(int i=0;i<k;i++){
            int maxN=maxIndex(ints,k);
            if(ints[i]<ints[maxN]){
                int temp=ints[maxN];
                ints[maxN]=ints[i];
                ints[i]=temp;
            }

        }
        for(int n:ints){
            result.add(n);
        }
        return result;
    }

    public static int maxIndex(int[] ints,int k){
        int maxN=k;
        for(int i=k+1;i<ints.length;i++){
            if(ints[i]>ints[maxN]){
                maxN=i;
            }
        }
        return maxN;
    }
}
