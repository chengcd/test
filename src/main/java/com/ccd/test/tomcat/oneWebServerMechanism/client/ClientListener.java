package com.ccd.test.tomcat.oneWebServerMechanism.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by ccd on 2018/1/30.
 */
public class ClientListener extends Thread implements ActionListener{
    private JTextField ipField;
    private JTextField portField;
    private Socket client;
    private String addr;
    private int port;
    private InputStream is;
    private OutputStream os;
    private JFrame chatF;
    private JTextArea sendArea;
    private JTextArea chatArea;

    public ClientListener(JTextField ipField,JTextField portField){
        this.ipField=ipField;
        this.portField =portField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        addr=ipField.getText();
        port=Integer.parseInt(portField.getText());
        this.connect(addr, port);
        logFrame();
    }
    public void run(){
        String msg;
        while(true){
            msg=receiveMsg();
            displayMsg(msg+"\r\n");
        }
    }
    public void logFrame(){
        JFrame logF=new JFrame();
        logF.setSize(800, 500);
        BorderLayout bo=new BorderLayout();
        logF.setLayout(bo);
        JPanel jpa=new JPanel();

        jpa.setLayout(null);
        jpa.setBackground(Color.black);
        JTextField jtx1=new JTextField();
        JTextField jtx2=new JTextField();
        JButton btn=new JButton();
        jpa.add(btn);
        jpa.add(jtx1);
        jpa.add(jtx2);
        jtx1.setBounds(100,40, 200, 40);
        jtx2.setBounds(100,100, 200, 40);
        btn.setBounds(120, 200, 100, 50);
        btn.addActionListener(new LoginListener(jtx1,jtx2,os,is,this));
//      chatFrame();
        logF.add(jpa);
        logF.setVisible(true);
    }
    public void chatFrame(){

        chatF=new JFrame();
        chatF.setSize(new Dimension(400,600));
        BorderLayout bod=new BorderLayout();
        chatF.setLayout(bod);
        JPanel jpa=new JPanel();

        chatF.add(jpa);
        jpa.setBackground(Color.black);
        sendArea=new JTextArea();
        chatArea=new JTextArea();
        JButton sendBtn=new JButton("发送");
        jpa.setLayout(null);
        jpa.add(chatArea);
        jpa.add(sendArea);

        jpa.add(sendBtn);
        chatArea.setBounds(10, 10, 270, 320);
        sendArea.setBounds(10, 340, 270, 180);
        sendBtn.setBounds(270, 540, 40, 30);

        sendBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    os.write((sendArea.getText()+"\r\n").getBytes());
                    sendArea.setText("");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        chatF.setVisible(true);
        this.start();

    }
    /**
     * @Title: connect
     * @param address 服务器ip
     * @param port 要连接的端口
     * @return void
     * @Description: 连接到服务器
     */
    public void connect(String address,int port){
        try {
            client= new Socket(address,port);
            is=client.getInputStream();
            os=client.getOutputStream();
            System.out.println("连接成功");
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * @Title: sendMsg2
     * @param msg 要发送的消息
     * @Description: 发送消息给服务器
     */
    public void sendMsg2(String msg){
        try {
            os.write(msg.getBytes());
            os.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public String receiveMsg(){
        BufferedReader brd =new BufferedReader(new InputStreamReader(is));
        String msg=null;
        try {
            msg = brd.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return msg;

    }
    /**
     * @Title: displayMsg
     * @Description: 显示
     */
    public void displayMsg(String msg){
        chatArea.append(msg);
    }
}
