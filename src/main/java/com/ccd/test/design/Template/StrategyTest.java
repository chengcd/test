package com.ccd.test.design.Template;

/**
 * Created by ccd on 2017/12/12.
 *
 * 我跟踪下这个小程序的执行过程：首先将exp和"\\+"做参数，调用AbstractCalculator类的calculate(string,string)
 * 方法，在calculate(string,string)里面调用同类的split(),之后再调用calculate(int,int)方法，从这个而方法进入
 * 子类中，执行完return num1+num2后，将值返回到AbstractCalculator类，赋予result,打印出来，正好验证了我们开头
 * 的思路。
 */
public class StrategyTest {
    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator cal = new Plus();
        int result = cal.calculate(exp,"\\+");
        System.out.println(result);
    }
}
