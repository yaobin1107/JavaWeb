package cn.yb.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class Servlet_RequestDispatcher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("forward被访问了！");
        /*RequestDispatcher requestDispatcher = request.getRequestDispatcher("/test03");
        requestDispatcher.forward(request, response);*/
        request.setAttribute("msg","这是一条消息");
        request.getRequestDispatcher("/test03").forward(request, response);
        /**
         * 请求转发的特点：
         *      1.资源路径（浏览器地址栏）没有发生变化
         *      2.不能访问服务器以外的资源（只能转发到服务器内部资源中）
         *      3.转发是一次请求
         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
