package com.ccd.test.design.Singleton;

import java.io.Serializable;

/**
 * Created by ccd on 2017/12/4.
 */
public class Singleton  implements Serializable {
    // 单例模式（singleton） 是一种常见的设计模式。在java应用中，单例对应能够保证一个JVM中
    //该对应只有一个实例存在。这样的模式有几个好处
    //1 类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
    //2 省去了new操作符，降低了系统内存的使用频率，减轻GC压力
    //3 有些类如交易所的核心交易引擎，控制着交易流程，如果该该类可以创建多个的话，系统完全乱了。（比如一个军队中出现了多个
    // 司令员，肯定会乱成一团），所以只有使用单例模式，才能保证和兴交易服务器独立控制整个流程。

    private static Singleton instance = null;
    // 私有构造方法，防止被实例化
    private Singleton(){}

    //111
   /* public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return  instance;
    }*/

// 2222似乎解决了之前提到的问题，将synchronized关键字加在了内部，也就是说当调用的时候是不需要加锁的，只有在instance为null，并创建对象的时候才需要加锁，性能有一定的提升。但是，这样的情况，还是有可能有问题的，看下面的情况：在Java指令中创建对象和赋值操作是分开进行的，也就是说instance = new Singleton();语句是分两步执行的。但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM会为新的Singleton实例分配空间，然后直接赋值给instance成员，然后再去初始化这个Singleton实例。这样就可能出错了，我们以A、B两个线程为例：
//
//    a>A、B线程同时进入了第一个if判断
//
//    b>A首先进入synchronized块，由于instance为null，所以它执行instance = new Singleton();
//
//    c>由于JVM内部的优化机制，JVM先画出了一些分配给Singleton实例的空白内存，并赋值给instance成员（注意此时JVM没有开始初始化这个实例），然后A离开了synchronized块。
//
//    d>B进入synchronized块，由于instance此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序。
//
//    e>此时B线程打算使用Singleton实例，却发现它没有被初始化，于是错误发生了。
//
//    所以程序还是有可能发生错误，其实程序在运行过程是很复杂的，从这点我们就可以看出，尤其是在写多线程环境下的程序更有难度，有挑战性。我们对该程序做进一步优化：
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (instance) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    //实际情况是，单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载
    // 的时候，这个类的加载过程是线程互斥的。这样当我们第一次调用getInstance的时候，
    // JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕，
    // 这样我们就不用担心上面的问题。同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。
    // 这样我们暂时总结一个完美的单例模式：
    private static class SingletonFactory{
        private static Singleton instance = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonFactory.instance;
    }

    public Object readResolve() {
        return instance;
    }

}
