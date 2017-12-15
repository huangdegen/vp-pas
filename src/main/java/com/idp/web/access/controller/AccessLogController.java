package com.idp.web.access.controller;
import com.idp.web.access.entity.AccessLog;
import com.idp.web.access.service.AccessLogService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idp.common.base.BaseController;
import com.idp.common.persistence.Page;
import com.idp.common.util.ValidateUtils;

import net.sf.json.JSONObject;

/**
 * 
 * 访问日志controller
 * 
 * <pre>
 * 	历史记录：
 * 	2017-04-13 00
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	00
 * PG
 *	00
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
@Controller
@RequestMapping("/accessLog")
public class AccessLogController extends BaseController {

	private Logger logger = Logger.getLogger(AccessLogController.class);

	@Resource
	private AccessLogService accessLogService;
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 00
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(){
		
		return "access/accessLogSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 00
	 * 	分页查询
	 * </pre>
	 * 
	 * @param accessLog
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(AccessLog accessLog,Page<AccessLog> page,HttpServletRequest request){
		try {
			request.setAttribute("page", accessLogService.findByPage(accessLog, page));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "access/accessLogList";
	}

	/**
	 * 
	 * <pre>
	 * 	2017-04-13 00
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param accessLogId
	 * @param request
	 * @return
	 */
	@RequestMapping("/accessLog")
	public String accessLog(String accessLogId,HttpServletRequest request){
		try {
			if(ValidateUtils.isNotEmpty(accessLogId)){
				AccessLog accessLog = accessLogService.getById(accessLogId);
				request.setAttribute("accessLog", accessLog);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "access/accessLog";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 00
	 * 	保存
	 * </pre>
	 * 
	 * @param accessLog
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(AccessLog accessLog){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(accessLog.getAccessLogId())){
				
				accessLogService.update(accessLog);
			}
			// 新增
			else{
				
				accessLogService.add(accessLog);
			}
			json.put("result", "save_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "save_fail");
		}
		
		return json.toString();
	}
	
	
}
