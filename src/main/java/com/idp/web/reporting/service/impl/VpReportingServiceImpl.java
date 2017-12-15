package com.idp.web.reporting.service.impl;
import com.idp.web.assessment.entity.Assessment;
import com.idp.web.reporting.entity.WorkingHoursStatistical;
import com.idp.web.reporting.service.VpReportingService;
import com.idp.web.reporting.dao.VpReportingDao;
import com.idp.web.reporting.entity.VpReporting;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;

/**
 * 
 * 工时填报service实现类
 * 
 * <pre>
 * 	历史记录：
 * 	2017-07-21 liyi
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	liyi
 * PG
 *	liyi
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
@Service("vpReportingService")
public class VpReportingServiceImpl implements VpReportingService {

	@Resource
	private VpReportingDao vpReportingDao;
	
	@Override
	public Page<VpReporting> findByPage(VpReporting vpReporting, Page<VpReporting> page) {

		page.setResult(vpReportingDao.find(vpReporting, page));
		
		return page;
	}
	@Override
	public List<VpReporting> findExportAll(VpReporting vpReporting) {
		return vpReportingDao.findExportAll(vpReporting);
	}
	
	@Override
	public List<VpReporting> findBySearch(VpReporting vpReporting) {

		return vpReportingDao.find(vpReporting);
	}
	
	@Override
	public VpReporting getById(String id) {

		return vpReportingDao.getById(id);
	}

	@Override
	public void add(VpReporting vpReporting) {

		vpReporting.setId(ResourceUtils.getUUID());
		vpReportingDao.add(vpReporting);
	}
	
	@Override
	public void update(VpReporting vpReporting) {

		vpReportingDao.update(vpReporting);
	}

	@Override
	public void delete(String id) {

		vpReportingDao.delete(id);
	}

	@Override
	public Integer getSumReportingTime(VpReporting vpReporting) {
		return vpReportingDao.getSumReportingTime(vpReporting);
	}

	@Override
	public List<WorkingHoursStatistical> statisticalHours(WorkingHoursStatistical workingHoursStatistical) {
		return vpReportingDao.statisticalHours(workingHoursStatistical);
	}


}