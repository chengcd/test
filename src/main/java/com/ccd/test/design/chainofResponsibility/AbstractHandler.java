package com.ccd.test.design.chainofResponsibility;

/**
 * Created by ccd on 2017/12/13.
 */
public abstract class AbstractHandler {

    private Handler handler;

    public Handler getHandler(){
        return handler;
    }

    public void setHandler(Handler handler){
        this.handler = handler;
    }
}
