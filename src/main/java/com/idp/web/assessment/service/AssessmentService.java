package com.idp.web.assessment.service;
import com.idp.web.assessment.entity.Assessment;
import java.util.List;

import com.idp.common.persistence.Page;

/**
 * 
 * 考核评分service接口
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
public interface AssessmentService{
	
 	/**
	 * 
	 * <pre>
	 * 	2017-07-06 mrli
	 * 	分页查询
	 * </pre>
	 * 
	 * @param assessment
	 * @param page
	 * @return
	 */
	public Page<Assessment> findByPage(Assessment assessment, Page<Assessment> page);


	public List<Assessment> findExport(Assessment assessment);

	public List<Assessment> findByPageStatisticsMonthExport(Assessment assessment);
	
	/**
	 * 
	 * <pre>
	 * 	2017-07-06 mrli
	 * 	查询
	 * </pre>
	 * 
	 * @param assessment
	 * @return
	 */
	public List<Assessment> findBySearch(Assessment assessment);
	
	/**
	 * 
	 * <pre>
	 * 	2017-07-06 mrli
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param Assessment
	 * @return
	 */
	public Assessment getById(Integer id);
	
	/**
	 * 
	 * <pre>
	 * 	2017-07-06 mrli
	 * 	新增
	 * </pre>
	 * 
	 * @param assessment
	 */
	public void add(Assessment assessment);
	
	/**
	 * 
	 * <pre>
	 * 	2017-07-06 mrli
	 * 	修改
	 * </pre>
	 * 
	 * @param assessment
	 */
	public void update(Assessment assessment);



	public void updateNotNull(Assessment assessment);
	/**
	 * 
	 * <pre>
	 * 	2017-07-06 mrli
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	public void del(String id);

	public Assessment getMentById(String id);

	public Assessment getMentByIds(String id);

	public int getByUserIdAssessment(String userId,String pasMonth);

}
