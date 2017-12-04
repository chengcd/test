package com.ccd.test.design.Prototype;

import java.io.IOException;

/**
 * Created by ccd on 2017/12/4.
 */
public class Test {
    //要实现深复制，需要采用流的形式读入当前对象的二进制输入，再写出二进制数据对应的对象。
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Prototype m = new Prototype();
        m.setString("1212");
        m.setObj1("obj");
        Prototype k= (Prototype) m.clone();
        Prototype km = (Prototype) m.deepClone();
        System.out.println(k);
        System.out.println(km);
        System.out.println(m);
    }
}
