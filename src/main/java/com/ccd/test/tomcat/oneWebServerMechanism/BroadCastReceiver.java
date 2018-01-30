package com.ccd.test.tomcat.oneWebServerMechanism;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by ccd on 2018/1/29.
 */
public class BroadCastReceiver {
    public static void main(String args[]){
        try {
            DatagramSocket ds = new DatagramSocket(8888);
            byte[] buf = new byte[100];
            DatagramPacket dp = new DatagramPacket(buf,buf.length);
            ds.receive(dp);
            System.out.println(new String(buf));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
