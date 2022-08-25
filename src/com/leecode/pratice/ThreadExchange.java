package com.leecode.pratice;

import java.util.concurrent.Exchanger;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.pratice
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/8/11 15:48
 * @version: 1.0.0
 */
public class ThreadExchange {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Exchanger exchanger = new Exchanger();

        new Thread(() -> {
            try {
                Object data = "-公众号Java技术栈AAA";
                System.out.println(Thread.currentThread().getName() + data);

                // 开始交换数据
                data = exchanger.exchange(data);
                System.out.println(Thread.currentThread().getName() + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Object data = "-公众号Java技术栈BBB";
                System.out.println(Thread.currentThread().getName() + data);

                // 开始交换数据
                data = exchanger.exchange(data);
                System.out.println(Thread.currentThread().getName() + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
