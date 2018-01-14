package com.ccd.test.genericity;



/**
 * Created by Wangmx on 2018/1/11.
 */
public class Test {
    private  static void take(Demo<?> a){
        a.print();
    }

    public static void main(String[] args) {
        Demo<Dog> dog = new Demo<Dog>(new Dog());
        take(dog);

        Demo<Cat> cat = new Demo<Cat>(new Cat());
        take(cat);

        Demo<Animal> animal = new Demo<Animal>(new Animal());
        take(animal);
    }
}
