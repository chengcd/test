package com.ccd.test.design.mediator;

/**
 * Created by ccd on 2017/12/13.
 */
public class User2 extends User {

    public User2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user2 exe!");
    }
}
