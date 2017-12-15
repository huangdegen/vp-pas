package com.idp.common.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by sulite on 2017/9/25.
 */
public class ValidationUtil extends HttpServlet {
    Random random = new Random();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int height = 220;  //图片高
        int width = 220;  //图片宽
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();

        //(random.nextInt(0)+1)
        Resource resource = new ClassPathResource("validation/validation7.jpg");

        //String picPath = ValidationUtil.class.getClassLoader().getResource("validation/validation" + (random.nextInt(0) + 1) + ".jpg").getPath();  //读取本地图片，做背景图片

        g.drawImage(ImageIO.read(resource.getFile()), 0, 20, width, height, null); //将背景图片从高度20开始


        g.setColor(Color.white);  //设置颜色
        g.drawRect(0, 0, width - 1, height - 1); //画边框

        g.setFont(new Font("宋体", Font.BOLD, 20)); //设置字体
        Integer x = null, y = null;  //用于记录坐标
        String target = null; // 用于记录文字
        for (int i = 0; i < 6; i++) {  //随机产生6个文字，坐标，颜色都不同
            g.setColor(new Color(random.nextInt(50) + 200, random.nextInt(150) + 100, random.nextInt(50) + 200));
            String str = getRandomChineseChar();
            int a = random.nextInt(width - 100) + 50;
            int b = random.nextInt(height - 70) + 55;
            if (x == null) {
                x = a; //记录第一个x坐标
            }
            if (y == null) {
                y = b;//记录第一个y坐标
            }
            if (target == null) {
                target = str; //记录第一个文字
            }
            g.drawString(str, a, b);
        }
        g.setColor(Color.white);
        g.drawString("点击" + target, 0, 20);//写入验证码第一行文字  “点击..”
        request.getSession().setAttribute("gap", x + ":" + y);//将坐标放入session
        //5.释放资源
        g.dispose();
        //6.利用ImageIO进行输出
        ImageIO.write(image, "jpg", response.getOutputStream()); //将图片输出


    }


    //网上找的，随机产生汉字的方法
    public String getRandomChineseChar() {
        String str = null;
        int hs, ls;
        Random random = new Random();
        hs = (176 + Math.abs(random.nextInt(39)));
        ls = (161 + Math.abs(random.nextInt(93)));
        byte[] b = new byte[2];
        b[0] = (new Integer(hs).byteValue());
        b[1] = (new Integer(ls).byteValue());
        try {
            str = new String(b, "GBk"); //转成中文
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return str;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
