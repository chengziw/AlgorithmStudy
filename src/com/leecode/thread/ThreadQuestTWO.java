package com.leecode.thread;

import java.util.concurrent.CompletableFuture;

public class ThreadQuestTWO {
    //简单计数器
    private static int COUNT = 0;
    //对象锁
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        notifyAllMethod();
    }

    private static void notifyAllMethod() {
        Runnable rs = () -> {
            while (COUNT <= 100) {
                synchronized (LOCK) {
                    System.out.println(Thread.currentThread().getName() + "" + (COUNT++));
                    LOCK.notifyAll();
                    if ((COUNT & 1) == 0) {
                        //阻塞
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        CompletableFuture.allOf(CompletableFuture.runAsync(rs),
                CompletableFuture.runAsync(rs)).join();
    }
}