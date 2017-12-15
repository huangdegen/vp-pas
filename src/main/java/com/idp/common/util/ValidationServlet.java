package com.idp.common.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by sulite on 2017/9/25.
 */

public class ValidationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=utf-8"); //设置编码
        //获取前端传来的坐标
        String xs=request.getParameter("x");
        String ys=request.getParameter("y");
        HttpSession session = request.getSession();
        String str = (String) session.getAttribute("gap");//获取session中的gap
        if(str==null){
            response.getWriter().write("验证码超时");
            return;
        }
        String[] split2 = str.split(":");
        int x=    Integer.parseInt(xs);
        int y=Integer.parseInt(ys);
        int x1=    Integer.parseInt(split2[0]);
        int y1=Integer.parseInt(split2[1]);
        if(x1-2<x && x<x1+22 && y1-22<y && y<y1+2){  //若前端上传的坐标在session中记录的坐标的一定范围内则验证成功
            response.getWriter().write("验证成功");
        }else{
            response.getWriter().write("验证失败");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}

