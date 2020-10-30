package com.example.testapp;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    Lock lock = new ReentrantLock();
    int goods = 0;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void threadTest() {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    lock.lock();
                    synchronized (this) {
                        while (goods < 10) {
                            goods++;
                            System.out.println(Thread.currentThread().getName() + " -> Goods = " + goods);
                        }
                    }
//                    lock.unlock();
                }
            }, "Thread - " + i).start();
        }
    }
}