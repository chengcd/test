package com.ccd.test.design.Bridge;

/**
 * Created by ccd on 2017/12/6.
 * 桥接模式 （Bridge）
 * 桥接模式就是把实物和其其他实现分开，使他们可以各自独立变化。桥接的用意是：将抽象化与实现化解耦，使得二者可以
 * 独立变化，像我们常用的JDBC和DriverManger一样，JDBC进行连接数据库的时候，在各个数据库之间进行切换，基本不
 * 需要动太多的代码，甚至丝毫不用动，原因就是JDBC提供统一接口，每个数据库提供各自的实现，用一个叫做数据库驱动的
 * 程序来桥接就行了，我们来看下关系图
 *
 * Client          Bridge                    Sourceable
 *             [Sourceable source            method()
 *              method()]
 *
 *               MyBridge             SourceSub1        SourceSub2
 *               [method()]              method()         method()
 *
 */
public class BridgeTest {
    public static void main(String[] args) {
        Bridge bridge = new MyBridge();
        /*****调用第一个对象*****/
        Sourceable source1 = new SourceSub1();
        bridge.setSource(source1);
        bridge.method();

        /******调用第二个对象*********/
        Sourceable source2 = new SourceSub2();
        bridge.setSource(source2);
        bridge.method();

        /**
         *这样，就通过对Bridge类的调用，实现对接口Sourceable的实现类SourceSub1和SourceSub2的调用，接下来我在
         * 画个图，大家就应该明白了，因为这个图是我们JDBC连接的原理，有数据库基础的，一结合就都能懂了。
         *
         * Client----->DriverManager---------------->Driver
         *
         *                             mysqlDriver  OracleDriver  DB2Driver
         *
         */
    }
}
