package com.example.appf;

public class GenericInherit<T> {

    private T data1;
    private T data2;

    public T getData1() {
        return data1;
    }

    public void setData1(T data1) {
        this.data1 = data1;
    }

    public T getData2() {
        return data2;
    }

    public void setData2(T data2) {
        this.data2 = data2;
    }

    static class SubGenericInherit<T> extends GenericInherit<T> {

    }

    static class Father {

    }

    static class Son extends Father {

    }

    static class Son2 extends Father {

    }
}
