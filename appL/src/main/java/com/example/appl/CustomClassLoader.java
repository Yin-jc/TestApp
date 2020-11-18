package com.example.appl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader{

    private String root;

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassData(String className) {
        String[] strings = className.split("\\.");
        String fileName = root + File.separator + strings[strings.length - 1] + ".class";
//        String fileName = root + File.separator + className + ".class";
//        String fileName = root + File.separator + className.replace('.', File.separatorChar) + ".class";
        byte[] data = new byte[0];
        try {
            InputStream fis = new FileInputStream(fileName);
            int length = fis.available();
            data = new byte[length];
            fis.read(data);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        CustomClassLoader loader = new CustomClassLoader();
        loader.setRoot("/Users/miyokocxy/Downloads");
        try {
            Object o = loader.loadClass("com.example.appl.TestClassLoader").newInstance();
//            Object o = loader.loadClass("TestClassLoader").newInstance();
            System.out.println(o.getClass().getClassLoader());
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
