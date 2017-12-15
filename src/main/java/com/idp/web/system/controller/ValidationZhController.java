package com.idp.web.system.controller;

import com.idp.common.util.ContextHolderUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by sulite on 2017/9/26.
 */
@Controller
@RequestMapping("/ValidationZh")
public class ValidationZhController {


    @ResponseBody
    @RequestMapping("/validation")
    public boolean validation(Integer x, Integer y) {
        HttpSession session = ContextHolderUtil.getSession();
        String str = (String) session.getAttribute("gap");//获取session中的gap
        if (str == null) {
            return false;
        }
        String[] split2 = str.split(":");
        int x1 = Integer.parseInt(split2[0]);
        int y1 = Integer.parseInt(split2[1]);
        return x1 - 2 < x && x < x1 + 22 && y1 - 22 < y && y < y1 + 2;  //若前端上传的坐标在session中记录的坐标的一定范围内则验证成功
    }
}
