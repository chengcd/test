package com.ccd.test.design.Adapter.inner;

/**
 * Created by ccd on 2017/12/6.
 * 接口适配器模式
 *
 * 第三种适配器模式是 接口适配器模式，接口的适配器是这样的：有时候我们写的一个接口中有很多抽象方法，当我们写该接口的实现类
 * 时，必须实现该接口的所有方法，这明显有时比较浪费，因为并不是所有的方法都是我们需要的，有时只需要某一些，为此为了解决这个
 * 问题，我们引入了接口的适配器模式，借助于一个抽象类，该抽象类实现了该接口，实现了所有的方法，而我们不和原始接口打交道，只和该抽象
 * 类取得联系，所以我们写了一个类，继承该抽象类，重新我们需要的方法就行了，看一下类图：
 *                           Sourceable
 *                           [method1(),method2()]
 *
 *
 *                           Warpper         -----------------WrapperTest
 *                         [method1(),method2()]
 *
 *             SourceSub1                SourceSub2
 *             [method1()]               [method2()]
 *这个很好理解，在实际开发中，我们也常会遇到这种接口中定义了太多的方法，以至于有时我们在一些类中
 * 并不是都需要，看代码
 *
 */
public class test {
    public static void main(String[] args) {
        Sourceable source2 = new SourceSub2();
        Sourceable source1 = new SourceSub1();

        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }

//    首先放上源文件
//    父类  Animal.java
//package com.imooc;
//
//    public class Animal {
//        public void eat(){            //注意这个eat方法
//            System.out.println("动物具有吃的能力");
//        }
//    }
//    子类  Dog.java
//package com.imooc;
//
//    public class Dog extends Animal {
//        public void eat(){           //重写父类的eat方法
//            System.out.println("狗是吃肉的");
//        }
//        public void watchDoor(){    //子类中独有的方法，思考如何调用它呢？
//            System.out.println("狗具有看门的能力");
//        }
//    }
//    子类  Cat.java   // 直接继承父类文件，没有任何修改代码的操作
//package com.imooc;
//
//    public class Cat extends Animal {
//
//    }
//    主函数  Initial.java
//
//    public class Initial {
//
//        public static void main(String[] args) {
//            // TODO Auto-generated method stub
//            Animal animal1 = new Animal();//animal1  /2/3都是引用，引用指向的是本类或者子类对象
//            Animal animal2 = new Dog();//父类的引用是可以指向子类的对象的
//            Animal animal3 = new Cat();
//            animal1.eat();      //animal1是创建的父类本身的对象，所以其执行的是父类下的eat方法
//            animal2.eat();      //animal2是创建的子类的对象，所以其执行的是Dog类下重写的eat方法
//            animal3.eat();      //animal3是创建的子类的对象，所以其执行的是Cat类下的继承于Animal的eat方法
//            //animal2.watchDoor();    这个代码是错误的，父类的引用不能直接调用子类的方法
//            Dog dog = (Dog)animal2;  //将父类引用强制转换成子类，功能变强大了
//            dog.watchDoor();   // 可以执行子类独有的方法
//        }
//    }
//    运行结果：
//    动物具有吃的能力
//            狗是吃肉的
//    动物具有吃的能力
//            狗具有看门的能力
}
