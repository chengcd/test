package com.ccd.test.design.Decorator;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by ccd on 2017/12/6.
 */
public class Decorator implements Sourceable {

    private Sourceable source;

    public Decorator(Sourceable source){
        super();
        this.source = source;
    }


    @Override
    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }
}
