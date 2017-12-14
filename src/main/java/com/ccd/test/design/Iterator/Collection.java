package com.ccd.test.design.Iterator;

/**
 * Created by ccd on 2017/12/12.
 */
public interface Collection {
    public com.ccd.test.design.Iterator.Iterator iterator();

    public Object get(int i);

    //
    public int size();
}
