package cn.yb.web.download;

import cn.yb.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downLoadServlet")
public class downLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String filename = request.getParameter("filename");
        //filename = new String(filename.getBytes("iso-8859-1"),"utf-8");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件在服务器的真实路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2字节流关联
        FileInputStream fileInputStream = new FileInputStream(realPath);

        //3.设置response的响应头
        //3.1设置响应头类型
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type", mimeType);
        //解决中文乱码问题
        //获取user-agent请求头
        String agent = request.getHeader("user-agent");
        //利用工具类编码
        filename = DownLoadUtils.getFileName(agent, filename);
        //3.2设置响应头打开方式
        response.setHeader("content-disposition", "attachment;filename=" + filename);

        //4.将输入流数据写出到输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fileInputStream.read(buff)) != -1) {
            outputStream.write(buff, 0, len);
        }
        fileInputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
