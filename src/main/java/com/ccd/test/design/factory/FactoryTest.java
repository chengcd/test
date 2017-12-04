package com.ccd.test.design.factory;

/**
 * Created by ccd on 2017/12/4.
 */
public class FactoryTest {

    //总体来说，工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。
    // 在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象，第三种相对于第二种，不需要实例化工厂类，
    // 所以，大多数情况下，我们会选用第三种——静态工厂方法模式。
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();


        SendFactory factory1 = new SendFactory();
        Sender sender1 = factory1.produceMail();
        sender1.Send();
    }
}
