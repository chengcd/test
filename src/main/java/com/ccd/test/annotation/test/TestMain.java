package com.ccd.test.annotation.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ccd on 2018/1/14.
 */
public class TestMain {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        List<Integer> useCases1 = new ArrayList<Integer>();
        Collections.addAll(useCases1, 47, 48, 49, 50);
        trackUseCases(useCases1, PasswordUtils.class);
    }

    public static void trackUseCases(List<Integer> useCases, Class<?> cl) throws InvocationTargetException, IllegalAccessException {
        PasswordUtils p = new PasswordUtils();

        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id() + " "
                        + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
            m.invoke(p,"passdddd11");
        }
        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }

}
