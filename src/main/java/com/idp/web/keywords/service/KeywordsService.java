package com.idp.web.keywords.service;
import com.idp.web.keywords.entity.Keywords;
import java.util.List;

import com.idp.common.persistence.Page;

/**
 * 
 * 关键词过滤service接口
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
public interface KeywordsService{
	
 	/**
	 * 
	 * <pre>
	 * 	2017-04-13 java23
	 * 	分页查询
	 * </pre>
	 * 
	 * @param keywords
	 * @param page
	 * @return
	 */
	public Page<Keywords> findByPage(Keywords keywords,Page<Keywords> page);
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 java23
	 * 	查询
	 * </pre>
	 * 
	 * @param keywords
	 * @return
	 */
	public List<Keywords> findBySearch(Keywords keywords);
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 java23
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param Keywords
	 * @return
	 */
	public Keywords getById(String keywordsId);
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 java23
	 * 	新增
	 * </pre>
	 * 
	 * @param keywords
	 */
	public void add(Keywords keywords);
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 java23
	 * 	修改
	 * </pre>
	 * 
	 * @param keywords
	 */
	public void update(Keywords keywords);
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 java23
	 * 	删除
	 * </pre>
	 * 
	 * @param keywordsId
	 */
	public void delete(String keywordsId);
}
