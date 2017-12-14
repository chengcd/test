package com.ccd.test.design.Observer;

/**
 * Created by ccd on 2017/12/12.
 * 观察者模式（Observer）
 * 包括这个模式在内的接下来的四个模式，都是类和类之间的关系，不涉及到继承，学的时候应该记得归纳，记得本文最开始的那个
 * 图。观察这模式很好理解，类似于邮件订阅和RSS订阅，当我们浏览一些博客或wik时，经常会看到RSS图标，就这的意思是，
 * 当你订阅了该文章，如果后学有更新，会及时通知你。其实，简单来讲就是一句话：当一个对象变化时，其他依赖改对象的
 * 对象都会收到通知，并且隋卓变化！对象之间是一种一对多的关系，先来看看关系图：
 *  Test    --------------------> ()----------------------->()
 *                            Subject                        Observer
 *                              add()                        update()
 *                              del()
 *                           notifyObserver()            Observer1   Observer2
 *                                |                        update        update
 *                            AbstractSubject
 *                          Vector<Observer> vector
 *                          add()
 *                          del()
 *                          notifyObserver()
 *                               |
 *                           MySubject
 *
 *  我解释下这些类的作用：MySubject类就是我们的主对象，Observer1和Observer2是依赖于MySubject变化时，Observer1
 *  和Observier2必然变化。AbsetactSubject类中电仪着需要监控的对象列表，可以对其进行修改：增加或删除监控对象，且当
 *  MySubject变化时，负责通知其列表内存在的对象，我们看实现代码：
 *
 * 这些东西，其实不难，只是有些抽象，不太容易理解，建议读者：根据关系图，新建项目，自己写代码（或者参考我的代码）
 * ，按照总体思路走一遍，这样才能体会它的思路，理解起来容易！
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}
