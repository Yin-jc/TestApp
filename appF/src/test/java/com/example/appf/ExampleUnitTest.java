package com.example.appf;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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
    public void testGeneric() {
        GenericClass<String> genericClass = new GenericClass<>();
        genericClass.setData("hello");
        System.out.println(genericClass.getData());
    }

    @Test
    public void testGeneric2() {
        ImlGenericInterface<String> genericInterface = new ImlGenericInterface<>();
        genericInterface.setData("hello");
        System.out.println(genericInterface.getData());

        ImlGenericInterface2 genericInterface2 = new ImlGenericInterface2();
        genericInterface2.setData("world");
        System.out.println(genericInterface2.getData());
    }

    @Test
    public void testGeneric3() {
        GenericMethod.Animal animal = new GenericMethod.Animal();
        GenericMethod.Dog dog = new GenericMethod.Dog();
        GenericMethod.Fruit fruit = new GenericMethod.Fruit();

        GenericMethod<GenericMethod.Animal> genericMethod = new GenericMethod<>();
        genericMethod.show(animal);
        genericMethod.show(dog);

        genericMethod.show2(animal);
        genericMethod.show2(dog);
        genericMethod.show2(fruit);
    }

    @Test
    public void testGeneric4() {
        GenericTypeLimit<ArrayList<Object>> genericTypeLimit = new GenericTypeLimit<>();
        int a = genericTypeLimit.getMin(1, 2);
        String b = genericTypeLimit.getMin("ab", "ac");
        System.out.println(a);
        System.out.println(b);

        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("write");
        list.add("code");
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        GenericTypeLimit<ArrayList<String>> genericTypeLimit2 = new GenericTypeLimit<>();
        genericTypeLimit2.setData(list);
        GenericTypeLimit<ArrayList<Integer>> genericTypeLimit3 = new GenericTypeLimit<>();
        genericTypeLimit3.setData(list2);
        int c = genericTypeLimit2.getMinListSize(genericTypeLimit2.getData().size(), genericTypeLimit3.getData().size());
        System.out.println(c);
    }

    @Test
    public void testGeneric5() {
        GenericRestrict<Integer> integerGenericRestrict = new GenericRestrict<>();
        GenericRestrict<Integer> integerGenericRestrict2 = new GenericRestrict<>();
        GenericRestrict<String> stringGenericRestrict = new GenericRestrict<>();

        System.out.println(integerGenericRestrict == integerGenericRestrict);
        System.out.println(integerGenericRestrict == integerGenericRestrict2);
        // TODO: 2020/10/29 why?
//        System.out.println(integerGenericRestrict == stringGenericRestrict);
        System.out.println(integerGenericRestrict.getClass().getName());
        System.out.println(stringGenericRestrict.getClass().getName());
    }

    @Test
    public void testGeneric6() {
//        GenericInherit.Father father = new GenericInherit.Father();
        GenericInherit.Father father = new GenericInherit.Son();
//        GenericInherit.Father father = new GenericInherit.Son2();
        GenericInherit.Son son = new GenericInherit.Son();

        GenericInherit<GenericInherit.Father> fatherGenericInherit = new GenericInherit<>();
        fatherGenericInherit.setData1(father);
        fatherGenericInherit.setData1(son);

        GenericInherit.SubGenericInherit<GenericInherit.Father> fatherSubGenericInherit = new GenericInherit.SubGenericInherit<>();
        fatherSubGenericInherit.setData1(father);
        fatherSubGenericInherit.setData1(son);

        GenericInherit<GenericInherit.Son> sonGenericInherit = new GenericInherit<>();
        sonGenericInherit.setData1((GenericInherit.Son) father);
        sonGenericInherit.setData1(son);

        GenericInherit.SubGenericInherit<GenericInherit.Son> sonSubGenericInherit = new GenericInherit.SubGenericInherit<>();
        sonSubGenericInherit.setData1((GenericInherit.Son) father);
        sonSubGenericInherit.setData1(son);
    }

    @Test
    public void testGeneric7() {
        GenericByWildcard genericByWildcard = new GenericByWildcard();
        genericByWildcard.use();
        genericByWildcard.useExtends();
        genericByWildcard.useSuper();
        genericByWildcard.useNone();
    }

    @Test
    public void testGeneric8() {
        //匿名内部类
        GenericType<String> genericType = new GenericType<String>() {};
        Type superclass = genericType.getClass().getGenericSuperclass();
        Type type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
        System.out.println(type.getTypeName());
    }
}