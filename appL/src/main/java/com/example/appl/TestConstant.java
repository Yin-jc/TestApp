package com.example.appl;

public class TestConstant {

    //类变量
    static final innerTestConstant constant = new innerTestConstant();
    //成员变量
    final innerTestConstant constant2 = new innerTestConstant();

    @SuppressWarnings("AccessStaticViaInstance")
    public static void main(String[] args) {
        TestConstant constant = new TestConstant();
        TestConstant constant2 = new TestConstant();
        System.out.println(constant.constant);
        System.out.println(constant2.constant);
        System.out.println(constant.constant2);
        System.out.println(constant2.constant2);
    }

    static class innerTestConstant {

    }
}
