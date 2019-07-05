package cn.yb.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/test06")
public class Servlet_RequestHeader extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 2. 获取请求头数据
         * 方法：
         * 	(*)String getHeader(String name):通过请求头的名称获取请求头的值
         * 	Enumeration<String> getHeaderNames():获取所有的请求头名称
         */
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            System.out.println(name + " ：" + request.getHeader(name));
        }
        String header = request.getHeader("user-agent");
        if (header.contains("Firefox")) {
            System.out.println("火狐浏览器！");
        } else if (header.contains("Chrome")) {
            System.out.println("谷歌浏览器！");
        }

        String referer = request.getHeader("referer");
        System.out.println("referer：" + referer);
        if (referer != null) {
            if (referer.contains("test06")) {
                System.out.println("正常访问！");
            } else {
                System.out.println("盗链！");
            }
        }
    }
}
