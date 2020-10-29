package com.example.appf;

public class ImlGenericInterface2 implements GenericInterface<String> {
    private String data;

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return data;
    }
}
