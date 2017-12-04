package com.ccd.test.design.Singleton;


import org.junit.Test;
import junit.framework.Assert;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by ccd on 2017/12/4.
 */
public class SerSingletonTest {
    @Test
    public void test() throws Exception{
        SerSingleton s1 = null;
        SerSingleton s = SerSingleton.getInstance();

        FileOutputStream fos = new FileOutputStream("a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("a.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (SerSingleton) ois.readObject();

        System.out.println(s);
        System.out.println(s1);
       // Assert.assertEquals(s,s1);

        Class onwClass = Class.forName("com.ccd.test.design.Singleton.SerSingleton");
        Object o = onwClass.newInstance();
        System.out.println(o);

    }
}
