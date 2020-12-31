package com.example.appp;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
    public void testGCRoots() {
        //虚拟机栈引用
        TestGCRoot root = new TestGCRoot();
        root.initLocalMem();
        System.gc();
    }

    @Test
    public void testGCRoots2() {
        //类变量引用
        TestGCRoot root = new TestGCRoot();
        root.initStaticMem();
        root = null;
        System.gc();
    }

    @Test
    public void testGCRoots3() {
        TestGCRoot root = new TestGCRoot();
        root.initFieldMem();
        root = null;
        System.gc();
    }

    @Test
    public void testGCRoots4() {
        String s = "Hello";
    }

}