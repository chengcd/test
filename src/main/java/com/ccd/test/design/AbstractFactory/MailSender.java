package com.ccd.test.design.AbstractFactory;

/**
 * Created by ccd on 2017/12/4.
 */
public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is mail sender");
    }
}
