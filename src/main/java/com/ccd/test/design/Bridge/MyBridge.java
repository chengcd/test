package com.ccd.test.design.Bridge;

/**
 * Created by ccd on 2017/12/6.
 */
public class MyBridge extends Bridge {
    public void method(){
        getSource().method();
    }
}
