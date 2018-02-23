package com.ccd.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by ccd on 2018/2/22.
 */
public class teststudent {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        //第一种方式获取Class对象
//        Student stu1 = new Student();//这一new 产生一个Student对象，一个Class对象。
//        Class stuClass = stu1.getClass();//获取Class对象
//        System.out.println(stuClass.getName());
//
//        //第二种方式获取Class对象
//        Class stuClass2 = Student.class;
//        System.out.println(stuClass == stuClass2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个
//
//        //第三种方式获取Class对象
//        try {
//            Class stuClass3 = Class.forName("com.ccd.test.reflect.Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
//            System.out.println(stuClass3 == stuClass2);//判断三种方式是否获取的是同一个Class对象
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }



        //1.加载Class对象
        Class clazz = Class.forName("com.ccd.test.reflect.Student");

       Student cck =  (Student)clazz.getConstructor().newInstance();
        System.out.println(cck);

        //2.获取所有公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] conArray = clazz.getConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }


        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        conArray = clazz.getDeclaredConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }

        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor con = clazz.getConstructor(null);
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。

        System.out.println("con = " + con);
        //调用构造方法
        Object obj = con.newInstance();
        //  System.out.println("obj = " + obj);
        //  Student stu = (Student)obj;

        System.out.println("******************获取私有构造方法，并调用*******************************");
        con = clazz.getDeclaredConstructor(char.class);
        System.out.println(con);
        //调用构造方法
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
        obj = con.newInstance('男');
    }
}
