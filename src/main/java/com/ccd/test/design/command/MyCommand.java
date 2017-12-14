package com.ccd.test.design.command;

/**
 * Created by ccd on 2017/12/13.
 */
public class MyCommand implements Command {
    private Receiver receiver;

    public MyCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
