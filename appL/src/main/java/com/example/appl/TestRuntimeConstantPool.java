package com.example.appl;

public class TestRuntimeConstantPool {
    private TestRuntimeConstantPool test = new TestRuntimeConstantPool();
    private static TestRuntimeConstantPool test2 = new TestRuntimeConstantPool();
    private static final TestRuntimeConstantPool test3 = new TestRuntimeConstantPool();

    public void method() {
        TestRuntimeConstantPool test4 = new TestRuntimeConstantPool();
        method2();
    }

    public static void method2() {
        TestRuntimeConstantPool test5 = new TestRuntimeConstantPool();
    }

    public static void main(String[] args) {

    }

}
