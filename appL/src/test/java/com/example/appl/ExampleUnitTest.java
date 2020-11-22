package com.example.appl;

import com.example.custom.String;
import com.example.custom.TestClassLoader;

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
    public void testClassLoader() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }

    @Test
    public void testClassLoader2() throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        classLoader.loadClass(TestClassLoader.class.getName());
        Class.forName(TestClassLoader.class.getName());
        Class.forName(TestClassLoader.class.getName(), false, classLoader);
    }

    @Test
    public void testClassLoader3() {
        String.main(new String[]{});
    }

}