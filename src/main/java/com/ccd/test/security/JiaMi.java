package com.ccd.test.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.security.SecureRandom;

/**
 * Created by ccd on 2017/12/4.
 */
public class JiaMi {
    public static void main(String[] args) throws Exception {

        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 获得密匙数据
        String m = "fsfdfxfsfsdfsdfs";
         //从原始密匙数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(m.getBytes());
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
        SecretKey key = SecretKeyFactory.getInstance("DES").generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, key, sr);


        // 正式执行加密操作
        byte encryptedData[] = cipher.doFinal("12ccd".getBytes());
        // 用加密后的数据覆盖原文件
        System.out.println(new String(encryptedData));


        // 从原始密匙数据创建一个DESKeySpec对象
        DESKeySpec dks1 = new DESKeySpec(m.getBytes());
        // 创建一个密匙工厂，然后用它把DESKeySpec对象转换成一个SecretKey对象
        SecretKey key1 = SecretKeyFactory.getInstance("DES").generateSecret(dks1);
        // Cipher对象实际完成解密操作
        Cipher cipher1 = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher1.init(Cipher.DECRYPT_MODE, key1, sr);
        // 现在，获取数据并解密

        // 正式执行解密操作
        byte decryptedData[] = cipher1.doFinal(encryptedData);
        System.out.println(new String(decryptedData));



    }
}
