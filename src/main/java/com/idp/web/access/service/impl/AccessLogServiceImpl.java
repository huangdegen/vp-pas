package com.idp.web.access.service.impl;
import com.idp.web.access.service.AccessLogService;
import com.idp.web.access.dao.AccessLogDao;
import com.idp.web.access.entity.AccessLog;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;

/**
 * 
 * 访问日志service实现类
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
@Service("accessLogService")
public class AccessLogServiceImpl implements AccessLogService {

	@Resource
	private AccessLogDao accessLogDao;
	
	@Override
	public Page<AccessLog> findByPage(AccessLog accessLog, Page<AccessLog> page) {

		page.setResult(accessLogDao.find(accessLog, page));
		
		return page;
	}
	
	@Override
	public List<AccessLog> findBySearch(AccessLog accessLog) {

		return accessLogDao.find(accessLog);
	}
	
	@Override
	public AccessLog getById(String accessLogId) {

		return accessLogDao.getById(accessLogId);
	}

	@Override
	public void add(AccessLog accessLog) {

		accessLog.setAccessLogId(ResourceUtils.getUUID());
		accessLogDao.add(accessLog);
	}
	
	@Override
	public void update(AccessLog accessLog) {

		accessLogDao.update(accessLog);
	}

}