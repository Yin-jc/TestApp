package com.example.appo;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
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

    @Test
    public void testArrayList() {
        ArrayList<String> list = new ArrayList<>();
        //初始化后第一次手动扩容 capacity必须>10 否则不扩容
        list.ensureCapacity(11);

        Class<?> clz = list.getClass();
        try {
            Field field = clz.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] arr = (Object[]) field.get(list);
            System.out.println(arr.length);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testArrayListTraversal() {
        String[] strings = {"1", "2", "2", "4", "4", "6", "5", "2", "7", "8"};
        List<String> list = new ArrayList<>(Arrays.asList(strings));

        /**
         * 普通for循环 可以remove多个不相邻元素
         */
        /*for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("2")) {
                list.remove(i);
            }
        }*/

        /**
         * 普通for循环 如果remove多个相邻元素 可以倒序遍历
         */
        /*for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals("2")) {
                list.remove(i);
            }
        }*/

        /**
         * 增强for循环 add、remove后break 则不会报ConcurrentModificationException
         */
        /*for (String str :
                list) {
            if (str.equals("1")) {
                list.remove(str);
//                break;
            }
        }*/

        /**
         * iterator遍历 List.remove会报ConcurrentModificationException
         * Iterator.remove不会报 因为更新了expectedModCount
         */
        /*Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals("1")) {
//                list.remove(str);
                iterator.remove();
            }
        }*/

        /**
         * 两线程并发读写 iterator.remove也不会报ConcurrentModificationException
         */
        new Thread(() -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals("2")) {
                    iterator.remove();
                }
            }
        }).start();

        new Thread(() -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }).start();


        /*for (String str :
                list) {
            System.out.println(str);
        }*/
    }

    @Test
    public void testHashMapTraversal() {
        HashMap<Integer, String> map = new HashMap<>();
        String s = map.put(1, "Hello");
        String s2 = map.put(2, "World");

        /**
         * foreach迭代entry
         */
        for (Map.Entry<Integer, String> entry :
                map.entrySet()) {
            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
        }

        /**
         * foreach迭代key和value
         */
        for (int key :
                map.keySet()) {
            System.out.println("key = " + key);
        }
        for (String value :
                map.values()) {
            System.out.println("value = " + value);
        }

        /**
         * iterator迭代
         */
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
        }
    }

    @Test
    public void testLinkedHashMapTraversal() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put(1, "Hello");
        map.put(2, "World");
        map.put(3, "Code");

        map.get(2);

        for (Map.Entry<Integer, String> entry :
                map.entrySet()) {
            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
        }
    }

    @Test
    public void testArrayListTraversalTime() {
        int count = 1000000;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add("第" + i + "个元素");
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void testArrayListTraversalTime2() {
        int count = 1000000;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add("第" + i + "个元素");
        }

        long start = System.currentTimeMillis();
        for (String str :
                list) {

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void testArrayListTraversalTime3() {
        int count = 1000000;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add("第" + i + "个元素");
        }

        long start = System.currentTimeMillis();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void testLinkedListTraversalTime() {
        int count = 10000;
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            list.add("第" + i + "个元素");
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void testLinkedListTraversalTime2() {
        int count = 1000000;
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            list.add("第" + i + "个元素");
        }

        long start = System.currentTimeMillis();
        for (String str :
                list) {

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void testLinkedListTraversalTime3() {
        int count = 1000000;
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            list.add("第" + i + "个元素");
        }

        long start = System.currentTimeMillis();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }



}