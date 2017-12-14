package com.ccd.test.design.visitor;

/**
 * Created by ccd on 2017/12/13.
 */
public class MyVisitor implements  Visitor {
    @Override
    public void visit(Subject sub) {
        System.out.println("visit the subject:"+sub.getSubject());
    }
}
