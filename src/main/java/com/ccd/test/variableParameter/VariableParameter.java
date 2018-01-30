package com.ccd.test.variableParameter;

/**
 * Created by ccd on 2018/1/29.
 *
 * java 可变参数
 *
 */

public class VariableParameter {

    //求若干个整型数中的最大值
    public int getMax(int... items){       //定义可变参数items

        int max = Integer.MIN_VALUE;       //次数为int能表示的最小值，值为-2147483648
        for(int item : items){
            max = item > max? item : max;    //取大值
        }
        return max;
    }
    //返回比number大的数的个数
    public int getLagerNum(int number,int... items){  //若除了可变长参数还有其它参数，可变长参数一定要放在最后
        int sum = 0;
        for(int item : items){
            if(item > number){
                sum++;
            }
        }
        return sum;
    }


    public void comp(int[] items){      //会报错：Duplicate method comp(int[]) in type VariableParameter
        System.out.println("2");
    }


    public static void main(String[] args) {
        VariableParameter vp = new VariableParameter();
        System.out.println("最大值："+vp.getMax());  //可以不写参数
        System.out.println("最大值："+vp.getMax(2,1,4,7,2,-1,3,3));  //可以在参数中直接写入若干个参数
        System.out.println("最大值："+vp.getMax(-1,4,5,0,1));        //可以在参数中直接写入若干个参数

        System.out.println("比number大的数的个数："+vp.getLagerNum(9, 1,11,5,14,-1,9,21));  //9为number，后边的是items
        int a[] = new int[] {1,11,5,14,-1,9,21};
        System.out.println("比number大的数的个数："+vp.getLagerNum(9,a));     //items也可以用数组替代


        VariableParameter vp1 = new VariableParameter();
        vp.comp(new int[] {1,2,3,4});

    }

}