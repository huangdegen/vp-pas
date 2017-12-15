package com.idp.web.reporting.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.idp.common.base.BaseEntity;
import com.idp.common.util.excle.ExcelField;

/**
 * 工时填报实体类.
 * <p>
 * <pre>
 * 	历史记录：
 * 	2017-07-21 liyi
 * 	新建文件
 */
public class VpReporting extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户名称
     */
    @ExcelField(title = "用户名称", align = 2, sort = 1)
    private String reportingName;
    /**
     * 填报日期
     */
    @ExcelField(title = "填报日期", align = 2, sort = 2)
    private Date reportingDate;
    /**
     * 项目名称
     */
    @ExcelField(title = "项目名称", align = 2, sort = 6)
    private String reportingProject;


    /**
     * 项目编码
     */
    @ExcelField(title = "项目编码", align = 2, sort = 7)
    private String projectsCode;

    /**
     * 工作内容
     */
    @ExcelField(title = "工作内容", align = 2, sort = 8)
    private String reportingContent;
    /**
     * 工作时长
     */
    @ExcelField(title = "工作时长", align = 2, sort = 9)
    private Integer reportingTime;

    /**
     * 部门id
     */
    private String orgId;
    /**
     * 部门名称
     */
    @ExcelField(title = "部门名称", align = 2, sort = 5)
    private String orgName;
    /**
     * 开始时间
     */
    @ExcelField(title = "开始时间", align = 2, sort = 3)
    private String startTime;
    /**
     * 结束时间
     */
    @ExcelField(title = "结束时间", align = 2, sort = 4)
    private String endTime;

    /**
     * 是否提交 0暂存 1提交
     */
    private String isCommit;

    /**
     * 填报日期开始
     */
    private Date reportingDateStart;
    /**
     * 填报日期结束
     */
    private Date reportingDateEnd;


    private String userCode;

    /**
     * 方法: 取得String
     *
     * @return: String  id
     */
    public String getId() {
        return this.id;
    }


    public String getIsCommit() {
        return isCommit;
    }

    public void setIsCommit(String isCommit) {
        this.isCommit = isCommit;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  用户ID
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  用户名称
     */
    public String getReportingName() {
        return this.reportingName;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  用户名称
     */
    public void setReportingName(String reportingName) {
        this.reportingName = reportingName;
    }

    /**
     * 方法: 取得Date
     *
     * @return: Date  填报日期
     */
    public Date getReportingDate() {
        return this.reportingDate;
    }

    /**
     * 方法: 设置Date
     *
     * @param: Date  填报日期
     */
    public void setReportingDate(Date reportingDate) {
        this.reportingDate = reportingDate;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  项目名称
     */
    public String getReportingProject() {
        return this.reportingProject;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  项目名称
     */
    public void setReportingProject(String reportingProject) {
        this.reportingProject = reportingProject;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  工作内容
     */
    public String getReportingContent() {
        return this.reportingContent;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  工作内容
     */
    public void setReportingContent(String reportingContent) {
        this.reportingContent = reportingContent;
    }

    /**
     * 方法: 取得Integer
     *
     * @return: Integer  工作时长
     */
    public Integer getReportingTime() {
        return this.reportingTime;
    }

    /**
     * 方法: 设置Integer
     *
     * @param: Integer  工作时长
     */
    public void setReportingTime(Integer reportingTime) {
        this.reportingTime = reportingTime;
    }


    /**
     * 方法: 取得Date
     *
     * @return: Date  填报日期开始
     */
    public Date getReportingDateStart() {
        return this.reportingDateStart;
    }

    /**
     * 方法: 设置Date
     *
     * @param: Date  填报日期开始
     */
    public void setReportingDateStart(Date reportingDateStart) {
        this.reportingDateStart = reportingDateStart;
    }

    /**
     * 方法: 取得Date
     *
     * @return: Date  填报日期结束
     */
    public Date getReportingDateEnd() {
        return this.reportingDateEnd;
    }

    /**
     * 方法: 设置Date
     *
     * @param: Date  填报日期结束
     */
    public void setReportingDateEnd(Date reportingDateEnd) {
        this.reportingDateEnd = reportingDateEnd;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getProjectsCode() {
        return projectsCode;
    }

    public void setProjectsCode(String projectsCode) {
        this.projectsCode = projectsCode;
    }
}
