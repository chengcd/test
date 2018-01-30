package com.ccd.test.tomcat.oneWebServerMechanism;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Created by ccd on 2018/1/29.
 *
 *  单播通信，服务器端的8056单开已经处于监听状态，客户端如果要与之通信，只需要简单地先指定服务器IP与端口号以
 *  实例化一个套接字，然后获取套接字的输出流与输入流。输出流用于向服务器发送的数据，输入流用于读取服务器发送过来
 *  的数据。交互处理完成后关闭套接字
 *
 */
public class SocketClient {
    public static void main(String args[]){
            Socket socket  = null;
            try {
                socket = new Socket("localhost",8056);
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                dos.writeUTF("我是客户端，请求连接");
                System.out.println(dis.readUTF());
                socket.close();


            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
