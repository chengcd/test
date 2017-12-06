package com.ccd.test.design.Adapter;

/**
 * Created by ccd on 2017/12/6.
 *
 * 对象适配器模式
 * 基本思路和类的适配器模式相同，只是将Adapter类做修改，这次不继承Source类，而是持有Source类的实例，
 * 以达到解决兼容性的问题，看图
 *
 * Source
 * [method1()]                                                                 AdapterTest
 *                                         Targetable
 *                                          [method1(),method2()]
 *
 *
 *        Warapper
 *        [Source
 *        method1(),method2]
 */
public class Warpper implements Targetable {

    private Source source;

    public Warpper(Source source){
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method ");
    }
}
