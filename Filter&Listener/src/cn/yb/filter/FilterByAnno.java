package cn.yb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/login.jsp")访问login.jsp。才会执行该过滤器（具体资源路径）
//@WebFilter("/user/*")访问/user下所有资源。会执行该过滤器（拦截目录）
//@WebFilter("*.jsp")访问所有.jsp结尾的资源。会执行该过滤器（后缀名拦截）
@WebFilter("/*")//访问所有资源。都会执行该过滤器（拦截所有资源）
public class FilterByAnno implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /**
         * 服务器启动后，会创建Filter对象，执行init方法
         */
        System.out.println("init!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /**
         * 每次请求被拦截都会执行
         */
        System.out.println("FilterByAnno被执行了！");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        /**
         * 服务器关闭后，Filter对象被销毁，正常关闭则会执行destroy方法
         */
        System.out.println("destroy!");
    }
}
