package com.idp.web.log.controller;
import com.idp.web.log.entity.UserOpertionsLog;
import com.idp.web.log.service.UserOpertionsLogService;
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
 * 审计日志controller
 * 
 * <pre>
 * 	历史记录：
 * 	2017-04-12 ivan
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	ivan
 * PG
 *	ivan
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
@RequestMapping("/userOpertionsLog")
public class UserOpertionsLogController extends BaseController {

	private Logger logger = Logger.getLogger(UserOpertionsLogController.class);

	@Resource
	private UserOpertionsLogService userOpertionsLogService;
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-12 ivan
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(){
		
		return "log/userOpertionsLogSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-12 ivan
	 * 	分页查询
	 * </pre>
	 * 
	 * @param userOpertionsLog
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(UserOpertionsLog userOpertionsLog,Page<UserOpertionsLog> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", userOpertionsLogService.findByPage(userOpertionsLog, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "log/userOpertionsLogList";
	}

	/**
	 * 
	 * <pre>
	 * 	2017-04-12 ivan
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/userOpertionsLog")
	public String userOpertionsLog(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				UserOpertionsLog userOpertionsLog = userOpertionsLogService.getById(id);
				request.setAttribute("userOpertionsLog", userOpertionsLog);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "log/userOpertionsLog";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-12 ivan
	 * 	保存
	 * </pre>
	 * 
	 * @param userOpertionsLog
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(UserOpertionsLog userOpertionsLog){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(userOpertionsLog.getId())){
				
				userOpertionsLogService.update(userOpertionsLog);
			}
			// 新增
			else{
				
				userOpertionsLogService.add(userOpertionsLog);
			}
			json.put("result", "save_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "save_fail");
		}
		
		return json.toString();
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-12 ivan
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id){
		
		JSONObject json = new JSONObject();
		
		try {
			
			userOpertionsLogService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
