package com.ccd.test.design.Adapter;

/**
 * Created by ccd on 2017/12/6.
 */
public class Adapter extends  Source implements Targetable {

    @Override
    public void method2() {
        System.out.println("this is the Targetable method");
    }
}
