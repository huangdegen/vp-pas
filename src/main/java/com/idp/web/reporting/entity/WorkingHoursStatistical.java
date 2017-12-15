package com.idp.web.reporting.entity;

import com.idp.common.util.excle.ExcelField;

import java.io.Serializable;

/**
 * Created by 李怡 on 2017/8/14.
 */
public class WorkingHoursStatistical implements Serializable {

    /**
     * 用户名称
     */
    @ExcelField(title = "用户名称", align = 2, sort = 1)
    private String userName;

    /**
     * 次数（天数）
     */
    @ExcelField(title = "天数", align = 2, sort = 2)
    private String days;

    /**
     * 用户做该项目总工时
     */
    @ExcelField(title = "用户做该项目总工时", align = 2, sort = 3)
    private String totalWorkingHoursUserName;

    /**
     * 项目名称
     */
    @ExcelField(title = "项目名称", align = 2, sort = 4)
    private String projectName;

    /**
     * 项目编码
     */
    @ExcelField(title = "项目编码", align = 2, sort = 5)
    private String projectsCode;

    /**
     * 项目总工时
     */
    @ExcelField(title = "项目总工时", align = 2, sort = 6)
    private String totalWorkingHoursProject;

    /**
     * 用户占该项目工时百分比
     */
    @ExcelField(title = "用户占该项目工时百分比", align = 2, sort = 7)
    private String percentage;


    /**
     * 当月项目人力总系数
     */
    @ExcelField(title = "当月项目人力总系数", align = 2, sort = 8)
    private String totalMonthProjectCoefficient;

    public String getTotalMonthProjectCoefficient() {
        return totalMonthProjectCoefficient;
    }

    public void setTotalMonthProjectCoefficient(String totalMonthProjectCoefficient) {
        this.totalMonthProjectCoefficient = totalMonthProjectCoefficient;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTotalWorkingHoursUserName() {
        return totalWorkingHoursUserName;
    }

    public void setTotalWorkingHoursUserName(String totalWorkingHoursUserName) {
        this.totalWorkingHoursUserName = totalWorkingHoursUserName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTotalWorkingHoursProject() {
        return totalWorkingHoursProject;
    }

    public void setTotalWorkingHoursProject(String totalWorkingHoursProject) {
        this.totalWorkingHoursProject = totalWorkingHoursProject;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getProjectsCode() {
        return projectsCode;
    }

    public void setProjectsCode(String projectsCode) {
        this.projectsCode = projectsCode;
    }
}
