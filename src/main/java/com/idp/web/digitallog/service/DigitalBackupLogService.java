package com.idp.web.digitallog.service;
import java.util.List;

import com.idp.common.persistence.Page;
import com.idp.web.digitallog.entity.DigitalBackupLog;

/**
 * 
 * 数据库备份日志service接口
 * 
 * <pre>
 * 	历史记录：
 * 	2017-06-22 123
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	123
 * PG
 *	123
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
public interface DigitalBackupLogService{
	
 	/**
	 * 
	 * <pre>
	 * 	2017-06-22 123
	 * 	分页查询
	 * </pre>
	 * 
	 * @param digitalBackupLog
	 * @param page
	 * @return
	 */
	public Page<DigitalBackupLog> findByPage(DigitalBackupLog digitalBackupLog,Page<DigitalBackupLog> page);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-22 123
	 * 	查询
	 * </pre>
	 * 
	 * @param digitalBackupLog
	 * @return
	 */
	public List<DigitalBackupLog> findBySearch(DigitalBackupLog digitalBackupLog);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-22 123
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param DigitalBackupLog
	 * @return
	 */
	public DigitalBackupLog getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-22 123
	 * 	新增
	 * </pre>
	 * 
	 * @param digitalBackupLog
	 */
	public void add(DigitalBackupLog digitalBackupLog);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-22 123
	 * 	修改
	 * </pre>
	 * 
	 * @param digitalBackupLog
	 */
	public void update(DigitalBackupLog digitalBackupLog);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-22 123
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(String id);
}
