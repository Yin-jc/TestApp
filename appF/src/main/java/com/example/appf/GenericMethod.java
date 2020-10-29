package com.example.appf;

import androidx.annotation.NonNull;

public class GenericMethod<T> {

    public void show(T t) {
        System.out.println(t.toString());
    }

    public <K> void show2(K k) {
        System.out.println(k.toString());
    }

    static  class Animal {
        @NonNull
        @Override
        public String toString() {
            return "Animal";
        }
    }

    static class Dog extends Animal {
        @NonNull
        @Override
        public String toString() {
            return "Dog";
        }
    }

    static class Fruit {
        @NonNull
        @Override
        public String toString() {
            return "Fruit";
        }
    }
}
