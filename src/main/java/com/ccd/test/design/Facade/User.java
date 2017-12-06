package com.ccd.test.design.Facade;

/**
 * Created by ccd on 2017/12/6.
 * 外观模式（Facade）
 * 外观模式是为了解决类与类之间的依赖关系的，像spring一样，可以将类与类之间的关系配置到配置文件中，而外观模式
 * 就是将他们的关系放到一个Facade类中，降低类类之间的耦合度，改模式中没有涉及到接口，看下类图：
 * （我们以一个计算机的启动过程为例）
             CPU           Memory              Disk
        [startup()       [startup()          [startup()
        \shutdown()]     \shutdown()]        /shutdown()]

                          Computer
                        [startup(),shutdown()]

 *                         User
 *  如果我们没有Computer类，那么CPU,Memory,Disk他们之间将会相互持有实例，产生关系，这样会造成严重的依赖，修改
 *  一个类，可能会带来其他类的修改，这不是我们想要看到的，有了Computer类，他们之间的关系被放在Computer类里，
 *  这里就起到了解耦的作用，这，就是外观模式！
 */
public class User {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.shartup();
        computer.shutdown();
    }



}
