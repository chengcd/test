package com.ccd.test.scanner;

import java.util.Scanner;

/**
 * Created by ccd on 2018/2/27.
 */
public class TestScanner
{

    public static void testo1(){
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println("刚才str输入的字符串"+str);
    }

    public static int testo2(){
        Scanner s = new Scanner(System.in);
        System.out.println("刚才str输入的字符串int");
        int str = s.nextInt();
        System.out.println("刚才str输入的字符串"+str);

        int ttt = s.nextInt();
        System.out.println(ttt+str);
        return str+ttt;
    }
    /**1
    **@Author:ccd
    **@date: 2018/2/27 20:07
    **@descript:
    **/
    public static void main(String[] args) {
        testo2();
    }
}
