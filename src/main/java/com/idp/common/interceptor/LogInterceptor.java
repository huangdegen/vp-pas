package com.idp.common.interceptor;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.idp.common.constant.SessionAttr;
import com.idp.common.util.ContextHolderUtil;
import com.idp.common.util.IpUtil;
import com.idp.web.access.entity.AccessLog;
import com.idp.web.access.service.AccessLogService;
import com.idp.web.system.entity.SysUser;
import com.idp.web.system.service.SysUserService;

public class LogInterceptor implements HandlerInterceptor {

	private static final Logger logger = Logger.getLogger(LogInterceptor.class);

	@Resource
	private AccessLogService accessLogService;
	
	@Resource
	private SysUserService sysUserService;

	/**
	 * 在controller后拦截
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 在controller前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

		/*HttpSession session = ContextHolderUtil.getSession();
		*//*
		 * 获取当前登录的用户信息
		 *//*
		SysUser user = (SysUser) session.getAttribute(SessionAttr.USER_LOGIN.getValue());
		
		if (user != null && null != user.getUsername()) {
			user = sysUserService.findByUsername(user);
			String ipAddress = IpUtil.getIpAddr(request); // 获取IP地址
			String requestPath = getRequestPath(request);// 用户访问的资源地址
			logger.info("信息拦截:" + user);
			logger.info("日志拦截url:" + requestPath);
			// logger.info("日志拦截url:" + accessLogService);
			AccessLog accessLog = new AccessLog();
			accessLog.setUserId(user.getId());
			accessLog.setAccessLogTime(new Date());
			accessLog.setAccessIp(ipAddress);
			accessLog.setAccessUrl(requestPath);
			accessLogService.add(accessLog);
		}
		*/
		return true;
	}

	/**
	 * 截取访问路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestPath(HttpServletRequest request) {

		String requestPath = request.getRequestURI();

		// 去掉其他参数
		if (requestPath.indexOf("&") > -1) {

			requestPath = requestPath.substring(0, requestPath.indexOf("&"));
		}
		// 去掉jsessionid参数
		if (requestPath.indexOf(";") > -1) {

			requestPath = requestPath.substring(0, requestPath.indexOf(";"));
		}

		// 去掉项目路径
		requestPath = requestPath.substring(request.getContextPath().length() + 1);
		return requestPath;
	}

}
