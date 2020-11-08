package com.example.apph;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    int data = 0;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testBit() {
        //补码
        System.out.println(Integer.toBinaryString(-128));
    }

    @Test
    public void testCAS() {
        IntStream.range(0, 2).forEach(value -> new Thread(() -> {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IntStream.range(0, 1000).forEach(value1 -> data++);
        }).start());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(data);
    }

    @Test
    public void testLock() {
        Lock lock = new ReentrantLock();
        IntStream.range(0, 2).forEach(value -> new Thread(() -> {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IntStream.range(0, 1000).forEach(value1 -> {
                lock.lock();
                data++;
                lock.unlock();
            });
        }).start());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(data);
    }

    @Test
    public void testAtomicInteger() {
        AtomicInteger atomicInteger = new AtomicInteger();
        IntStream.range(0, 2).forEach(value -> new Thread(() -> {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IntStream.range(0, 1000).forEach(value1 -> {
                atomicInteger.incrementAndGet();
//                atomicInteger.getAndIncrement();
            });
        }).start());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(atomicInteger.get());
    }

    @Test
    public void testLongAdder() {
        LongAdder longAdder = new LongAdder();
        IntStream.range(0, 2).forEach(value -> new Thread(() -> {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IntStream.range(0, 1000).forEach(value1 -> {
                longAdder.increment();
            });
        }).start());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(longAdder.sum());
    }

}