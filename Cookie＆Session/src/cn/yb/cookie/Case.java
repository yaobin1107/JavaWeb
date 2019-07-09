package cn.yb.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Case")
public class Case extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//没有cookie
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    //不是第一次访问
                    flag = true;

                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String formatDate = simpleDateFormat.format(date);
                    //URL编码
                    formatDate = URLEncoder.encode(formatDate, "utf-8");

                    cookie.setValue(formatDate);
                    cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
                    response.addCookie(cookie);

                    String value = cookie.getValue();
                    //URL解码
                    value = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次的登陆时间为：" + value + "</h1>");
                    break;
                }
            }
        }
        if (cookies.length == 0 || cookies == null || flag == false) {
            //第一次访问
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formatDate = simpleDateFormat.format(date);

            formatDate = URLEncoder.encode(formatDate, "utf-8");

            Cookie cookie = new Cookie("lastTime", formatDate);

            cookie.setMaxAge(60 * 60 * 24 * 30);//一个月

            response.addCookie(cookie);

            response.getWriter().write("欢迎您首次访问！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
