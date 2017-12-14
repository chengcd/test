package com.ccd.test.testparentSon;

/**
 * Created by ccd on 2017/12/13.
 */
public class Animal {
    private String color;
    private int foot;

    public Animal(){
        System.out.println("我是父类无参数构造器");
    }

    public Animal(String color,int foot){
        System.out.println("我是父类有参数构造器");
        this.color = color;
        this.foot  = foot;
    }
}
