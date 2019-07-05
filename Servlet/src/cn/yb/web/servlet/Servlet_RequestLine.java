package cn.yb.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*1. 获取请求行数据
        * GET /day14/demo1?name=zhangsan HTTP/1.1
        * 方法：
            1. 获取请求方式 ：GET
                * String getMethod()

            2. (*)获取虚拟目录：/day14
                * String getContextPath()

            3. 获取Servlet路径: /demo1
                * String getServletPath()

            4. 获取get方式请求参数：name=zhangsan
                * String getQueryString()

            5. (*)获取请求URI：/day14/demo1
                * String getRequestURI():		/day14/demo1
                * StringBuffer getRequestURL()  :http://localhost/day14/demo1

                * URL:统一资源定位符 ： http://localhost/day14/demo1	中华人民共和国
                * URI：统一资源标识符 : /day14/demo1					共和国

            6. 获取协议及版本：HTTP/1.1
                * String getProtocol()

            7. 获取客户机的IP地址：
                * String getRemoteAddr()*/

@WebServlet("/test05")
public class Servlet_RequestLine extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 获取请求行数据！
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 设置流编码
         */
        request.setCharacterEncoding("utf-8");
        /**
         * 1. 获取请求方式：GET
         *    String getMethod()*/
        System.out.println("请求方式：" + request.getMethod());
        /**2. (*)获取虚拟目录：/day14
         *  String getContextPath()*/
        System.out.println("虚拟目录：" + request.getContextPath());
        /**3. 获取Servlet访问路径: /demo1
         *  String getServletPath()*/
        System.out.println("Servlet访问路径:" + request.getServletPath());
        /**4. 获取get方式请求参数：name = zhangsan
         *  String getQueryString()*/
        System.out.println("get方式请求参数：" + request.getQueryString());
        /**5. (*)获取请求URI：/day14 / demo1
         *  String getRequestURI():		/day14 / demo1
         *  StringBuffer getRequestURL()  :http://localhost/day14/demo1
         *
         *  URL:统一资源定位符 ：http://localhost/day14/demo1	中华人民共和国
         *  URI：统一资源标识符: /day14/demo1 共和国*/
        System.out.println("请求URI：" + request.getRequestURI());
        System.out.println("请求URL：" + request.getRequestURL());
        /**6. 获取协议及版本：HTTP / 1.1
         *  String getProtocol()*/
        System.out.println("协议版本：" + request.getProtocol());
        /**7. 获取客户机的IP地址：
         *  String getRemoteAddr ()*/
        System.out.println("客户机IP：" + request.getRemoteAddr());
    }
}
