package com.ccd.test.propertiesConfiguration;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

import java.io.File;


public class FileChangedReloadingStrategyTest {
    //加载文件的频率
    private static final long RELOAD_PERIOD = 10L;
    private static PropertiesConfiguration config;

    public void starts(){
        //获得当前类运行的classpath路径

        initialize("jdbc.properties");

        while(true){
            try {
//	            	config.getReloadingStrategy().reloadingPerformed();
//	                System.out.println(config.getReloadingStrategy().reloadingRequired());
                System.out.println("user=" + config.getString("jdbc.oracle.driverClassNamecolor"));
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //初始化配置文件和文件加载策略
    private static void initialize(String filePath){

        try {
            config = new PropertiesConfiguration(new 	File("D:/Workspaces/ccdtest/src/jdbc.properties"));
            FileChangedReloadingStrategy fileChangedReloadingStrategy = new FileChangedReloadingStrategy();
            //设置扫描文件的最小时间间隔
            fileChangedReloadingStrategy.setRefreshDelay(RELOAD_PERIOD);
            //   File file = new 	File(filePath);
            //设置加载策略
            config.setReloadingStrategy(fileChangedReloadingStrategy);
//            config.addConfigurationListener(new ConfigurationListener() {
//                @Override
//                public void configurationChanged(ConfigurationEvent e)
//                {
//                    System.out.println("配置文件更新..."+e.getType());
//                    if(PropertiesConfiguration.EVENT_RELOAD ==e.getType())
//                    {
//                      System.out.println("配置文件重载...");
//                    }
//                }
//            });

        }catch (ConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FileChangedReloadingStrategyTest().starts();
    }
}

