package com.ccd.test.design.strategy;

/**
 * Created by ccd on 2017/12/12.
 *
 * 先来张图，看看这11中模式的关系
 * 第一类：通过分类与子类的关系进行实现，第二类：两个类之间。第三类：类的状态。第四类：通过中间类
 *
 * 第一类 父类与子类      第二类 两个 类之间      第三类 类的状态   第四类
 * 策略模式               观察者模式            备忘录模式       访问这模式
 * 模板方法模式           迭代子模式              状态模式       中介这模式
 *                      责任链模式
 *                      命令模式
 *
 *
 *13 策略模式（strategy）
 * 策略模式定义了一系列算法，并将每个算法封装起来，使它们可以互相替换，且算法的变化不会影响到使用算法的客户
 * 。需要设计一个接口，为一系列实现类提供统一的方法，多个实现类实现该接口，设计一个抽象类（可有可无，属于辅助类）
 * 提供辅助函数，关系图如下：
 *
 *
 * test   ICalculator             AbstractCalculator
 *         (calculate())           spilt()
 *
 *
 *         Plus              Minus           Multiply
 *       calculate()        calculate()       calculate()
 *
 * 图中ICalculator提供统一的方法
 *       AbstractCalculator是辅助类，提供辅助方法，接下来，依次实现下每个类：
 *
 * 策略模式的决定权在用户，系统本身体统不同算法的实现，新增或者删除算法，对各种算法做封装。
 * 因此，策略模式多用在算法决策系统中，外部用户只决定用那个算法即可。
 */
public class StrategyTest {
    public static void main(String[] args) {
        String exp = "2+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);
    }
}
