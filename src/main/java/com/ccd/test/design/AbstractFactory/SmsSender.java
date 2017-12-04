package com.ccd.test.design.AbstractFactory;

/**
 * Created by ccd on 2017/12/4.
 */
public class SmsSender implements Sender {
    @Override
    public void Send() {
        System.out.println("This is sms Sender");
    }
}
