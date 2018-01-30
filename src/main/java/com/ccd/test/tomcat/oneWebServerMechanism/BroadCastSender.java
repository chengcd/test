package com.ccd.test.tomcat.oneWebServerMechanism;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by ccd on 2018/1/29.
 */
public class BroadCastSender {

    public static void main(String args[]){
        try {
            InetAddress ip = InetAddress.getByAddress(new byte[]{(byte)10,(byte)1,17,(byte)255});
            DatagramSocket ds = new DatagramSocket();
            String str = "hello111111111111111";
            DatagramPacket dp = new DatagramPacket(str.getBytes(),str.getBytes().length,
                    ip,8888);
            ds.send(dp);
            ds.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
