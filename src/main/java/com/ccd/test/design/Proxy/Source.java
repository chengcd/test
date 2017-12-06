package com.ccd.test.design.Proxy;

/**
 * Created by ccd on 2017/12/6.
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
