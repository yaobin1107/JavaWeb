package cn.yb.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登陆验证过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0.强转
        HttpServletRequest request = (HttpServletRequest) req;
        //1.获取资源请求路径
        String uri = request.getRequestURI();
        //2.判断是否包含登陆相关资源路径
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")) {
            //包含，用户想登录，放行
            chain.doFilter(req, resp);
        } else {
            //不包含，判断用户是否登录
            //3.session中获取user
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                //不为空
                chain.doFilter(req, resp);
            } else {
                //没登陆，跳转登陆
                request.setAttribute("login_msg", "您还没有登陆，请登录！");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
        //放行
        //chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
