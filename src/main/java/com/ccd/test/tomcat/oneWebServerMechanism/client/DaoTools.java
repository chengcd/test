package com.ccd.test.tomcat.oneWebServerMechanism.client;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ccd on 2018/1/30.
 */
public class DaoTools {
    public static boolean checkUser(UserInfo user){
        if(userDB.containsKey(user.getName())){
            UserInfo user0=userDB.get(user.getName());
            if(user0.getPsw().equals(user.getPsw()))
                return true;
        }
        System.out.println("用户名或密码错误"+user.getName());
        return false;
    }
    //  public static boolean checkPsw(UserInfo user){
//
//  }
    private static Map<String,UserInfo> userDB=new HashMap();

    static {
        for (int i=0; i<10;i++){
            UserInfo user=new UserInfo();
            user.setName("user"+i);
            user.setPsw("user"+i);
            userDB.put(user.getName(),user);
        }
    }
}
