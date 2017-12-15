package com.idp.web.access.service;
import com.idp.web.access.entity.AccessLog;
import java.util.List;

import com.idp.common.persistence.Page;

/**
 * 
 * 访问日志service接口
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
public interface AccessLogService{
	
 	/**
	 * 
	 * <pre>
	 * 	2017-04-13 00
	 * 	分页查询
	 * </pre>
	 * 
	 * @param accessLog
	 * @param page
	 * @return
	 */
	public Page<AccessLog> findByPage(AccessLog accessLog,Page<AccessLog> page);
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 00
	 * 	查询
	 * </pre>
	 * 
	 * @param accessLog
	 * @return
	 */
	public List<AccessLog> findBySearch(AccessLog accessLog);
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 00
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param AccessLog
	 * @return
	 */
	public AccessLog getById(String accessLogId);
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 00
	 * 	新增
	 * </pre>
	 * 
	 * @param accessLog
	 */
	public void add(AccessLog accessLog);
	
	/**
	 * 
	 * <pre>
	 * 	2017-04-13 00
	 * 	修改
	 * </pre>
	 * 
	 * @param accessLog
	 */
	public void update(AccessLog accessLog);
	
}
