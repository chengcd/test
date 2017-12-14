package com.ccd.test.design.strategy;

/**
 * Created by ccd on 2017/12/12.
 */
public class Multiply extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\");
        return arrayInt[0]*arrayInt[1];
    }
}
