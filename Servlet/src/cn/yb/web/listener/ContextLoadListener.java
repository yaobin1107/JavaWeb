package cn.yb.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//@WebListener()
public class ContextLoadListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        /**
         * 监听ServletContext对象的创建，ServletContext对象在服务器启动后自动创建
         */
        //加载资源文件
        //1.获取ServletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();
        //2.加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //3.获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);
        //4.加载进内存
        try {
            FileInputStream fis = new FileInputStream(realPath);
            System.out.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("ServletContext对象创建了！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        /**
         * 服务器正常关闭后，ServletContext对象被销毁
         */
        System.out.println("ServletContext对象销毁了！");
    }
}
