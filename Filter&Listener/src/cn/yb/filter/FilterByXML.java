package cn.yb.filter;

import javax.servlet.*;
import java.io.IOException;

//浏览器直接请求index.jsp资源时，过滤器被执行
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
//只有转发访问index.jsp资源时，过滤器才会被执行
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.FORWARD)
//配置多个拦截方式
//@WebFilter(value = "/index.jsp",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterByXML implements Filter {
    public void destroy() {
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterByXML被执行了！");
        //放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        /**
         * 过滤器配置详解
         * 	* 拦截路径配置：
         * 		1. 具体资源路径： /index.jsp   只有访问index.jsp资源时，过滤器才会被执行
         * 		2. 拦截目录： /user/*	访问/user下的所有资源时，过滤器都会被执行
         * 		3. 后缀名拦截： *.jsp		访问所有后缀名为jsp资源时，过滤器都会被执行
         * 		4. 拦截所有资源：/*		访问所有资源时，过滤器都会被执行
         * 	* 拦截方式配置：资源被访问的方式
         * 		* 注解配置：
         * 			* 设置dispatcherTypes属性
         * 				1. REQUEST：默认值。浏览器直接请求资源
         * 				2. FORWARD：转发访问资源
         * 				3. INCLUDE：包含访问资源
         * 				4. ERROR：错误跳转资源
         * 				5. ASYNC：异步访问资源
         * 		* web.xml配置
         * 			* 设置<dispatcher></dispatcher>标签即可
         */
    }

}
