package com.ccd.test.tomcat.oneWebServerMechanism.zushaduoxianchegn;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by ccd on 2018/1/30.
 */
public class MultiThreadEchoServer {
    private final static Logger logger = Logger.getLogger(MultiThreadEchoServer.class.getName());

    /**
     * @param args [0]-监听端口
     */
    public static void main(String[] args) {

        int port = Integer.parseInt("9090");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(port));
            if (logger.isLoggable(Level.INFO)) {
                logger.info("多线程网络echo服务启动完毕，监听端口：" +port);
            }
            while (true) {
                // 接收新的客户端连接
                Socket socket = serverSocket.accept();
                if (logger.isLoggable(Level.INFO)) {
                    logger.info("收到一个新的连接，客户端IP："+socket.getInetAddress().getHostAddress()+"，客户端Port："+socket.getPort());
                }

                // 新建一个线程处理Socket连接
                Thread thread = new Thread(new Worker(socket));
                thread.start();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "处理网络连接出错", e);
        }
    }
}
