package com.ccd.test.design.Bridge;

/**
 * Created by ccd on 2017/12/6.
 */
public class SourceSub1 implements  Sourceable {
    @Override
    public void method() {
        System.out.println("this is the first sub!");
    }
}
