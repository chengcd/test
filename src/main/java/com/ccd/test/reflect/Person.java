package com.ccd.test.reflect;

/**
 * Created by ccd on 2018/1/14.
 */
public class Person {
    private String name;
    private int age;

    public Person(String luoxn28, int i) {
        this.name = luoxn28;
        this.age = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        return this.age == ((Person)obj).getAge();
    }
}
