package com.idp.web.projectlog.controller;
import com.idp.common.constant.AssessmentConstant;
import com.idp.web.projectlog.entity.VpProjectLog;
import com.idp.web.projectlog.service.VpProjectLogService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.idp.web.system.entity.SysDictionary;
import com.idp.web.system.entity.SysUser;
import com.idp.web.system.service.SysDictionaryService;
import com.idp.web.system.service.SysUserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idp.common.base.BaseController;
import com.idp.common.persistence.Page;
import com.idp.common.util.ValidateUtils;

import net.sf.json.JSONObject;

import java.util.List;

/**
 * 
 * 项目管理日志controller
 * 
 * <pre>
 * 	历史记录：
 * 	2017-09-05 mrLi
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	mrLi
 * PG
 *	mrLi
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
@RequestMapping("/vpProjectLog")
public class VpProjectLogController extends BaseController {

	private Logger logger = Logger.getLogger(VpProjectLogController.class);

	@Resource
	private VpProjectLogService vpProjectLogService;
	@Resource
	private SysDictionaryService sysDictionaryService;

	@Resource
	private SysUserService sysUserService;

	/**
	 * 
	 * <pre>
	 * 	2017-09-05 mrLi
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(){

		return "projectlog/vpProjectLogSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-09-05 mrLi
	 * 	分页查询
	 * </pre>
	 * 
	 * @param vpProjectLog
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(VpProjectLog vpProjectLog,Page<VpProjectLog> page,HttpServletRequest request){
		
		try {
			SysDictionary sysDictionary = sysDictionaryService.getByCode(AssessmentConstant.DICT_PROJECT);
			SysDictionary address = sysDictionaryService.getByCode(AssessmentConstant.DICT_ADDRESS);
			List<SysUser> userList = sysUserService.findBySearch(new SysUser());
			request.setAttribute("userList", userList);
			request.setAttribute("address", address.getChildren());
			request.setAttribute("dictProject", sysDictionary.getChildren());
			request.setAttribute("page", vpProjectLogService.findByPage(vpProjectLog, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "projectlog/vpProjectLogList";
	}

	/**
	 * 
	 * <pre>
	 * 	2017-09-05 mrLi
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/vpProjectLog")
	public String vpProjectLog(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				VpProjectLog vpProjectLog = vpProjectLogService.getById(id);
				request.setAttribute("vpProjectLog", vpProjectLog);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "projectlog/vpProjectLog";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-09-05 mrLi
	 * 	保存
	 * </pre>
	 * 
	 * @param vpProjectLog
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(VpProjectLog vpProjectLog){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(vpProjectLog.getId())){
				
				vpProjectLogService.update(vpProjectLog);
			}
			// 新增
			else{
				
				vpProjectLogService.add(vpProjectLog);
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
	 * 	2017-09-05 mrLi
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
			
			vpProjectLogService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
