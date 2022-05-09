package com.leecode.thread;

public class ThreadQuestOne {
    //简单计数器
    private static int COUNT = 0;
    //对象锁
    private static final Object LOCK = new Object();

    private static int Flag = 0;

    public static void main(String[] args) {
        syncLock();
    }

    private static void syncLock() {
        new Thread(() -> {
            while (COUNT < 100) {
                synchronized (LOCK) {
                    if (Flag == 0) {
                        System.out.println("线程0--->" + (COUNT++));
                        Flag = 1;
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (COUNT < 100) {
                synchronized (LOCK) {
                    if (Flag == 1) {
                        System.out.println("线程1--->" + (COUNT++));
                        Flag = 2;
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (COUNT < 100) {
                synchronized (LOCK) {
                    if (Flag == 2) {
                        System.out.println("线程2--->" + (COUNT++));
                        Flag = 0;
                    }
                }
            }
        }).start();
    }
}