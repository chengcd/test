package com.ccd.test.design.Observer;


/**
 * Created by ccd on 2017/12/12.
 */
public class Observer1 implements Observer{
    @Override
    public void update() {
        System.out.println("oberver1 has received!");
    }
}
