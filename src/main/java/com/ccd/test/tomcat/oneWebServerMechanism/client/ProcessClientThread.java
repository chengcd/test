package com.ccd.test.tomcat.oneWebServerMechanism.client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by ccd on 2018/1/30.
 */
public class ProcessClientThread extends Thread{
    private Socket client;
    private OutputStream os;
    public ProcessClientThread(Socket client){
        this.client=client;
        System.out.println("创建服务器线程");
    }
    public void run(){
        processClient(client);
        System.out.println("服务器线程启动");
        System.out.println("client="+client.getRemoteSocketAddress());
    }
    public void sendMsg2Me(String msg){
        try {
            msg=msg+"\r\n";
            os.write(msg.getBytes());
            os.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void closeMe(){
        try {
            client.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * @Title: readAll
     * @param InputStream is
     * @return String
     * @Description: 直接读字节流，因为BufferedReader的ReadLine()方法以回车换行作为结束符，而登陆界面的用户名、
     * 密码是不含回车换行的,这个方法主要是为了读取客户端界面的JTextField中的账号和密码
     */
    public String readAll(InputStream is){
        try {
            ArrayList al=new ArrayList();
            int i=0;
            do{//这里只能用do-while循环而不能用while，否则读不到任何数据
                i=is.read();
                al.add(i);
            }while(is.available()!=0);
            byte[] b=new byte[al.size()];
            for(int j=0;j<b.length;j++){
                int s=(int)al.get(j);//get返回的是Object类对象
                b[j]=(byte)s;
            }
            return new String(b);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public void processClient(Socket client){
//      System.out.println("客户机"+client.getRemoteSocketAddress()+"已连接上");
        //获取客户机的输入输出流，这里文件对象看成客户机的Socket
        try {
            os = client.getOutputStream();//输出到客户机的输出流
            InputStream is=client.getInputStream();//从客户机输入的输入流
            BufferedReader brd=new BufferedReader(new InputStreamReader(is));
            System.out.println(brd);
            String userName=readAll(is);
            String psw =readAll(is);

            UserInfo user=new UserInfo();
            user.setName(userName);
            user.setPsw(psw);

            System.out.println("用户名"+userName);
            System.out.println("密码"+psw);
            //验证
            boolean loginState=DaoTools.checkUser(user);
            if(!loginState){//不存在则关闭
//              sendMsg2Me("用户名或密码错误");
//              this.closeMe();
                os.write(0);
                os.flush();
                return;
            }
            os.write(1);
            os.flush();
            ChatTools.addClient(this);//登陆成功
            ChatTools.loginMsg(userName);

            String msg=brd.readLine();
            while(!msg.equals("bye")&&!msg.equals("Bye")&&!msg.equals("BYE")){
                ChatTools.castMsg(user, msg);
                msg=brd.readLine();//阻塞
            }

            ChatTools.removeClient(this);
            ChatTools.logoffMsg(userName);
            os.write("exit".getBytes());
            is.close();
            os.close();
            this.closeMe();
            //          client.close();//??
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
