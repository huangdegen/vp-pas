package com.idp.web.keywords.controller;
import com.idp.web.keywords.entity.Keywords;
import com.idp.web.keywords.service.KeywordsService;

import java.util.Date;

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
 * 关键词过滤controller
 * 
 * <pre>
 * 	历史记录：
 * 	2017-04-13 java23
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	java23
 * PG
 *	java23
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
@RequestMapping("/keywords")
public class KeywordsController extends BaseController {

	private Logger logger = Logger.getLogger(KeywordsController.class);

	@Resource
	private KeywordsService keywordsService;
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 java23
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(){
		
		return "keywords/keywordsSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 java23
	 * 	分页查询
	 * </pre>
	 * 
	 * @param keywords
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Keywords keywords,Page<Keywords> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", keywordsService.findByPage(keywords, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "keywords/keywordsList";
	}

	/**
	 * 
	 * <pre>
	 * 	2017-04-13 java23
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param keywordsId
	 * @param request
	 * @return
	 */
	@RequestMapping("/keywords")
	public String keywords(String keywordsId,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(keywordsId)){
				
				Keywords keywords = keywordsService.getById(keywordsId);
				request.setAttribute("keywords", keywords);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "keywords/keywords";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 java23
	 * 	保存
	 * </pre>
	 * 
	 * @param keywords
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(Keywords keywords){
		
		JSONObject json = new JSONObject();
		
		try {
			keywords.setKeywordsTime(new Date());
			// 修改
			if(ValidateUtils.isNotEmpty(keywords.getKeywordsId())){
				
				keywordsService.update(keywords);
			}
			// 新增
			else{
				
				keywordsService.add(keywords);
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
	 * 	2017-04-13 java23
	 * 	删除
	 * </pre>
	 * 
	 * @param keywordsId
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String keywordsId){
		
		JSONObject json = new JSONObject();
		
		try {
			
			keywordsService.delete(keywordsId);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
