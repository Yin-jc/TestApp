package com.example.appr;

public class TestReturn {

    static class Num {
        private int num = 0;
    }

    public static void main(String[] args) {
        System.out.println(test());
        System.out.println("=============");
        System.out.println(test2());
        System.out.println("=============");
        System.out.println(test3().num);
        System.out.println("=============");
        System.out.println(test4());
    }

    /**
     * finally无return且无修改值
     */
    private static int test() {
        int num = 0;
        try {
            System.out.println("try");
            num = 10;
            return num;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        System.out.println("out return");
        return num;
    }

    /**
     * finally无return且修改值
     */
    private static int test2() {
        int num = 0;
        try {
            System.out.println("try");
            num = 10;
            return num;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
            num = 20;
        }
        System.out.println("out return");
        return num;
    }

    /**
     * finally无return且修改引用内属性
     */
    private static Num test3() {
        Num num = new Num();
        try {
            System.out.println("try");
            num.num = 10;
            return num;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
            num.num = 20;
        }
        System.out.println("out return");
        return num;
    }

    /**
     * finally有return
     */
    private static int test4() {
        int num = 0;
        try {
            System.out.println("try");
            num = 10;
            return num;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
            num = 20;
            return num;
        }
    }
}
