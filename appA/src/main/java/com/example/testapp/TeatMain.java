package com.example.testapp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TeatMain {
    static Lock lock = new ReentrantLock();
    static int goods = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    while (goods < 10) {
                        goods++;
                        System.out.println(Thread.currentThread().getName() + " -> Goods = " + goods);
                    }
                }
            }, "Thread - " + i).start();
        }
    }
}
