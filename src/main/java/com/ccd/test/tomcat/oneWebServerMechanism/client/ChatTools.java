package com.ccd.test.tomcat.oneWebServerMechanism.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccd on 2018/1/30.
 */
public class ChatTools {
    private ChatTools(){};
    //保存线程处理的队列对象
    private static List<ProcessClientThread> clientList=new ArrayList<>();

    public static void addClient(ProcessClientThread pct){
        clientList.add(pct);
    }
    public static void removeClient(ProcessClientThread pct){
        clientList.remove(pct);
    }
    public static void castMsg(UserInfo sender,String msg){
        String name=sender.getName()+":";
        for(int i=0;i<clientList.size();i++){
            ProcessClientThread client=clientList.get(i);
            client.sendMsg2Me(name);
        }
        for(int i=0;i<clientList.size();i++){
            msg="  "+msg;
            ProcessClientThread client=clientList.get(i);
            client.sendMsg2Me(msg);
        }
    }
    public static void castMsg(String msg){
        for(int i=0;i<clientList.size();i++){
            ProcessClientThread client=clientList.get(i);
            client.sendMsg2Me(msg);
        }
    }
    public static void loginMsg(String userName){
        castMsg(userName+"上线了,当前人数为"+clientList.size());
    }
    public static void logoffMsg(String userName){
        castMsg(userName+"下线了,当前人数为"+clientList.size());
    }
}
