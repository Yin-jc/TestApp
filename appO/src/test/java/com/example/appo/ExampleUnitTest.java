package com.example.appo;

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

}