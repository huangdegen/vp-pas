package com.idp.web.assessment.service.impl;

import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;
import com.idp.web.assessment.dao.AssessmentDao;
import com.idp.web.assessment.entity.Assessment;
import com.idp.web.assessment.service.AssessmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * 考核评分service实现类
 * 
 * <pre>
 * 	历史记录：
 * 	2017-07-06 mrli
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	mrli
 * PG
 *	mrli
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
@Service("assessmentService")
public class AssessmentServiceImpl implements AssessmentService {

	@Resource
	private AssessmentDao assessmentDao;
	
	@Override
	public Page<Assessment> findByPage(Assessment assessment, Page<Assessment> page) {
		page.setResult(assessmentDao.find(assessment, page));
		return page;
	}

	@Override
	public List<Assessment> findExport(Assessment assessment) {
		return assessmentDao.find(assessment);
	}

	@Override
	public List<Assessment> findByPageStatisticsMonthExport(Assessment assessment) {
		return assessmentDao.findByPageStatisticsMonthExport(assessment);
	}

	@Override
	public List<Assessment> findBySearch(Assessment assessment) {
		return assessmentDao.find(assessment);
	}


	@Override
	public Assessment getById(Integer id) {
		return assessmentDao.getById(id);
	}

	@Override
	public void add(Assessment assessment) {
		assessment.setId(ResourceUtils.getUUID());
		assessmentDao.add(assessment);
	}
	
	@Override
	public void update(Assessment assessment) {
		assessmentDao.update(assessment);
	}

	@Override
	public void updateNotNull(Assessment assessment) {
		assessmentDao.updateNotNull(assessment);
	}

	@Override
	public void delete(Integer id) {
		assessmentDao.delete(id);
	}

	@Override
	public void del(String id) {
		assessmentDao.del(id);
	}

	@Override
	public Assessment getMentById(String id) {
		return assessmentDao.getMentById(id);
	}

	@Override
	public Assessment getMentByIds(String id) {
		return assessmentDao.getMentByIds(id);
	}

	@Override
	public int getByUserIdAssessment(String userId, String pasMonth) {
		return assessmentDao.getByUserIdAssessment(userId,pasMonth);
	}

}