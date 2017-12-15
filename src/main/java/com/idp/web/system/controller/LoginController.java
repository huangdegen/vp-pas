package com.idp.web.system.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idp.common.base.BaseController;
import com.idp.common.constant.SessionAttr;
import com.idp.common.util.IpUtil;
import com.idp.common.util.MD5Utils;
import com.idp.common.util.MenuUtils;
import com.idp.web.log.entity.UserOpertionsLog;
import com.idp.web.log.service.UserOpertionsLogService;
import com.idp.web.system.entity.SysMenu;
import com.idp.web.system.entity.SysUser;
import com.idp.web.system.service.SysMenuService;
import com.idp.web.system.service.SysUserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    private Logger logger = Logger.getLogger(LoginController.class);

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysMenuService sysMenuService;

    @Resource
    private UserOpertionsLogService userOpertionsLogerService;

    /**
     * 验证用户
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/checkUser")
    @ResponseBody
    public String checkUser(SysUser user, HttpServletRequest request) {
        JSONObject json = new JSONObject();
        SysUser u = null;
        try {
            if (user.getValidateCode() == "") {
                json.put("result", "validateCodeNull");
                return json.toString();
            }
            String validataCode = getValidateCode();
            if (!validataCode.equalsIgnoreCase(user.getValidateCode())) {
                json.put("result", "validateCode");
                return json.toString();
            }
            u = sysUserService.findByUsername(user);

            String md5Passwd = MD5Utils.encodeToMD5(user.getPassword());

			/*
             * 用户登录 "成功" 消息提示成功
			 */
            if (u != null && u.getPassword().equals(md5Passwd)) {
                HttpSession session = request.getSession();
                HttpSession session1 = request.getSession();
                session.setAttribute(SessionAttr.USER_LOGIN.getValue(), u);
                List<String> userMenus = sysUserService.findMenuIdByUserId(u.getId());
                List<SysMenu> menuList = sysMenuService.getByParentId("0");

                session.setAttribute(SessionAttr.USER_MENUS.getValue(), MenuUtils.getMenu(menuList, userMenus));
                //saveOpentionsLog(request, u, 1, 1);
                logger.info("login success");
                json.put("result", "login_success");
            } else {
                if (u != null && u.getId() != null) {
                    //saveOpentionsLog(request, u, 2, 1);
                }
            }
            /*
			 * 用户登录失败 "消息" 提示失败
			 */
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //saveOpentionsLog(request, u, 2, 1);
        }

        return json.toString();
    }

	/*public void saveOpentionsLog(HttpServletRequest request, SysUser user, int loginStatus, int getOutLogin) {
		String ipAddress = IpUtil.getIpAddr(request);
		UserOpertionsLog userOpertionsLog = new UserOpertionsLog();
		userOpertionsLog.setResult(1);
		userOpertionsLog.setIpAddress(ipAddress);
		userOpertionsLog.setAction((getOutLogin == 2 ? "登录" : "注销"));
		userOpertionsLog.setModels("后台管理鉴权");
		if (loginStatus == 1) {
			userOpertionsLog.setMessage("【" + user.getName() + "】" + "登录成功");
		} else if(loginStatus == 2){
			userOpertionsLog.setMessage("【" + user.getName() + "】" + "登录失败");
		}else
			userOpertionsLog.setMessage("【" + user.getName() + "】" + "注销登录");
		if (getOutLogin == 2) {
			userOpertionsLog.setAction("注销");
		}else{
			userOpertionsLog.setAction("登录");
		}
		userOpertionsLog.setSysUser(user);
		userOpertionsLogerService.add(userOpertionsLog);
	}*/

    /**
     * 退出 用户退出 "消息 " 提示注销登录
     *
     * @param request
     * @return
     */

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {

        SysUser user = getCurrentUser(); // 获取当前用户的信息
        HttpSession session = request.getSession();
        //清除session用户
        session.removeAttribute(SessionAttr.USER_LOGIN.getValue());
        session.removeAttribute(SessionAttr.USER_ROLES.getValue());
        session.removeAttribute(SessionAttr.USER_MENUS.getValue());

        //saveOpentionsLog(request, user, 3, 2);

        return "login/login";
    }
}
