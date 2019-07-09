package cn.yb.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Session_life")
public class Session_life extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用session共享数据
        //获取session
        HttpSession session = request.getSession();
        /**
         * 持久化Session
         */
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        /**
         * session什么时候被销毁
         *  1.服务器关闭
         *  2.session对象调用 invalidate()
         *  3.session默认失效时间为30分钟
         *      选择性配置：（tomcat-conf-web.xml）
         *          <session-config>
         * 		        <session-timeout>30</session-timeout>
         * 		    </session-config>
         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
