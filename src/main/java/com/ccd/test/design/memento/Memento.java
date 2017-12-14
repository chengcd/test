package com.ccd.test.design.memento;

/**
 * Created by ccd on 2017/12/13.
 */
public class Memento {
    private  String value;
    public Memento(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public void setValue(){
        this.value = value;
    }
}
