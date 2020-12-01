package com.zgx;

import org.apache.tomcat.util.ExceptionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadPool {


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int a = -1534236469;
        if (a > Integer.MAX_VALUE || a < Integer.MIN_VALUE) {
            System.out.println(0);
            return;
        }
        int result = 0;
        while (a != 0) {
            result = result * 10 + a % 10;
            a = (a - a % 10) /10;
        }
        System.out.println(result);
    }
    @Test
    public void test() {
       String str = " ";
        System.out.println(str.length());
    }
}

