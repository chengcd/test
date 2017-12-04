package com.ccd.test.design.Builder;

import com.ccd.test.design.AbstractFactory.MailSender;
import com.ccd.test.design.AbstractFactory.Sender;
import com.ccd.test.design.AbstractFactory.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccd on 2017/12/4.
 */
public class Builder {
    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count){
        for(int i=0;i<count;i++){
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for(int i=0; i<count; i++){
            list.add(new SmsSender());
        }
    }
}
