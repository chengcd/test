package com.ccd.test.RSA;

/**
 * Created by ccd on 2018/1/28.
 *
 * 所以，你公开了私钥的话，相当于把公钥也告诉他们了
 公钥就是通过私钥生成的



 选取两个大质数p，q,计算 n=p\times q
 任意选择一正整数e_{1} ,使得e_{1} 与(p-1)(q-1)互质。
 根据(e_{1} \times e_{2}) mod [(p-1)(q-1)] =1计算e_{2}的值。
 公钥Public Key = (e_{1}, n)
 私钥PrivateKey = (e_{2}, n)
 加密过程 （C为密文，P为明文）：
 C=P^{e_{1}}\ mod\ n
 解密过程
 P=C^{e_{2}}\ mod \ n


 *
 *
 */
public class Exercise {
    public static void main(String[] args)
    {
        int[] p = new int[2];
        int a = 47;
        int b = 30;
        RSA(a,b,p);
        System.out.print("p[0] is: " + p[0] + ";p[1] is：" + p[1]);//p1为私钥
    }
    public static  int[] RSA(int a,int b,int[] p)//这里假设a > b
    {
        if(a%b == 1)
        {
            p[0] = 1;
            p[1] = -(a - 1) / b;
            return p;
        }
        else
        {
            RSA(b,a % b,p);
            int t = p[0];
            p[0] = p[1];
            p[1] = t - (a / b) * p[1];
            return p;
        }
    }
}
