package com.ccd.test.testparentSon;

/**
 * Created by ccd on 2017/12/13.
 */
public class Cat extends Animal{
    public Cat(){
        super();                     //---------------可以省略
        System.out.println("我是子类无参数构造器");
    }

    public Cat(String color,int foot){
        //super(color,foot);         //---------------(3)
       // super();                     //---------------可以省略
        System.out.println("我是子类有参数构造器");
    }
}
