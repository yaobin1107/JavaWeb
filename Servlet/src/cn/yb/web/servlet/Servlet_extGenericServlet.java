package cn.yb.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/test03")
public class Servlet_extGenericServlet extends GenericServlet{
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //System.out.println("GenericServlet");
        System.out.println("test03被访问了！");
        System.out.println(servletRequest.getAttribute("msg"));
    }
}
