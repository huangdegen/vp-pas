package com.idp.web.digitallog.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;
import com.idp.web.digitallog.dao.DigitalBackupLogDao;
import com.idp.web.digitallog.entity.DigitalBackupLog;
import com.idp.web.digitallog.service.DigitalBackupLogService;

/**
 * 
 * 数据库备份日志service实现类
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
@Service("digitalBackupLogService")
public class DigitalBackupLogServiceImpl implements DigitalBackupLogService {

	@Resource
	private DigitalBackupLogDao digitalBackupLogDao;
	
	@Override
	public Page<DigitalBackupLog> findByPage(DigitalBackupLog digitalBackupLog, Page<DigitalBackupLog> page) {

		page.setResult(digitalBackupLogDao.find(digitalBackupLog, page));
		
		return page;
	}
	
	@Override
	public List<DigitalBackupLog> findBySearch(DigitalBackupLog digitalBackupLog) {

		return digitalBackupLogDao.find(digitalBackupLog);
	}
	
	@Override
	public DigitalBackupLog getById(String id) {

		return digitalBackupLogDao.getById(id);
	}

	@Override
	public void add(DigitalBackupLog digitalBackupLog) {

		digitalBackupLog.setId(ResourceUtils.getUUID());
		digitalBackupLogDao.add(digitalBackupLog);
	}
	
	@Override
	public void update(DigitalBackupLog digitalBackupLog) {

		digitalBackupLogDao.update(digitalBackupLog);
	}

	@Override
	public void delete(String id) {

		digitalBackupLogDao.delete(id);
	}
 	
}