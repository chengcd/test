package com.ccd.test.genericity;


/**
 * Created by Wangmx on 2018/1/11.
 */
public class Demo <T extends Animal>{

    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }

    public Demo(T ob) {
        super();
        this.ob = ob;
    }

    public void print(){
        System.out.println("T的类型是："+ob.getClass().getName());
    }
}