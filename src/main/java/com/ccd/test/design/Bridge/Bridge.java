package com.ccd.test.design.Bridge;

/**
 * Created by ccd on 2017/12/6.
 */
public abstract class Bridge {
    private Sourceable source;
    public void method(){
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}
