package com.ccd.test.tomcat.oneWebServerMechanism;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by ccd on 2018/1/29.
 * 组播通信中最重要的内容是如何维护路由器与主机之间的关系，其最主要通过IGMP协议进行维护。它主要维护不同路由器
 * 与不同主机之间的成员关系，具体的维护方式比较复杂，因为涉及多个路由器且路由之间相互连接组成一个树状网状，而组内
 * 成员可能处于任何一个路由中，即树的任何叶节点，所以需要复杂的算法去维护这些关系才知道信息往哪里发送。IGMP协议主要
 * 负责组成员的加入和退出、组内成员查询等功能，使用组播通信需要通过IGMP协议申请加入组成员才能接收组播的消息（退出就不能了）
 *
 * 在单播通信模式中服务器端和客户端之分，而组播通信模式与单播通信模式不同，每个段都是理由器或交换器作为中转广播站，
 * 任意一端向路由器或交换机发送消息，路由器或交换机赋值发送给其他节点，每个节点都是等同的。
 *
 *
 */
public class Node2 {

    private static int port = 8000;
    private static byte[] address = new byte[]{(byte)228,0,0,4};

    public static void  main(String args[]) throws Exception{
        InetAddress group = InetAddress.getByAddress(address);
        MulticastSocket msr = null;

        try {
            msr = new MulticastSocket(port);
            msr.joinGroup(group);

            byte[] buffer = new byte[1024];

            while (true){
                DatagramPacket dp = new DatagramPacket(buffer,buffer.length,group,port);
                msr.send(dp);
                String s = new String(dp.getData(),0,dp.getLength());
                System.out.println("receive from nodel"+s);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
