package com.ccd.test.tomcat.oneWebServerMechanism.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by ccd on 2018/1/30.
 *
 *  我们每天都在上网，聊QQ、聊微信、看视频、看新闻.....
 *  .基本每个网络应用都是基于客户端-服务器模型的，在这个模型下，
 *  一个应用就是一个服务器进程和多个客户端进程组成。
 *  服务器进程启动之后，就开始等待客户端连接，当服务器与客户端建立连接后，
 *  服务器又等待客户端发出服务请求，客户端通过这个连接向服务器发送服务请求，
 *  最后服务器利用其现有资源满足客户端的请求并发给客户一个响应，然后等待下一个请求，
 *  从客户端向服务器发出请求到服务器处理请求这一系列的过程称为一个事务。


 值得注意的是，服务器和客户端应该理解为进程（而不是机器），一台机器可以有多个服务器或客户端，
 一般客户端与服务器在不同的机器上，但也可以在同一台机器上。
 *
 * 2、套接字

 客户端和服务器之间要进行通信首先要建立连接，然后才能在这个连接上收发字节流。

 套接字就是连接的一个端点，每个套接字都有一个套接字地址，由32位整数IP地址和16位整数端口号组成，
 用“IP地址：端口号”表示。这就好比要在宿舍楼找到一个人，不仅要知道他的楼栋号（IP），还要知道房间号（端口）。

 一个连接由两端的套接字地址唯一确定，称为套接字对。

 （client address: client port, server address: server port）

 其中客户端的端口是临时分配的端口，服务器的端口是固定的知名端口。

 Java中的服务器套接字是ServerSocket，客户端套接字是socket。两者建立连接后，
 就能通过输入输出流进行通信了（服务器的输入流对应客户端的输出流，服务器的输出流对应客户端的输入流）
 *
 */
public class Server {
    public static void main(String[] args) {
        Server serv = new Server();
        serv.init();
    }

    /**
     * @Title: ini
     * @Description: 服务器界面，在上面输入端口号则建立
     * 一个服务器线程（利用线程可以同时创建多个端口的服务器）
     */
    private void init() {
        int port;
        JFrame jf=new JFrame();
        jf.setSize(new Dimension(500,500));
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);

        BorderLayout bo=new BorderLayout();
        jf.setLayout(bo);
        JPanel jpa=new JPanel();
        jpa.setBackground(Color.white);

        JTextField jtfPort=new JTextField();
        jtfPort.setPreferredSize(new Dimension(100,20));

        JButton jbuCreat=new JButton();
        jbuCreat.setPreferredSize(new Dimension(50,20));

        ActionListener cbl=new CreatBtnListener(jtfPort);
        jbuCreat.addActionListener(cbl);

        jpa.add(jtfPort);
        jpa.add(jbuCreat);
        jf.add(jpa,BorderLayout.CENTER);
        jf.setVisible(true);
    }


}
