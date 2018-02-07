package com.ccd.test.tomcat.oneWebServerMechanism.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by ccd on 2018/1/30.
 * 4、实现客户端

 客户端套接字使用Socket类，

 （1）客户端开始界面，Start类

 在开始界面中，添加服务器IP和端口号的文本输入框，客户端启动按钮。
 然后给按钮加监听器ClientListener，监听器中建立“服务器-客户端”连接，并跳出登陆界面
 *
 */
public class Start {
    /**
     * @Title: main
     * @param args
     * @return void
     * @Description: TODO
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Start s=new Start();
        s.ini();
    }
    public void ini(){
        JFrame jf=new JFrame();
        JPanel jp=new JPanel();
        JTextField textIP=new JTextField();
        JTextField textPort=new JTextField();
        textIP.setText("localhost");
        textPort.setText("9091");
        JButton btn=new JButton("连接");
        JLabel ipJLA=new JLabel("IP:");
        JLabel portJLA=new JLabel("PORT:");

        btn.setPreferredSize(new Dimension(50,30));

        jf.setSize(new Dimension(500,300));

        BorderLayout bla=new BorderLayout();
        jf.setLayout(bla);
        jp.setBackground(Color.white);
        jp.setLayout(null);

        jp.add(ipJLA);
        jp.add(portJLA);
        jp.add(textIP);
        jp.add(textPort);
        jp.add(btn);

        ipJLA.setBounds(50, 30, 50, 30);
        portJLA.setBounds(30, 65, 50, 30);
        textIP.setBounds(65,30 , 300, 30);
        textPort.setBounds(65,65 , 300, 30);
        btn.setBounds(100,100,100,30);

        ActionListener act=new ClientListener(textIP,textPort);
        btn.addActionListener(act);

        jf.add(jp);
        jf.setVisible(true);
    }
}
