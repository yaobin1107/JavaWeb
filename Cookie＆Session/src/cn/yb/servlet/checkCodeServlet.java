package cn.yb.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class checkCodeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 120;
        int height = (int) (120 * 0.382);

        //1.创建对象，在内存中的图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1填充背景色
        Graphics graphics = image.getGraphics();//画笔对象
        graphics.setColor(Color.PINK);
        graphics.fillRect(0, 0, width, height);
        //2.2画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width - 1, height - 1);

        String str = "QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuioplkjhgfdsazxcvbnm1234567890";
        //随机码
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            Byte[] size = new Byte[]{20, 22, 23, 25};
            int anInt = random.nextInt(size.length - 1);
            //获取字符
            char c = str.charAt(index);
            builder.append(c);
            //2.3写验证码
            graphics.setFont(new Font("微软黑雅", 0, size[anInt]));
            graphics.drawString(c + "", width / 6 * i, (int) (height / 1.5));
        }
        //将验证码放入session
        request.getSession().setAttribute("checkCode_session", builder.toString());


        //2.4画干扰线
        graphics.setColor(Color.gray);
        //随机坐标点
        for (int i = 0; i < 15; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(height);
            int y1 = random.nextInt(width);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, x2, y1, y2);
        }

        //3.将图片输出到页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
