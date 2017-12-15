package com.idp.web.log.service;
import com.idp.web.log.entity.UserOpertionsLog;
import java.util.List;

import com.idp.common.persistence.Page;

/**
 * 
 * 审计日志service接口
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
public interface UserOpertionsLogService{
	
 	/**
	 * 
	 * <pre>
	 * 	2017-04-12 ivan
	 * 	分页查询
	 * </pre>
	 * 
	 * @param userOpertionsLog
	 * @param page
	 * @return
	 */
	public Page<UserOpertionsLog> findByPage(UserOpertionsLog userOpertionsLog,Page<UserOpertionsLog> page);
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-12 ivan
	 * 	查询
	 * </pre>
	 * 
	 * @param userOpertionsLog
	 * @return
	 */
	public List<UserOpertionsLog> findBySearch(UserOpertionsLog userOpertionsLog);
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-12 ivan
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param UserOpertionsLog
	 * @return
	 */
	public UserOpertionsLog getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-12 ivan
	 * 	新增
	 * </pre>
	 * 
	 * @param userOpertionsLog
	 */
	public void add(UserOpertionsLog userOpertionsLog);
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-12 ivan
	 * 	修改
	 * </pre>
	 * 
	 * @param userOpertionsLog
	 */
	public void update(UserOpertionsLog userOpertionsLog);
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-12 ivan
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(String id);
}
