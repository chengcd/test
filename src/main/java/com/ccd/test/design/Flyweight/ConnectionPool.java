package com.ccd.test.design.Flyweight;

import java.sql.Connection;
import java.util.Vector;

/**
 * Created by ccd on 2017/12/6.
 *
 * 享元模式（Flyweight）
 *享元模式的主要目的是实现对象的共享，即共享池，当系统中对象可以减少内存的开销，通常与工厂模式一起使用
 *
 * FlyWeightFactory 1...n -------->FlyWeight
 *      |
 *      |
 *      |
 *      |
 *   Client               FlyWeight1             FlyWeight2
 *FlyWeightFactory负责创建和管理享元单元，当一个客户端请求时，工厂需要检查当前对象中是否有符合条件的对象，
 * 如果有，就返回已经存在的对象，如果没有，则创建一个新对象，FlyWeight是超类。一提到共享池，我们很容易联想
 * 到Java里面的JDBC连接池，想想每个连接的特点，我们不难总结出：适用于作共享的一些个对象，他们有一些共有的属性，
 * 就拿数据库连接池来说，url、driverClassName,username,password及dbname, 这些属性对于每个连接来说都是一样
 * 的，所以就适合享元模式来处理，建一个工厂类，将上述类似属性作为内部数据，其他的作为外部数据，在方法调用时，
 * 当做参数传进来，这样就节省了控件，减少了实例数量。
 *
 *
 * ConnectionPool  1...n
 *   [release,                            Connection
 *   getConnection()]
 *      |
 *      |
 *      |
 *  ConnectionPoolTest
 * 看下数据库连接池代码：
 *
 *
 */
public class ConnectionPool {
   private Vector<Connection> pool;

   /******公有属性******/
   private String url = "jdbc:mysql://localhost:3306/test";
   private String username = "root";
   private String passowrd = "root";
   private String driverClassName = "com.mysql.jdbc.Driver";

   private int poolSize = 100;

   private static ConnectionPool instance = null;
   Connection conn = null;

   private ConnectionPool(){}













}
