package com.ccd.test.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ccd on 2018/1/14.
 */
public class TestMain {
    public static void main(String[] args) throws ClassNotFoundException, IntrospectionException, InvocationTargetException, IllegalAccessException {
       // System.out.println(XYZ.name);

        // 不会初始化静态块
     ///   Class clazz1 = Base.class;
    ///    System.out.println("------");
        // 会初始化
     ///   Class clazz2 = Class.forName("com.ccd.test.reflect.Base");

       /* Base base = new Derived();
        if (base instanceof Derived) {
            // 这里可以向下转换了
            System.out.println("ok");
        }
        else {
            System.out.println("not ok");
        }*/

        Person person = new Person("luoxn28", 23);
        Class clazz = person.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String key = field.getName();
            PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
            Method method = descriptor.getReadMethod();
            Object value = method.invoke(person);

            System.out.println(key + ":" + value);

        }

    }
}
