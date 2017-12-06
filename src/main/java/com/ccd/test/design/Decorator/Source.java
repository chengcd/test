package com.ccd.test.design.Decorator;

/**
 * Created by ccd on 2017/12/6.
 */
public class Source implements  Sourceable {
    @Override
    public void method() {
        System.out.println(" tie original method!");
    }
}
