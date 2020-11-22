package com.example.appl;

public class TestConstantFold {

    public static void main(String[] args) {
        String s = "ab";
        //无常量折叠
        String s1 = "a";
        String s2 = "b";
        //String运算符重载
        // StringBuilder(s1).append(s2).toString();
        //toString实现为new String();
        String s3 = s1 + s2;
        System.out.println(s == s3);
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(s3));

        //常量折叠 final的字符串变量
        String ss = "xy";
        final String s4 = "x";
        final String s5 = "y";
        String s6 = s4 + s5;
        System.out.println(ss == s6);

        //无常量折叠 final字符串对象 不满足编译期常量定义
        final String s8 = new String("x");
        final String s9 = new String("y");
        String s10 = s8 + s9;
        System.out.println(ss == s10);

        //常量折叠 字面量
        int i1 = 1 + 2;

        //常量折叠 final的基本数据类型变量
        final int i2 = 11;
        final int i3 = 12;
        int i4 = i2 + i3;

    }
}
