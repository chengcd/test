package com.ccd.test.design.mediator;

/**
 * Created by ccd on 2017/12/13.
 */
public abstract class User {
    private Mediator mediator;

    public User(Mediator mediator){
        this.mediator = mediator;
    }

    public Mediator  getMediator() {
        return mediator;
    }

    public abstract void work();
}
