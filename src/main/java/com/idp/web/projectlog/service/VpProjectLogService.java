package com.idp.web.projectlog.service;
import com.idp.web.projectlog.entity.VpProjectLog;
import java.util.List;

import com.idp.common.persistence.Page;

/**
 * 
 * 项目管理日志service接口
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
public interface VpProjectLogService{
	
 	/**
	 * 
	 * <pre>
	 * 	2017-09-05 mrLi
	 * 	分页查询
	 * </pre>
	 * 
	 * @param vpProjectLog
	 * @param page
	 * @return
	 */
	public Page<VpProjectLog> findByPage(VpProjectLog vpProjectLog, Page<VpProjectLog> page);
	
	/**
	 * 
	 * <pre>
	 * 	2017-09-05 mrLi
	 * 	查询
	 * </pre>
	 * 
	 * @param vpProjectLog
	 * @return
	 */
	public List<VpProjectLog> findBySearch(VpProjectLog vpProjectLog);
	
	/**
	 * 
	 * <pre>
	 * 	2017-09-05 mrLi
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param VpProjectLog
	 * @return
	 */
	public VpProjectLog getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2017-09-05 mrLi
	 * 	新增
	 * </pre>
	 * 
	 * @param vpProjectLog
	 */
	public void add(VpProjectLog vpProjectLog);
	
	/**
	 * 
	 * <pre>
	 * 	2017-09-05 mrLi
	 * 	修改
	 * </pre>
	 * 
	 * @param vpProjectLog
	 */
	public void update(VpProjectLog vpProjectLog);
	
	/**
	 * 
	 * <pre>
	 * 	2017-09-05 mrLi
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(String id);
}
