package com.ccd.test.tomcat.oneWebServerMechanism;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ccd on 2018/1/29.
 */
public class SocketServer {
    public static void main(String args[]){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8056);
            Socket socket = serverSocket.accept();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            System.out.println("服务器接收到客户端的连接请求："+dis.readUTF());
            dos.writeUTF("接受连接请求，连接成功");
            socket.close();
            serverSocket.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
