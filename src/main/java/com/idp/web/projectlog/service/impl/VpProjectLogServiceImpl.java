package com.idp.web.projectlog.service.impl;
import com.idp.web.projectlog.service.VpProjectLogService;
import com.idp.web.projectlog.dao.VpProjectLogDao;
import com.idp.web.projectlog.entity.VpProjectLog;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;

/**
 * 
 * 项目管理日志service实现类
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
@Service("vpProjectLogService")
public class VpProjectLogServiceImpl implements VpProjectLogService {

	@Resource
	private VpProjectLogDao vpProjectLogDao;
	
	@Override
	public Page<VpProjectLog> findByPage(VpProjectLog vpProjectLog, Page<VpProjectLog> page) {

		page.setResult(vpProjectLogDao.find(vpProjectLog, page));
		
		return page;
	}
	
	@Override
	public List<VpProjectLog> findBySearch(VpProjectLog vpProjectLog) {

		return vpProjectLogDao.find(vpProjectLog);
	}
	
	@Override
	public VpProjectLog getById(String id) {

		return vpProjectLogDao.getById(id);
	}

	@Override
	public void add(VpProjectLog vpProjectLog) {

		vpProjectLog.setId(ResourceUtils.getUUID());
		vpProjectLogDao.add(vpProjectLog);
	}
	
	@Override
	public void update(VpProjectLog vpProjectLog) {

		vpProjectLogDao.update(vpProjectLog);
	}

	@Override
	public void delete(String id) {

		vpProjectLogDao.delete(id);
	}
 	
}