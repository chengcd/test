package com.ccd.test.design.memento;

/**
 * Created by ccd on 2017/12/13.
 */
public class Original {
    private String value;

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value  = value;
    }

    public Original(String value){
        this.value = value;
    }

    public Memento createMemento(){
        return  new Memento(value);
    }

    public void restoreMemento(Memento memento){
        this.value = memento.getValue();
    }

}
