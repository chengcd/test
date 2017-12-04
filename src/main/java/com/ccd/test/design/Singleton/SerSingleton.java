package com.ccd.test.design.Singleton;

import java.io.Serializable;

/**
 * Created by ccd on 2017/12/4.
 */
public class SerSingleton implements Serializable {
    String name;
    //发射需要 构造方法为public
    private SerSingleton(){
        System.out.println("Singleton is creating");
    }

    private static SerSingleton instance = new SerSingleton();

    public static SerSingleton getInstance(){
        return instance;
    }

    public static void createString(){
        System.out.println("create string in singleton");
    }

    private Object readResolve(){
        System.out.println("read resolve");
        return instance;
    }
}
