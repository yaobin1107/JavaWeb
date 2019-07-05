package cn.yb.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/parameters")
public class Servlet_ReuqestParameters extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        /**POST获取请求参数
         * 2. 其他功能：
                1. 获取请求参数通用方式：不论get还是post请求方式都可以使用下列方法来获取请求参数
                    1. String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
                    2. String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game
                    3. Enumeration<String> getParameterNames():获取所有请求的参数名称
                    4. Map<String,String[]> getParameterMap():获取所有参数的map集合
         *
         * 		中文乱码问题：
         * 			get方式：tomcat 8 已经将get方式乱码问题解决了
         * 			post方式：会乱码
         * 				解决：在获取参数前，设置request的编码request.setCharacterEncoding("utf-8");*/
        //1. String getParameter(String name):根据参数名称获取参数值
        String username = request.getParameter("username");
        System.out.println("POST:"+username);
        //2. String[] getParameterValues(String name):根据参数名称获取参数值的数组
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        System.out.println("-------------");
        //3. Enumeration<String> getParameterNames():获取所有请求的参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            String parameter = request.getParameter(name);
            System.out.println(name+" ："+parameter);
            System.out.println("-------------");
        }
        //4. Map<String,String[]> getParameterMap():获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String key : keySet) {
            System.out.println(key);
            String[] values = parameterMap.get(key);
            for (String value : values) {
                System.out.println(value);
                System.out.println("-------------");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /** GET获取请求参数*/
        /*//1. String getParameter(String name):根据参数名称获取参数值
        String username = request.getParameter("username");
        System.out.println("GET:"+username);*/
        this.doPost(request,response);
    }
}
