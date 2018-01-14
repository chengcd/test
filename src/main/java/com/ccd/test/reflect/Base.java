package com.ccd.test.reflect;

/**
 * Created by ccd on 2018/1/14.
 */
public class Base{
    static int num = 1;

    static {
        System.out.println("Base " + num);
    }
}
