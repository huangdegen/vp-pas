package com.idp.web.reporting.service;
import com.idp.web.assessment.entity.Assessment;
import com.idp.web.reporting.entity.VpReporting;
import java.util.List;

import com.idp.common.persistence.Page;
import com.idp.web.reporting.entity.WorkingHoursStatistical;

/**
 *
 * 工时填报service接口
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
public interface VpReportingService{

 	/**
	 *
	 * <pre>
	 * 	2017-07-21 liyi
	 * 	分页查询
	 * </pre>
	 *
	 * @param vpReporting
	 * @param page
	 * @return
	 */
	public Page<VpReporting> findByPage(VpReporting vpReporting, Page<VpReporting> page);



	public List<VpReporting> findExportAll(VpReporting vpReporting);
	/**
	 *
	 * <pre>
	 * 	2017-07-21 liyi
	 * 	查询
	 * </pre>
	 *
	 * @param vpReporting
	 * @return
	 */
	public List<VpReporting> findBySearch(VpReporting vpReporting);

	/**
	 *
	 * <pre>
	 * 	2017-07-21 liyi
	 * 	通过ID查询
	 * </pre>
	 *
	 * @param VpReporting
	 * @return
	 */
	public VpReporting getById(String id);

	/**
	 *
	 * <pre>
	 * 	2017-07-21 liyi
	 * 	新增
	 * </pre>
	 *
	 * @param vpReporting
	 */
	public void add(VpReporting vpReporting);

	/**
	 *
	 * <pre>
	 * 	2017-07-21 liyi
	 * 	修改
	 * </pre>
	 *
	 * @param vpReporting
	 */
	public void update(VpReporting vpReporting);

	/**
	 *
	 * <pre>
	 * 	2017-07-21 liyi
	 * 	删除
	 * </pre>
	 *
	 * @param id
	 */
	public void delete(String id);


	Integer getSumReportingTime(VpReporting vpReporting);

	/***
	 * 导出个人工时百分比
	 * @param workingHoursStatistical
     * @return
     */
	List<WorkingHoursStatistical> statisticalHours(WorkingHoursStatistical workingHoursStatistical);
}
