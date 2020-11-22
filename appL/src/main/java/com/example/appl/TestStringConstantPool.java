package com.example.appl;

public class TestStringConstantPool {

    public static void main(String[] args) {
        //s1指向heap里的新建对象 s2指向字符串常量池指向的对象
        String s1 = new String("Hello");
        String s2 = s1.intern();
        System.out.println(s1 == s2);

        //str3的引用变了
        String str3 = "a";
        str3 = "bc";
        System.out.println(str3);

        String str4 = "Hello";
//        str4 = append(str4);
        String str5 = append(str4);
        System.out.println(str4);
    }

    public static String append(String s) {
        return s + "World";
    }
}
