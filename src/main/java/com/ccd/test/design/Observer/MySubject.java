package com.ccd.test.design.Observer;

/**
 * Created by ccd on 2017/12/12.
 */
public class MySubject extends  AbstractSubject {
    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }




}
