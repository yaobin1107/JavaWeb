package cn.yb.web.servlet;

import cn.yb.dao.IUserDao;
import cn.yb.dao.impl.UserDaoImpl;
import cn.yb.model.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {
    /**
     * * 用户登录案例需求：
     * 1.编写login.html登录页面
     * username & password 两个输入框
     * 2.使用Druid数据库连接池技术,操作mysql，day14数据库中user表
     * 3.使用JdbcTemplate技术封装JDBC
     * 4.登录成功跳转到SuccessServlet展示：登录成功！用户名,欢迎您
     * 5.登录失败跳转到FailServlet展示：登录失败，用户名或密码错误
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        /*//2.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3.封装User对象
        User loginUser = new User();
        loginUser.setPassword(password);
        loginUser.setUsername(username);*/
        /**
         * 获取所有请求参数
         */
        Map<String, String[]> parameterMap = request.getParameterMap();
        User loginUser = new User();
        //使用BeanUtils
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用dao方法
        IUserDao userDao = new UserDaoImpl();
        User user = userDao.login(loginUser);
        //5.判断
        if (user == null) {
            //登陆失败
            request.getRequestDispatcher("/failServlet").forward(request, response);
        } else {
            //登陆成功
            request.setAttribute("user", user);
            request.getRequestDispatcher("/successServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
