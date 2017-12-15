package com.idp.web.reporting.dao;

import com.idp.web.reporting.entity.VpReporting;
import com.idp.common.base.BaseDao;
import com.idp.web.reporting.entity.WorkingHoursStatistical;
import java.util.List;

/**
 * 
 * 工时填报dao接口.
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
public interface VpReportingDao extends BaseDao<VpReporting, String> {

    Integer getSumReportingTime(VpReporting vpReporting);

    List<WorkingHoursStatistical> statisticalHours(WorkingHoursStatistical workingHoursStatistical);

    List<VpReporting> findExportAll(VpReporting vpReporting);








}