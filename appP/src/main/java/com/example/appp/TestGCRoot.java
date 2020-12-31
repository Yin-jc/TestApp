package com.example.appp;

public class TestGCRoot {

    static byte[] sMem;
    byte[] mMem;
    String[] strMem;

    public void initStaticMem() {
        sMem = new byte[8 * 10 * 1024 * 1024];
    }

    public void initFieldMem() {
        mMem = new byte[8 * 10 * 1024 * 1024];
    }

    public void initLocalMem() {
        byte[] mem = new byte[8 * 10 * 1024 * 1024];
        System.gc();
    }

    public void initStringMem(String s) {
        strMem = new String[8 * 10 * 1024 * 1024];
    }
}
