package com.ccd.test.design.visitor;

/**
 * Created by ccd on 2017/12/13.
 */
public interface Subject {
    public void accept(Visitor visitor);

    public String getSubject();
}
