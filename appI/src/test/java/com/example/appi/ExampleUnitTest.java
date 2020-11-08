package com.example.appi;

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
    public void testSynchronized() {
        SynchronizedTest test = new SynchronizedTest();
        new Thread(test::method).start();

        new Thread(test::method).start();
    }

    @Test
    public void testSynchronized2() {
        SynchronizedTest test = new SynchronizedTest();
        SynchronizedTest test2 = new SynchronizedTest();
        new Thread(test::method).start();

        new Thread(test2::method).start();
    }

    @Test
    public void testSynchronized3() {
        new Thread(SynchronizedTest::method2).start();

        new Thread(SynchronizedTest::method2).start();
    }

    @Test
    public void testSynchronized4() {
        SynchronizedTest test = new SynchronizedTest();
        new Thread(() -> {
            synchronized (SynchronizedTest.class) {
                test.method3();
            }
        }).start();

        new Thread(() -> {
            synchronized (SynchronizedTest.class) {
                test.method3();
            }
        }).start();
    }

    @Test
    public void testSynchronized5() {
        SynchronizedTest test = new SynchronizedTest();
        new Thread(() -> {
            synchronized (test) {
                test.method3();
            }
        }).start();

        new Thread(() -> {
            synchronized (test) {
                test.method3();
            }
        }).start();
    }

    @Test
    public void testSynchronized6() {
        SynchronizedTest test = new SynchronizedTest();
        SynchronizedTest test2 = new SynchronizedTest();
        new Thread(() -> {
            synchronized (test) {
                test.method3();
            }
        }).start();

        new Thread(() -> {
            synchronized (test2) {
                test2.method3();
            }
        }).start();
    }

}