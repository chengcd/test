package com.ccd.test.tomcat.oneWebServerMechanism.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ccd on 2018/1/30.
 */
public class CreatBtnListener implements ActionListener {
    private int port;//
    private JTextField jtf;
    public CreatBtnListener(JTextField jtf){
        this.jtf=jtf;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        port=Integer.parseInt(jtf.getText());
        new ChatServerThread(port).start();
    }
}
