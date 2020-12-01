package com.zgx;

import org.hibernate.validator.internal.util.privilegedactions.GetDeclaredConstructors;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.*;
import java.net.URL;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Demo {
    private volatile int num;
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.zgx.Father");
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getGenericType());
            System.out.println("annotated: " + declaredField.getAnnotatedType());
            System.out.println(declaredField.getType());
            System.out.println(Modifier.toString(declaredField.getModifiers()));
        }
    }

    private static List<? extends Teacher> getTeacherList() {
        List<Student> studentList = new ArrayList<>();
        return studentList;
    }

    private static void deleteFile(File resourceFile) {
        if (resourceFile.exists()) {
            if (resourceFile.isFile()) {
                resourceFile.delete();
                return;
            }
            File[] files = resourceFile.listFiles();
            if (files.length == 0) {
                resourceFile.delete();
            }
            for (File file : files) {
                deleteFile(file);
               file.delete();
            }
            resourceFile.delete();
        }
    }
}
class Father{
    private static int a;
    public Father(){
        System.out.println("fffffhj");
    }
    final void a() {

    }
    void b(){
        System.out.println("fff");
    }
    public static void c() {
        System.out.println("fffff");
    }
}
class Child extends Father{
    @Override
    void b() {
        System.out.println("ccc");
    }
    public static void c() {
        System.out.println("asdasd");
    }
}
class A implements B{
    int k = 9;
    @Override
    public void b() {
        System.out.println(222);
    }
}

interface B {
    int k = 0;
    Integer i = 03;
    static void a(){
        System.out.println(333);
    }
    void b();
}
