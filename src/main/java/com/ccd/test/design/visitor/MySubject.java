package com.ccd.test.design.visitor;

/**
 * Created by ccd on 2017/12/13.
 */
public class MySubject implements Subject {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "love";
    }
}
