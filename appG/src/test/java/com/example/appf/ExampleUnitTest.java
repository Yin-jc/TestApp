package com.example.appf;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testThread() {
        Object lock = new Object();
        /**
         * t与t2
         * wait超时 若拿不到锁 则进入blocked 过程中timed_waiting
         */
        Thread t = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                while (true) {

                }
            }
        });

        /**
         * t2与t3
         * synchronized拿不到锁 直接进入blocked
         */
        Thread t3 = new Thread(() -> {
            synchronized (lock) {
                while (true) {

                }
            }
        });

        /**
         * t4与t5
         * wait notify
         */
        Thread t4 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    while (true) {

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t5 = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(5000);
                    lock.notifyAll();
                    //此处虽然唤醒等待线程池 但此线程并不释放锁
                    while (true) {

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


//        t.start();
//        t2.start();
//        t3.start();
        t4.start();
        t5.start();

        while (true) {
//            System.out.println(t.getName() + " state is " + t.getState());
//            System.out.println(t2.getName() + " state is " + t2.getState());
//            System.out.println(t3.getName() + " state is " + t3.getState());
            System.out.println(t4.getName() + " state is " + t4.getState());
            System.out.println(t5.getName() + " state is " + t5.getState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}