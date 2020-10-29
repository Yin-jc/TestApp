package com.example.appf;

import java.io.Serializable;
import java.util.List;

public class GenericTypeLimit<T extends List & Serializable> {

    public <K extends Comparable<K>> K getMin(K a, K b) {
        return a.compareTo(b) < 0 ? a : b;
    }

    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public <T extends Comparable<T>> T getMinListSize(T a, T b) {
        return a.compareTo(b) < 0 ? a : b;
    }

}
