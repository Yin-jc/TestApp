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
        Thread t = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(5000);
                    while (true) {

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notifyAll();
            }
        });
//        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t3 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("t3 get lock");
                int cnt = 0;
                while (cnt < 5) {
                    cnt++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notifyAll();
                cnt = 0;
                while (cnt < 5) {
                    cnt++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t3.start();

        while (true) {
            System.out.println(t.getName() + " state is " + t.getState());
//            System.out.println(t2.getName() + " state is " + t2.getState());
            System.out.println(t3.getName() + " state is " + t3.getState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}