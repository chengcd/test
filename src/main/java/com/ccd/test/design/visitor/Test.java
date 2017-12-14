package com.ccd.test.design.visitor;

/**
 * Created by ccd on 2017/12/13.
 * 访问这模式(Visitor)
 * 访问这模式把数据结构和作用于结构上的操作解耦合，使得操作集合可相对稳定算法又易变化的系统。因为
 * 访问者使得算法操作增加变得容易。
 *
 * 若系统数据结构对象易于变化，经常有新的数据对象增加进来，则不适合使用访问这模式。访问者模式的优点
 * 是增加操作很容易，因为增加操作意味着增加新的访问者。访问者模式将有关行为集中到一个访问这对象中
 * 其变化不影响系统数据结构。其缺点就是增加新的数据结构很困难----From 百科
 *
 * 简单来说，访问这模式就是一种分离对象数据结构与行为的方法，通过这种分离，可达到为一个被访问这动态
 * 添加新的操作而无需做其他的修改的效果。简单关系图：
 *
 * Test   ----------------->() -------------------->()
 *                       Subject                   Visitor
 *                      [accept()                   visit()
 *                      getSubject()]
 *
 *                       MySubject                 MyVisit
 *                      [accept()                  [visit()]
 *                       getSubject()]
 *来看看源码：一个Visitor类，存放要访问的对象
 *
 * 该模式适用场景：如果我们想为一个现有的类增加新功能，不得不考虑几件事情：
 * 1、新功能会不会与现有功能出现兼容性问题？
 * 2、以后会不会再需要添加？
 * 3、如果类不允许修改代码怎么办？
 * 面对这些问题，最好的方法就是使用访问这模式，访问这模式适用于数据结构相对稳定的
 * 系统，把数据结构和算法解耦
 **/
public class Test{

    public static void main(String[] args) {
        Visitor visitor = new MyVisitor();
        Subject sub = new MySubject();
        sub.accept(visitor);
    }

}