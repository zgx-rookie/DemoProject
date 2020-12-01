package com.zgx.test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

public class Test2 {

    @Test
    public void test() {
        // 均采用降序
        Integer[] arrays = generateArrays();
        for (Integer array : arrays) {
            System.out.print(array + " ");
        }
        System.out.println();
        for (int i = 1; i < arrays.length; i++) {
            int array = arrays[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (array > arrays[j]) {
                    arrays[j + 1] = arrays[j];
                    continue;
                };
                break;
            }
            arrays[j + 1] = array;
        }
        List<Integer> integers = Arrays.asList(arrays);
        integers.forEach(num -> System.out.print(num + " "));
    }

    private Integer[] generateArrays() {
        Integer[] intArrays = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(100);
            intArrays[i] = num;
        }
        return intArrays;
    }

    @Test
    public void a() {
        int i = 0;
        int b = b(i);
        System.out.println(b);
    }

    private int b(int i) {
        try {
            return ++i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            i = 9;
        }
        return i;
    }

    // 选择排序
    void selectSort(Integer[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int min =i;
            for (int j = i; j < arrays.length; j++) {
                if (arrays[j] < arrays[min]) {
                    min = j;
                }
            }
            int tmp = arrays[i];
            arrays[i] = arrays[min];
            arrays[min] = tmp;
        }
    }

    // 插入排序
    void insertSort(Integer[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            int tmpNum =arrays[i];
            int temp = i - 1;
            while (temp >= 0 && tmpNum > arrays[temp]) {
                arrays[temp + 1] = arrays[temp];
                temp --;
            }
            arrays[temp + 1] = tmpNum;
        }
    }
}

class A{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
