package com.ccd.test.design.factory;

/**
 * Created by ccd on 2017/12/4.
 */
public class SmsSender implements Sender{
    @Override
    public void Send() {
        System.out.println("this is sms sender!");
    }
}
