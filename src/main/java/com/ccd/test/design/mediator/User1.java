package com.ccd.test.design.mediator;

/**
 * Created by ccd on 2017/12/13.
 */
public class User1 extends User {


    public User1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user1 exe!");
    }
}
