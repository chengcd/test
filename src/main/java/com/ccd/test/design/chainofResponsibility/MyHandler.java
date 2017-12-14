package com.ccd.test.design.chainofResponsibility;

/**
 * Created by ccd on 2017/12/13.
 */
public class MyHandler extends AbstractHandler implements Handler {
    private String name;

    public MyHandler(String name){
        this.name = name;
    }


    @Override
    public void operator() {
        System.out.println(name+"deal!");
        if(getHandler()!=null){
            getHandler().operator();
        }
    }
}
