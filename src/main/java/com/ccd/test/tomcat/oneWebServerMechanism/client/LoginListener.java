package com.ccd.test.tomcat.oneWebServerMechanism.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by ccd on 2018/1/30.
 */
public class LoginListener implements ActionListener {
    private JTextField jtx1;
    private JTextField jtx2;
    private OutputStream os;
    private InputStream is;
    private ClientListener cl;
    public LoginListener(JTextField jtx1,JTextField jtx2,OutputStream os,InputStream is,ClientListener cl){
        this.jtx1=jtx1;
        this.jtx2=jtx2;
        this.os=os;
        this.is=is;
        this.cl=cl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
            os.write((jtx1.getText()).getBytes());
            System.out.println("jtx1="+jtx1.getText());
            os.flush();
            os.write(jtx2.getText().getBytes());
            System.out.println("jtx1="+jtx2.getText());
            os.flush();
            int flag=-1;
            System.out.println("flag="+flag);
            try {

                flag = is.read();
                System.out.println("读了");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if(flag==1){
                cl.chatFrame();

            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
}
