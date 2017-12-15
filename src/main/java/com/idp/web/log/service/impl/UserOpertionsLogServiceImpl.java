package com.idp.web.log.service.impl;
import com.idp.web.log.service.UserOpertionsLogService;
import com.idp.web.log.dao.UserOpertionsLogDao;
import com.idp.web.log.entity.UserOpertionsLog;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;

/**
 * 
 * 审计日志service实现类
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
@Service("userOpertionsLogService")
public class UserOpertionsLogServiceImpl implements UserOpertionsLogService {

	@Resource
	private UserOpertionsLogDao userOpertionsLogDao;
	
	@Override
	public Page<UserOpertionsLog> findByPage(UserOpertionsLog userOpertionsLog, Page<UserOpertionsLog> page) {

		page.setResult(userOpertionsLogDao.find(userOpertionsLog, page));
		
		return page;
	}
	
	@Override
	public List<UserOpertionsLog> findBySearch(UserOpertionsLog userOpertionsLog) {

		return userOpertionsLogDao.find(userOpertionsLog);
	}
	
	@Override
	public UserOpertionsLog getById(String id) {

		return userOpertionsLogDao.getById(id);
	}

	@Override
	public void add(UserOpertionsLog userOpertionsLog) {

		userOpertionsLog.setId(ResourceUtils.getUUID());
		userOpertionsLogDao.add(userOpertionsLog);
	}
	
	@Override
	public void update(UserOpertionsLog userOpertionsLog) {

		userOpertionsLogDao.update(userOpertionsLog);
	}

	@Override
	public void delete(String id) {

		userOpertionsLogDao.delete(id);
	}
 	
}