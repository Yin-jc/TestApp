package com.example.appn;

import org.junit.Test;

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
    public void testThreadLocal() {
        //一个Thread只对应一个ThreadLocalMap
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("Yjc");
        ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();
        threadLocal2.set(1);
        threadLocal2.remove();
        new Thread(() -> threadLocal.set("Hello")).start();
        new Thread(() -> threadLocal.set("World")).start();
        System.out.println(threadLocal.get());
    }

}