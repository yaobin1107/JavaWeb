package cn.yb.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletContextFunction")
public class ServletContextFunction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * ServletContext的功能
         *  1.获取MIME类型
         *      getMimeType();
         *  2.域对象：共享数据
         * 		1. setAttribute(String name,Object value)
         * 		2. getAttribute(String name)
         * 		3. removeAttribute(String name)
         * 		ServletContext对象范围：所有用户所有请求的数据
         *  3.获取文件真实（服务器）路径
         */
        //1.获取MIME类型
        ServletContext servletContext = request.getServletContext();
        String mimeType = servletContext.getMimeType("a.jpg");
        System.out.println(mimeType);//image/jpeg

        //2.域对象：共享数据
        servletContext.setAttribute("msg", "你好啊！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
