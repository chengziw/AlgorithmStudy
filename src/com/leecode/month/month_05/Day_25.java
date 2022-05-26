package com.leecode.month.month_05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_05
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/5/25 15:17
 * @version: 1.0.0
 */
public class Day_25 {

    private static AtomicInteger index = new AtomicInteger(10);

    static AtomicStampedReference<Integer> version = new AtomicStampedReference(10, 1);

    public static void main(String[] args) {
        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "版本号1：" + version.getStamp());
            version.compareAndSet(10, 11, version.getStamp(), version.getStamp() + 1);

            System.out.println(Thread.currentThread().getName() + "版本号2：" + version.getStamp());
            version.compareAndSet(11, 10, version.getStamp(), version.getStamp() + 1);

            System.out.println(Thread.currentThread().getName() + "版本号3：" + version.getStamp());
            System.out.println(Thread.currentThread().getName() + ":10->11->10");
        }, "张三").start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "版本号4：" + version.getStamp());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "版本号5：" + version.getStamp());

                boolean isSuccess = version.compareAndSet(10, 12, version.getStamp(), version.getStamp() + 1);

                System.out.println(Thread.currentThread().getName() + "版本号6：" + version.getStamp());
                System.out.println(Thread.currentThread().getName() + ":index 是预期的 10 吗 ： " + isSuccess + "。设置的新值是：" + version.getStamp());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "李四").start();

    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }

        if (nums.length == 1 && nums[0] != target) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;

        int[] ans = new int[]{-1,-1};
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans[0] = mid;
                int tempL = mid - 1;
                int tempR = mid + 1;
                while (tempL >= 0 && nums[mid] == nums[tempL]){
                    ans[1] = ans[0];
                    ans[0] = tempL;
                    tempL --;
                }
                while (tempR < nums.length && nums[mid] == nums[tempR]){
                    ans[1] = tempR;
                    tempR ++;
                }
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1 ;
            }
        }


        return ans;

    }

    @Test
    public void test(){
        searchRange(new int[]{5,7,7,8,8,10},6);
    }
}
