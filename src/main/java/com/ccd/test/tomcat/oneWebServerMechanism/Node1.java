package com.ccd.test.tomcat.oneWebServerMechanism;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by ccd on 2018/1/29.
 */
public class Node1 {
    private static int port = 8000;
    private static byte adress[] = new byte[]{(byte)228,0,0,4};
    public static void  main(String args[]){
        try {
            InetAddress group = InetAddress.getByAddress(adress);
            MulticastSocket mss = null;
            mss = new MulticastSocket(port);
            mss.joinGroup(group);
            while (true){
                String message = "Hello from nodel";
                byte[] buffer = message.getBytes();
                DatagramPacket dp = new DatagramPacket(buffer,buffer.length,group,port);
                mss.send(dp);

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
