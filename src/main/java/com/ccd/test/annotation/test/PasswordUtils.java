package com.ccd.test.annotation.test;

/**
 * Created by ccd on 2018/1/14.
 */
public class PasswordUtils {
    @UseCase(id = 47, description = "Passwords must contain at least one numeric")
     public boolean validatePassword(String password) {
        System.out.println("111111"+"password"+password);
                  return (password.matches("\\w*\\d\\w*"));
     }

     @UseCase(id = 48)
     public String encryptPassword(String password) {
         System.out.println(222+password);
          return new StringBuilder(password).reverse().toString();
     }
}
