package cn.yb.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/response02")
public class Servlet_Response02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 第一种：
         * response.setStatus(301);
         * response.setHeader("location", "/case/response01");
         */

        System.out.println("response02");

        //动态获取虚拟目录（Servlet访问路径）
        String contextPath = request.getContextPath();
        //System.out.println(contextPath);

        response.sendRedirect(contextPath + "/response01");
        //response.sendRedirect("http://www.baidu.com");
        /**
         * 重定向的特点：
         *      1.地址栏路径改变
         *      2.可以访问其他服务器资源
         *      3.两次请求
         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
