package com.zgx.practice;

import com.zgx.mymap.MyHashMap;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo {

    @Test
    public void test() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap();
        for (int i = 0; i < 20; i++) {
            myHashMap.put(i , i + "value");
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(myHashMap.get(i));
        }
        System.out.println(myHashMap.size());
    }
    @Test
    public void test2() {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }
    @Test
    public void a () {
        int a = 4541686;
        int b = 0;
        boolean flag = true;
        while ( flag) {
            b = b * 10 + a % 10;
            if (a / 10 == 0) {
                flag = false;
            }
            a = (a - a % 10) / 10;
        }
        System.out.println(b);
    }
}

