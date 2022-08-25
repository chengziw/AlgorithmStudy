package com.leecode.pratice;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {

    //原子类保证原子性，也可以使用volatile
    //volatile则可以直接在主内存读写，当一个线程更新了值，其他线程能够及时获知。
    AtomicInteger size = new AtomicInteger(0);
    private volatile int capacity = 100;
    //自己实现阻塞队列，需要一个容器，内部实现了一个node，如果改造为不只是int的，使用T泛型
    private LinkedList<Integer> container;

    public MyQueue() {
        container = new LinkedList<>();
    }

    /**
     * 入队
     *
     * @param value
     * @throws InterruptedException
     */
    public void push(int value) {
        //每一个线程都会获得锁，但是如果条件不满足则会阻塞
        for (; ; ) {
            //阻塞的话必须用循环，让这个线程再次获得cpu片段的时候能够够执行
            int s = size.get();
            while (s >= capacity) {
                //入队线程阻塞，把锁释放？
                return;
            }
            if (compareAndSet(s + 1, s + 1, s)) {
                container.addFirst(value);
                size.incrementAndGet();
            }

        }
    }

    public int pop() {
        for (; ; ) {
            if (size.get() > 0) {
                int lastValue = container.getLast();
                container.removeLast();
                size.decrementAndGet();
                return lastValue;
            }
        }
    }

    public int size() {
        return size.get();
    }

    public boolean compareAndSet(int value, int target, int before) {

        return true;
    }
}
