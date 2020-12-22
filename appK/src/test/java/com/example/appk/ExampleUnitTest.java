package com.example.appk;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static org.junit.Assert.assertEquals;

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
    public void testThreadPool() {
        //只有核心线程 适合少量长期任务
        ExecutorService fixThreadPool = Executors.newFixedThreadPool(5);

        //只有非核心线程 适合大量并发短期任务
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        //只有一个核心线程 适合串行任务
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

        //适合周期性任务
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
    }

}