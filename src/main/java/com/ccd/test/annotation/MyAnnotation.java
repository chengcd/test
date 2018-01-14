package com.ccd.test.annotation;

import java.lang.annotation.*;

/**
**@Author:ccd
**@date: 2018/1/14 16:16
**@descript:
 *
 @Retention是用来修饰注解的注解，使用这个注解，我们可以做到
 控制注解是否写入class文件
 控制class文件中的注解是否在运行时可见
 * 控制很简单，使用使用以下三种策略之一即可。
 注解将被编译器丢弃  RetentionPolicy.SOURCE 表明注解仅存在源码之中，不存在.class文件，更不能运行时可见。常见的注解为@Override, @SuppressWarnings。
 注解在class文件中可用，但会被VM丢弃  RetentionPolicy.CLASS 这是默认的注解保留策略。这种策略下，注解将存在与.class文件，但是不能被运行时访问。通常这种注解策略用来处于一些字节码级别的操作。
 VM将在运行期也保留注释，因此可以通过反射机制读取注解的信息。 RetentionPolicy.RUNTIME 这种策略下可以被运行时访问到。通常情况下，我们都会结合反射来做一些事情。
 *
 * 使用@Target注解，我们可以设定自定义注解可以修饰哪些java元素。简单示例
 *上述的代码说明MyAnnotation注解只能修饰方法。
 @Target可以选择的参数值有如下这些
 ElementType.ANNOTATION_TYPE（注：修饰注解）
 ElementType.CONSTRUCTOR 构造器声明
 ElementType.FIELD 　 域声明（包括 enum 实例）
 ElementType.LOCAL_VARIABLE 局部变量声明
 ElementType.METHOD
 ElementType.PACKAGE
 ElementType.PARAMETER  参数声明
 ElementType.TYPE（注：任何类型，即上面的的类型都可以修饰）   类，接口（包括注解类型）或enum声明
 *
 * @Inherited
如果你想让一个类和它的子类都包含某个注解，就可以使用@Inherited来修饰这个注解。
 *上述代码的大致意思是
1.使用@Inherited修饰注解MyAnnotation
2.使用MyAnnotation注解MySuperClass
3.实现一个类MySubclass继承自MySuperClass
通过以上几步，MySubClass也拥有了MyAnnotation注解。
关于Java中的注解，一些基本的概念就是这些。
**/
@Retention(RetentionPolicy.RUNTIME) //RetentionPolicy.SOURCE  RetentionPolicy.CLASS
@Target(ElementType.TYPE)
@Inherited
public @interface MyAnnotation {
    String value() default "nihao";
    String name();
    int age();
    String[] newname();
}
