package com.ccd.test.design.Interpreter;

/**
 * Created by Wangmx on 2017/12/15.
 */
public class Plus implements Expression {
    @Override
    public int interpret(Context context) {
        return context.getNum1() +context.getNum2();
    }
}
