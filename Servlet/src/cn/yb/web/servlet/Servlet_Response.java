package cn.yb.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/response01")
public class Servlet_Response extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //System.out.println("response01");
        //获取输出流
        /*PrintWriter writer = response.getWriter();
        writer.write("你好！");*/
        //获取字节输出流
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write("你好".getBytes());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
