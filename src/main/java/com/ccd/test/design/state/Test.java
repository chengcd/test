package com.ccd.test.design.state;

/**
 * Created by ccd on 2017/12/13.
 * 状态模式（State）
 * 核心思想就是：当对象的状态改变时，同事改变其行为，很好理解！就拿QQ来说，有几种状态，在线、隐身、忙碌等
 * ，每个状态对应不同的操作，而且你的好友也能看到你的状态，所以，状态模式就两点：1、可以通过改变状态来获取不同
 * 的行为。 2、你的好友能同事看到你的变化。 看图：
 *
 * Test             Context                 State
 *                                       String value
 *                State state             method1()
 *                  method()              method2()
 * State类是个状态类，Context类可以实现切换，我们来看看代码：
 *
 * 输出：
 * execute the first opt!
 * execute the second opt!
 * 根据这个特征，状态模式在日常开发中用的挺多的，尤其在做网站的时候，我们有时候希望根据对象的
 * 某一个属性，区别开它们的一些功能，比如说简单的权限控制等
 */
public class Test {

    public static void main(String[] args) {
        State state = new State();
        Context context = new Context(state);

        //设置第一种状态
        state.setValue("state1");
        context.method();

        //设置第二种状态
        state.setValue("state2");
        context.method();
    }

}
