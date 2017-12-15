package com.ccd.test.design.Interpreter;

/**
 * Created by Wangmx on 2017/12/15.
 * 解释器模式（Interpreter）
 * 解释器模式是我们暂时的最后一讲，一般主要应用在OOP开发中编译器的开发中，所以适用免比较窄
 *
 *  Test   ---------------->()-----------------> Context
 *                                              [private int num1
 *                   Exprission                ,private int num2 ]
 *                 int interpret()                            [public Context()
 *                                              int getnum1()
 *                                              int getnum2]
 *
 *            plus                Minus
 *        int interpret       int iterpret()
 *  Context类是一个上下文环境类，plus和mins分别是用来计算的实现，代码如下：
 */
public class Test {
    public static void main(String[] args) {
        int result = new Minus().interpret((new Context(
                new Plus().interpret(new Context(9,2))
                        ,8)));
        System.out.println(result);
    }
}
