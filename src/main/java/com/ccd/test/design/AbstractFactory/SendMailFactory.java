package com.ccd.test.design.AbstractFactory;

/**
 * Created by ccd on 2017/12/4.
 */
public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
