package cn.yb.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletContextFunction_02")
public class ServletContextFunction_02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //域对象：共享数据（获取）
        ServletContext servletContext = request.getServletContext();
        System.out.println(servletContext.getAttribute("msg"));
        /**
         * 3.获取文件真实（服务器）路径
         * 方法：String getRealPath(String path)
         */
        String realPath = servletContext.getRealPath("/register.html");//web目录下资源
        String realPath1 = servletContext.getRealPath("/WEB-INF/web.xml");//WEB-INF目录下资源
        String realPath2 = servletContext.getRealPath("/WEB-INF/classes/druid.properties");//src目录下资源
        System.out.println(realPath);
        System.out.println(realPath1);
        System.out.println(realPath2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
