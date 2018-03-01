package com.ccd.test.tomcat;


import org.apache.catalina.core.StandardWrapper;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestConnector {
    private static class StartStopThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        public StartStopThreadFactory(String namePrefix) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = namePrefix;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(group, r, namePrefix + threadNumber.getAndIncrement());
            thread.setDaemon(true);
            return thread;
        }
    }

    public TestConnector() {
    }

    public static void main(String[] args) throws Exception {
		org.apache.catalina.core.StandardServer cd = new org.apache.catalina.core.StandardServer();
		
		org.apache.catalina.core.StandardService server = new org.apache.catalina.core.StandardService();
		
		org.apache.catalina.core.StandardEngine  standardEngine = new org.apache.catalina.core.StandardEngine();

		org.apache.catalina.core.StandardHost container = new org.apache.catalina.core.StandardHost();
        org.apache.catalina.startup.ContextConfig contextconfig = new org.apache.catalina.startup.ContextConfig();

		try {
            ThreadPoolExecutor cdd =new ThreadPoolExecutor(1,2, 10, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>(),
                    new StartStopThreadFactory("" + "-startStop-"));
        }catch (Exception e){
		    e.printStackTrace();
        }
        org.apache.catalina.core.StandardContext standardContext = new org.apache.catalina.core.StandardContext();
        org.apache.catalina.loader.WebappLoader  webappLoader = new org.apache.catalina.loader.WebappLoader();
        org.apache.catalina.startup.ContextRuleSet contextRuleSet = new org.apache.catalina.startup.ContextRuleSet();
        org.apache.catalina.core.StandardWrapper standardWrapper =  new StandardWrapper();

        
        org.apache.catalina.connector.Connector connector = new org.apache.catalina.connector.Connector();
        org.apache.coyote.http11.Http11Protocol http11Protocol = new org.apache.coyote.http11.Http11Protocol();
        org.apache.tomcat.util.net.JIoEndpoint jioEndpoint = new org.apache.tomcat.util.net.JIoEndpoint();
        org.apache.tomcat.util.net.DefaultServerSocketFactory factory = new
                org.apache.tomcat.util.net.DefaultServerSocketFactory(null);

       // org.apache.catalina.connector.MapperListener mapperListener = new org.apache.catalina.connector.MapperListener(null, null);


        org.apache.coyote.http11.Http11Protocol  http1protocol = new org.apache.coyote.http11.Http11Protocol();


        //servlet {default=StandardEngine[Catalina].StandardHost[localhost].StandardContext[/docs].StandardWrapper[default], jsp=StandardEngine[Catalina].StandardHost[localhost].StandardContext[/docs].StandardWrapper[jsp]}


		org.apache.catalina.startup.HostConfig hostConfig = new org.apache.catalina.startup.HostConfig();


	}

}
