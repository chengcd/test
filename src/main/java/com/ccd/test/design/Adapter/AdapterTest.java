package com.ccd.test.design.Adapter;

/**
 * Created by ccd on 2017/12/6.
 *  类适配器
 *
 */
public class AdapterTest {
    public static void main(String[] args){
        Targetable target = new Adapter();
        target.method1();
        target.method2();
        //这样Targetable 接口的实现类就具有了Source类的功能

        Source source = new Source();
        Targetable target1 = new Warpper(source);
        target1.method1();
        target1.method2();


    }
}
