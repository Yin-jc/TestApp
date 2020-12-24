package com.example.appo;

import org.junit.Test;

import java.util.Arrays;

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
    public void testSystemArrayCopy() {
        String[] src = new String[8];
        src[0] = "Hello";
        src[1] = "world";
        src[2] = "Hello";
        src[3] = "China";
        System.arraycopy(src, 0, src, 4, 2);
        System.out.println(src);
        for (String str :
                src) {
            System.out.println(str);
        }
    }

    @Test
    public void testArraysCopyOf() {
        String[] src = {"Hello", "World", "Hello", "China"};
        String[] dst = Arrays.copyOf(src, 2);
        for (String str :
                src) {
            System.out.println(str);
        }
        System.out.println("-----------");
        for (String str :
                dst) {
            System.out.println(str);
        }
    }

}