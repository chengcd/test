package com.ccd.test.design.memento;

/**
 * Created by ccd on 2017/12/13.
 */
public class Storage {
    private Memento memento;

    public Storage(Memento memento){
        this.memento = memento;
    }

    public Memento getMemento(){
        return memento;
    }

    public void setMemento(Memento memento){
        this.memento = memento;
    }
}
