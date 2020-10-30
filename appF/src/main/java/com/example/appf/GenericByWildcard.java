package com.example.appf;

import androidx.annotation.NonNull;

public class GenericByWildcard {
    private void print(GenericClass<Fruit> fruitGenericClass) {
        System.out.println(fruitGenericClass.getData().toString());
    }

    public void use() {
        GenericClass<Fruit> fruitGenericClass = new GenericClass<>();
        Fruit fruit = new Fruit();
        fruitGenericClass.setData(fruit);
        print(fruitGenericClass);
        GenericClass<Apple> appleGenericClass = new GenericClass<>();
        Apple apple = new Apple();
        appleGenericClass.setData(apple);
//        print(appleGenericClass);
    }

    private void printExtends(GenericClass<? extends Fruit> genericClass) {
        System.out.println(genericClass.getData().toString());
    }

    public void useExtends() {
        GenericClass<Fruit> fruitGenericClass = new GenericClass<>();
        Fruit fruit = new Fruit();
        fruitGenericClass.setData(fruit);
        printExtends(fruitGenericClass);
        GenericClass<Apple> appleGenericClass = new GenericClass<>();
        Apple apple = new Apple();
        appleGenericClass.setData(apple);
        printExtends(appleGenericClass);
        GenericClass<Food> foodGenericClass = new GenericClass<>();
        Food food = new Food();
        foodGenericClass.setData(food);
//        printExtends(foodGenericClass);
    }

    private void printSuper(GenericClass<? super Apple> genericClass) {
        System.out.println(genericClass.getData().toString());
    }

    public void useSuper() {
        GenericClass<Fruit> fruitGenericClass = new GenericClass<>();
        Fruit fruit = new Fruit();
        fruitGenericClass.setData(fruit);
        printSuper(fruitGenericClass);
        GenericClass<Apple> appleGenericClass = new GenericClass<>();
        Apple apple = new Apple();
        appleGenericClass.setData(apple);
        printSuper(appleGenericClass);
        GenericClass<RedApple> redAppleGenericClass = new GenericClass<>();
        RedApple redApple = new RedApple();
        redAppleGenericClass.setData(redApple);
//        printSuper(redAppleGenericClass);
    }

    private void printNone(GenericClass<?> genericClass) {
        System.out.println(genericClass.getData().toString());
    }

    public void useNone() {
        GenericClass<Food> foodGenericClass = new GenericClass<>();
        Food food = new Food();
        foodGenericClass.setData(food);
        printNone(foodGenericClass);
        GenericClass<Fruit> fruitGenericClass = new GenericClass<>();
        Fruit fruit = new Fruit();
        fruitGenericClass.setData(fruit);
        printNone(fruitGenericClass);
        GenericClass<Apple> appleGenericClass = new GenericClass<>();
        Apple apple = new Apple();
        appleGenericClass.setData(apple);
        printNone(appleGenericClass);
        GenericClass<RedApple> redAppleGenericClass = new GenericClass<>();
        RedApple redApple = new RedApple();
        redAppleGenericClass.setData(redApple);
        printNone(redAppleGenericClass);
    }

    static class Food {
        @NonNull
        @Override
        public String toString() {
            return "Food";
        }
    }
    static class Fruit extends Food {
        @NonNull
        @Override
        public String toString() {
            return "Fruit";
        }
    }

    static class Apple extends Fruit {
        @NonNull
        @Override
        public String toString() {
            return "Apple";
        }
    }

    static class RedApple extends Apple {
        @NonNull
        @Override
        public String toString() {
            return "RedApple";
        }
    }

    static class Orange extends Fruit {
        @NonNull
        @Override
        public String toString() {
            return "Orange";
        }
    }
}
