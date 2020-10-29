package com.example.appf;

public class ImlGenericInterface<T> implements GenericInterface<T> {
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public T getData() {
        return data;
    }
}
