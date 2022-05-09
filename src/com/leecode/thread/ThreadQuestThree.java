package com.leecode.thread;

import java.util.concurrent.CompletableFuture;

public class ThreadQuestThree {
    //简单计数器
    private static int COUNT = 0;
    //对象锁
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        CompletableFutureTest();
    }

    //第三种方式相互隔离的方式
    private static void CompletableFutureTest() {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            while (COUNT < 100) {
                synchronized (LOCK) {
                    if ((COUNT & 1) == 0) {
                        System.out.println("当前偶数线程" + (COUNT++));
                    }
                }
            }
        });

        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() -> {
            while (COUNT < 100) {
                synchronized (LOCK) {
                    if ((COUNT & 1) == 1) {
                        System.out.println("当前奇数线程" + (COUNT++));
                    }
                }
            }
        });
        CompletableFuture.allOf(cf, cf1).join();
    }
}
