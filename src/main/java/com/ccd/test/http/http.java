package com.ccd.test.http;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Wangmx on 2017/12/15.
 * HTTP协议详解（孙鑫老师）引言
 * 内容：
 *  介绍HTTP协议的有关内容，包括HTTP URL ,HTTP请求，HTTP响应和HTTP消息，
 *
 *  绝大多数的Web开发，都是构建在HTTP协议这上的web应用
 *
 *
 *  HTT（Hypertext Transfer Protocol）超文本传输协议，从1990年开始就在
 *  www上广泛应用，是现在www上应用最多的协议，目前的版本是1.1
 *
 *  http是应用层的协议，当你上网浏览网页的时候，浏览器和Web服务器之间就会通过
 *  http在 internet上进行数据的发送和接收
 *
 *  http是一个基于请求/相应模式的、无状态的协议
 *  http基于TCP连接
 *
 *
 *  http请求：
 *  客户端通过发送HTTP请求向服务器请求对资源的访问。
 *  HTTP请求由三部分组成，分别是：请求行，消息报文，请求正文
 *  ----请求行
     请求行以一个方法符号开头，以后跟着请求URI和协议的版本，以CRLF作为结尾。请求
    行以空格分割，除了作为结尾的CRLF外，不允许出现单独的CR或LF字符，格式如下
    Method Request-URI HTTP-Version CRLF(回车换行)
    Method表示请求的方法，Request-URI是一个统一资源标识符，表示了要请求的资源，
    HTTP-Version表示请求的HTTP协议版本，CRLF表示回车换行，例如
    GET /form.html HTTP/1.1 (CRLF)

    HTTP 请求--方法
   GET  请求获取由Request-URI所表示的资源
   POST  在Request-URI所标识的资源后附加信息的数据
   HEAD  请求获取由Reqeust-URI所标识的资源的响应消息报头
   PUT  请求服务器存储一个资源，并用Request-URI作为其表示
   DELETE  请求服务器删除由Request-URI所表示的资源
   TRACE   请求服务器回送收到的请求信息，主要用于测试或诊断
   CONNECT  保留将来使用
   OPTIONS  请求查询服务器性能，或者查询由资源相关的选项或需求


    POST方法用于向目的服务器发出请求，要求服务器接受附在请求后面的数据。
    POST方法在表单提交的时候用的比较多
    采用POST方法提表单的例子：
    POST /reg.jsp  HTTP/1.1 (CRLF)
    Accept: image/gif,image/x-xbt,...(因为篇幅关系，这部分省略)（CRLF）
    ....
    Host:www.winsunling:.....
    Content-Length:22
    Connection:keep-Alive
    Cache-Control:no-cache
    (CRLF)
    user=zhangsan&pwd=1234

    HTTP响应-状态行
    状态行有协议版本、数字形式的状态代码、及相应的状态描述组成，各元素
     之间以空格分割，除了结尾的CLLF外，不允许出现CR或LF字符，格式如下
     HTTP-Version Status-Code Reason-Phrase CRLF
    HTTP/1.1 200 OK (CRLF)
    1xx : 只是请求已经接受，继续处理
    2xx : 成功---接受理解接受
    3xx  重定向---要完成请求必须进行更进一步的操作
    4xx  客户端错误
    5xx    服务器端错误

 HTTP消息
 HTTPx消息 客户端到服务器的请求 和服务器到
 *
 *  请求消息的例子
 *  GET /form.html HTTP/1.1 (CRLF)
 *  Accept:image/gif,image/x-xBitmap,image.jpge,image/pjpeg
 *   .....(CRLF)
 *  Accept-Language:zh-cn(CRLF)
 *  Accept-Encoding:gzip,deflage(CRLF)
 *  If-Modified-Size:web,05 jan 2005 ..CMT(CRLF)
 *  If-None-Match:W/"80b1a4c..:1212"(CRLF)
 *  User-Agent:Mozilla/4.a(compatible;Msie6.0;Windows Nt5.0) (CRLF)
 *  Host:www.winsunligt.com(CRLF)
 *  Connection:Keep-Alive(CRLF)
 *  CRLF(表示一个空行)
 *
 *
 *  相应消息的例子：
 *  HTTP/1.1 200 OK(CRLF)
 *  Content-length：2218（CCLF）
 *  Content-Type:text/html(CRLF)
 *  Last-Modified:web,05 Jan 2005..(CRLF)
 *  Accept-Ranges:bytes(CRLF)
 *  Etag:W/"80907099f23"(CRLF)
 *  Server:Microsoft-IIS/6.0(CRLF)
 *  Date: Wed,05 Jan 2005 332rGMT(CRLF)
 *  CRLF(表示一个空行)
 *  <html>
 *      fdfd
 *  </html>
 *
 *
 *  消息报头
 *  HTTP消息报头包括普通报头、请求报头、响应报头、实体报头
 *  每一个报头域都是由名字+“：”+空格+值组成，消息报头域的名字
 *  是大小写无关的
 *
 *  常用的普通报头（1）
 *  Cache-Control:
 *  cache-Control普通报头域用于指定缓存指令，
 *  no-cache,no-store\max-age,max-stale....
 *  最常用的是no-cache,用于只是请求或响应的消息不能缓存
 *
 *  例如：为了只是ie浏览器（客户端）不要缓存页面，服务器端的JSP程序
 *  可以编写下面代码：
 *  respone.setHeader("Cache-control","no-cache")
 *  这句代码将在发送的响应消息中设置普通报文域：Cache-Control:no-cache
 *  Date(2)
 *  Connection:
 *    Connection 普通报文域允许发送者指定连接的选项。例如指定连接是持续的
 *    ，或者指定“close”选项，通知服务器，在响应完成后，关闭浏览器
 *  Pragma:
 *  pragma普通报文域被用于包含特定实现的指令：
 *  这些指令会应用到请求/响应链中的任何一个接受这
 *  response.setHeader("Pragma","no-cache")
 *
 * 消息报头--请求报头：
 * 请求报头允许客户端向服务器端传递改请求的附加信息已经客户端自身的信息
 * 场景的请求报头：
 * accept: 客户端接受那些类型的新
 * Acceipt-charset: 请求报文域用于指定客户端接受的字符集；
 * 入Accpet-Charset:iso-885803,gb2123
 *。。。
 *
 *
 * 消息报头--响应报头
 *  响应报头允许服务器传递不能放在状态行中的附加响应信息，以及关于服务器
 *  的信息和对Request-URI所表示的资源进行下一步访问的信息
 *
 *  Location
 *    用于重定向接受者到一个新的位置 ：
 *   响应报头域
 *   Location:http://www.sunxin.org
 *  Server:
 *   Server响应报头域包含了服务器用来处理请求的软件信息。
 *   它和User-Agent请求报文
 *  www-Authenticat:
 *     该请求报头域必须包含在401（未授权）的响应中
 *
 *  实体报头：
 *  前面所讲的普通报头、请求报头、响应报头我们可以看成是写在信封上的
 *  邮编、接受者、发送者等内容。
 *  实体报头定义了关于实体正文（例如：有无实体正文）和请求所标识的资源的元
 *  信息
 *
 * 常用的实体报头
 * content-Encoding
 * Content-Language:
 * Content-Length:
 * cONTENT-tYPE: 实体报头域用于指定发送给接受者的实体正文的媒体类型
 * Last_modified:last-Modified实体报头域用于指示资源最后的修改日期
 * 及时间。
 * Expires:
 *    Expires实体报头域给出响应过期的日期和时间。通常，代理服务器或刘拉起
 *    会缓存一些页面信息，当用户再次访问时，直接从缓存中价值数据给用户，
 *    这样缩短响应的时间，减少服务器器赋值，
 *    为了让代理服务器或刘拉起在一断案时间后更新页面，我们可以使用
 *    Expires实体报头于指定页面过期的时间，当用户又一次访问页面时，
 *    如果Expires报头域给出了日期和时间被Date普通报头域给的时间早，那么代理服务器或刘拉起
 *    不会使用缓存的页面，而是从服务器上请求更新的页面。不过要注意，及时
 *    页面过期了，也不意味着服务器上面的原始资源在此时间之前或之后发生了
 *    改变。
 *    HTTP1.1的客户端和缓存必须将其他非法的日期格式（也包括0）看作
 *    已经过期。例如为了让浏览器不要缓存页面，我们也可以利用
 *    Expires实体报头域，设置它的值为0,如下：
 *    response.setDateHeader("Expires",0);
 *
 *
 * HEAD /index.html HTTP/1.1
 * Host: www.163.com
 *
 * HEAD /index.asp HTTP/1.1
 * Host: www.mybole.com.cn
 *
 * GET /index.html HTTP/1.1
 * Connection: close
 * Host:www.163.com
 *
 */
public class http {
    public static void main(String[] args) {

    }
}
