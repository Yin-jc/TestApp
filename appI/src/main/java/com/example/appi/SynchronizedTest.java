package com.example.appi;

public class SynchronizedTest {
    public synchronized void method() {
        while (true) {
            System.out.println(Thread.currentThread());
        }
    }

    public static synchronized void method2() {
        while (true) {
            System.out.println(Thread.currentThread());
        }
    }

    public void method3() {
        while (true) {
            System.out.println(Thread.currentThread());
        }
    }
}
