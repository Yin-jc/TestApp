package com.example.appq;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
    public void testHashCode() {
        Map<CustomKey, Integer> map = new HashMap<>();
        CustomKey key = new CustomKey(1, "key");
        map.put(key, 10);
        CustomKey key2 = new CustomKey(1, "key");
        map.put(key2, 11);
        CustomKey key3 = new CustomKey(1, "key");
        System.out.println(map.size());
        System.out.println(map.get(key3));
    }

    /**
     * equals为true则hashcode一定相等
     */
    @Test
    public void testEqualsAndHash() {
        TestEquals equals = new TestEquals(1, "Hello");
        TestEquals equals2 = new TestEquals(1, "Hello");
        System.out.println(equals.equals(equals2));
        System.out.println(equals.hashCode());
        System.out.println(equals2.hashCode());
    }

    /**
     * equals为false则hashcode有可能相等
     * 不同类型
     */
    @Test
    public void testNotEqualsAndHash() {
        TestEquals equals = new TestEquals(1, "Hello");
        TestHashCode hashCode = new TestHashCode(1, "Hello");
        System.out.println(equals.equals(hashCode));
        System.out.println(equals.hashCode());
        System.out.println(hashCode.hashCode());
    }

    /**
     * hashcode相等则equals有可能为false
     * 不同类型
     */
    @Test
    public void testHashAndNotEquals() {
        TestEquals equals = new TestEquals(1, "Hello");
        TestHashCode hashCode = new TestHashCode(1, "Hello");
        System.out.println(equals.equals(hashCode));
        System.out.println(equals.hashCode());
        System.out.println(hashCode.hashCode());
    }

    /**
     * hashcode不相等则equals一定为false
     */
    @Test
    public void testNotHashAndNotEquals() {
        TestEquals equals = new TestEquals(1, "Hello");
        TestEquals equals2 = new TestEquals(2, "World");
        System.out.println(equals.equals(equals2));
        System.out.println(equals.hashCode());
        System.out.println(equals2.hashCode());
    }

}