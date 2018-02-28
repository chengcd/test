package com.ccd.test.bigcout;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.math.BigInteger;

/**
 * Created by ccd on 2018/2/23.
 *
 *  在用C或者C++处理大数时感觉非常麻烦，但是在JAVA中有两个类BigInteger和BigDecimal分别表示大整数类和大浮点数类，至于两个类的对象能表示最大范围不清楚，理论上能够表示无线大的数，只要计算机内存足够大。
 这两个类都在java.math.*包中，因此每次必须在开头处引用该包。

 基本函数：
 1.valueOf(parament); 将参数转换为制定的类型
 比如 int a=3;
 BigInteger b=BigInteger.valueOf(a);
 则b=3;
 String s=”12345”;
 BigInteger c=BigInteger.valueOf(s);
 则c=12345；

 2.add(); 大整数相加
 BigInteger a=new BigInteger(“23”);
 BigInteger b=new BigInteger(“34”);
 a.      add(b);

 3.subtract(); 相减
 4.multiply(); 相乘
 5.divide();    相除取整
 6.remainder();取余
 7.pow();   a.pow(b)=a^b
 8.gcd();   最大公约数
 9.abs(); 绝对值
 10.negate();取反数
 11.mod(); a.mod(b)=a%b=a.remainder(b);
 12.max(); min();
 13.punlic int comareTo();
 14.boolean equals(); 是否相等
 15.BigInteger构造函数：
 一般用到以下两种：
 BigInteger(String val);
 将指定字符串转换为十进制表示形式；
 BigInteger(String val,int radix);
 将指定基数的BigInteger的字符串表示形式转换为BigInteger
 Ⅱ.基本常量：
 A=BigInteger.ONE    1
 B=BigInteger.TEN    10
 C=BigInteger.ZERO   0
 Ⅲ.基本操作
 1.   读入：
 用Scanner类定义对象进行控制台读入,Scanner类在java.util.*包中
 Scanner cin=new Scanner(System.in);// 读入
 while(cin.hasNext())   //等同于!=EOF
 {
 int n;
 BigInteger m;
 n=cin.nextInt(); //读入一个int;
 m=cin.BigInteger();//读入一个BigInteger;
 System.out.print(m.toString());
 }
 Ⅳ.运用
 四则预算：
 import java.util.Scanner;
 import java.math.*;
 import java.text.*;
 public class Main
 {
 public static void main(String args[])
 {
 Scanner cin = new Scanner ( System.in );
 BigInteger a,b;
 int c;
 char op;
 String s;

 while( cin.hasNext() )
 {
 a = cin.nextBigInteger();
 s = cin.next();
 op = s.charAt(0);
 if( op == '+')
 {
 b = cin.nextBigInteger();
 System.out.println(a.add(b));
 }
 else if( op == '-')
 {
 b = cin.nextBigInteger();
 System.out.println(a.subtract(b));
 }
 else if( op == '*')
 {
 b = cin.nextBigInteger();
 System.out.println(a.multiply(b));
 }
 else
 {
 BigDecimal a1,b1,eps;
 String s1,s2,temp;
 s1 = a.toString();
 a1 = new BigDecimal(s1);
 b = cin.nextBigInteger();
 s2 = b.toString();
 b1 = new BigDecimal(s2);
 c = cin.nextInt();
 eps = a1.divide(b1,c,4);
 //System.out.println(a + " " + b + " " + c);
 //System.out.println(a1.doubleValue() + " " + b1.doubleValue() + " " + c);
 System.out.print( a.divide(b) + " " + a.mod(b) + " ");
 if( c != 0)
 {
 temp = "0.";
 for(int i = 0; i < c; i ++) temp += "0";
 DecimalFormat gd = new DecimalFormat(temp);
 System.out.println(gd.format(eps));
 }
 else System.out.println(eps);
 }
 }
 }
 }

 *
 */
public class Bigcount {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Short.MAX_VALUE);
        BigInteger a=new BigInteger("20");
        BigInteger b=new BigInteger("30");
        System.out.println(a.max(b));


        System.out.println(8e-2);
        double ck = 1.0/10;
        double kk = 0.1/1;
        float kkk = 0.1f;

        System.out.println(ck);
        char kkk1 = '}';
        char kkk11 = '\'';
        System.out.println((char)kkk11);

        System.out.println('嘟'+'\'');
        System.out.println(((char)kkk1)+100);
        boolean bdd = false;
        System.out.println(bdd=true);

        int p = 111100;
        char j = (char)p;
        short c = (short)p;
        System.out.println(j);
        char fkk = 'ﾜ';
        System.out.println(fkk+1);
        System.out.println(256*256);
        System.out.println(c);

        int money =1000000000;
        int year =200;
        int total = money*year; //返回的是负数
        System.out.println(total);

    }
}
