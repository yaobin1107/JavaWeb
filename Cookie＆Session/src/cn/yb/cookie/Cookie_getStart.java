package cn.yb.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie_01")
public class Cookie_getStart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie msg = new Cookie("msg", "hello,cookie");
        Cookie msg2 = new Cookie("msg", "hello,cookie2");
        /**
         * 持久化存储：
         * 		setMaxAge(int seconds)
         * 			1. 正数：将Cookie数据写到硬盘的文件中
         * 		       持久化存储。并指定cookie存活时间，时间到后，cookie文件自动失效
         * 			2. 负数：默认值
         * 			3. 零：删除cookie信息
         */
        msg.setMaxAge(30);//持久化，30秒
        /**
         * 1.同一个服务器下多个项目的Cookie共享
         *      cookie.setPath("/");设置后即可共享数据
         * 2.不同服务器下的Cookie共享
         *      cookie.setDomain();如果设置一级域名相同，那么多个服务器之间cookie可以共享
         *      例：setDomain(".baidu.com"),那么tieba.baidu.com 和 news.baidu.com中cookie可以共享
         */
        //2.发送cookie(可以发送多条cookie)
        response.addCookie(msg);
        response.addCookie(msg2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
        /**
         * Cookie的特点和作用
         *  1.特点：
         * 	  1. cookie存储数据在客户端浏览器
         * 	  2. 浏览器对于单个cookie的大小有限制(4kb)以及对同一个域名下的总cookie数量也有限制(20个)
         * 	2.作用：
         *    1. cookie一般用于存出少量的不太敏感的数据
         *    2. 在不登录的情况下，完成服务器对客户端的身份识别
         *    */
    }
}
