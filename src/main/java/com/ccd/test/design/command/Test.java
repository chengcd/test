package com.ccd.test.design.command;

/**
 * Created by ccd on 2017/12/13.
 * 命令模式很好理解，举个例子，司令员下令让士兵去干件事情，从整个事情的角度来考虑，司令员的作用是，发出口令，口令
 * 经过传递，传递到士兵耳朵里，士兵去执行。整个过程好在，三者互相解耦，任何一个都不用去依赖其他人，只需要做好自己
 * 的事就行，司令员要的是结果，不会去关系到底士兵是怎么实现的。我们看看关系图：
 *
 * 输出：command received!
 * 这个很好理解，命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分开，熟悉Struts的同学应该知道，
 * Struts其实就是一种将请求和呈现分离的技术，其中必然涉及命令模式的思想！
 *
 * 其实每个设计模式都是很重要的一种思想，看上去很熟，其实是因为我们在学到的东西都涉及到，经过有时候我们并不知道，其实
 * Java本身的设计之中处处都有体现，像AWT、JDBC、集合类、IO管道或者是Web框架，里面设计模式无处不在。因为我们篇幅
 * 有限，很难讲每一个设计模式都讲的很详细，不过我会尽我所能，尽量在有限的空间和篇幅内，把意思写清楚了，更好让大家
 * 明白。本章不出以外的话，应该是设计模式最后一讲了，数艘县还是上一下上篇开头的那个图：
 * 第一类:父类与子类  第二类:两个类之间     第三类 类的状态    第四类 通过中间类
 * (1)策略模式        (3)观察者模式     (7) 备忘录模式       (9) 访问这模式
 *
 * (2)模板方法模式    (4)迭代子模式     (8) 状态模式         (10) 中介者模式
 *
 *                  （5)责任链模式                         (11) 解释器模式
 *
 *                  （6）命令模式
 *
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command cmd = new MyCommand(receiver);
        Invoker invoker = new Invoker(cmd);
        invoker.action();
    }
}
