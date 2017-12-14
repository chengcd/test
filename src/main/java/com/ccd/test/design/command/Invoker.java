package com.ccd.test.design.command;

/**
 * Created by ccd on 2017/12/13.
 */
public class Invoker {
    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void action(){
        command.exe();
    }
}
