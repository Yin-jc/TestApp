package com.example.appl;

import org.openjdk.jol.info.ClassLayout;

public class TestClassLayout {
    static class A {
        boolean b;
        Object o1;
    }

    static class B extends A {
        int i;
        long l;
        Object o2;
        float f;
    }

    static class C extends B {
        boolean b;
    }

    public static void main(java.lang.String[] args) {
        System.out.println(ClassLayout.parseClass(C.class).toPrintable());
    }
}
