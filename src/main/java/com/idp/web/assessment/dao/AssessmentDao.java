package com.idp.web.assessment.dao;

import com.idp.common.base.BaseDao;
import com.idp.web.assessment.entity.Assessment;
import com.idp.web.system.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 考核评分dao接口.
 * 历史记录：
 * 2017-07-06 mrli
 * 新建文件
 */
public interface AssessmentDao extends BaseDao<Assessment, Integer> {


    Assessment getMentById(String id);

    Assessment getMentByIds(String id);

    int getByUserIdAssessment(@Param("userId") String userId, @Param("pasMonth") String pasMonth);

    SysUser getUserById(String id);

    void del(String id);

    List<Assessment> findByPageStatisticsMonthExport(Assessment assessment);


}