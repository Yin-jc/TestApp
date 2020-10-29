package com.example.appf;

public class GenericRestrict<T> {

    private T data;

    public void setData(T data) {
        this.data = data;
    }

    private static <K> K getKey(K k) {
        return k;
    }


}
