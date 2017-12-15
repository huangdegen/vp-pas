package com.idp.web.projectdetail.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.idp.common.base.BaseEntity;

/**
 * 项目详情实体类.
 * <p>
 * <pre>
 * 	历史记录：
 * 	2017-09-04 Mrli
 * 	新建文件
 * </pre>
 *
 * @author <pre>
 *                                                         SD
 *                                                         	Mrli
 *                                                         PG
 *                                                         	Mrli
 *                                                         UT
 *
 *                                                         MA
 *                                                         </pre>
 * @version $Rev$
 *          <p>
 *          <p/> $Id$
 */
public class VpProjectDetail extends BaseEntity implements Serializable {

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
     * 项目名称
     */
    private String projectName;
    /**
     * 项目经理
     */
    private String projectManger;

    private String oldProjectManger;

    /**
     * 项目成员
     */
    private String projectMember;
    /**
     * 项目所属地址
     */
    private String projectAddress;
    /**
     * 项目描述
     */
    private String projectDescribe;
    /**
     * 项目起始时间
     */
    private Date projectStartTime;
    /**
     * 项目结束时间
     */
    private Date projectEndTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 项目修改时间
     */
    private Date updateTime;

    private String parentId;

    private Integer projectProgress;


    public Integer getProjectProgress() {
        return projectProgress;
    }

    public void setProjectProgress(Integer projectProgress) {
        this.projectProgress = projectProgress;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


    public String getOldProjectManger() {
        return oldProjectManger;
    }

    public void setOldProjectManger(String oldProjectManger) {
        this.oldProjectManger = oldProjectManger;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  id
     */
    public String getId() {
        return this.id;
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
     * @return: String  项目名称
     */
    public String getProjectName() {
        return this.projectName;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  项目经理
     */
    public String getProjectManger() {
        return this.projectManger;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  项目经理
     */
    public void setProjectManger(String projectManger) {
        this.projectManger = projectManger;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  项目成员
     */
    public String getProjectMember() {
        return this.projectMember;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  项目成员
     */
    public void setProjectMember(String projectMember) {
        this.projectMember = projectMember;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  项目所属地址
     */
    public String getProjectAddress() {
        return this.projectAddress;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  项目所属地址
     */
    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  项目描述
     */
    public String getProjectDescribe() {
        return this.projectDescribe;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  项目描述
     */
    public void setProjectDescribe(String projectDescribe) {
        this.projectDescribe = projectDescribe;
    }


    public Date getProjectStartTime() {
        return projectStartTime;
    }

    public void setProjectStartTime(Date projectStartTime) {
        this.projectStartTime = projectStartTime;
    }

    public Date getProjectEndTime() {
        return projectEndTime;
    }

    public void setProjectEndTime(Date projectEndTime) {
        this.projectEndTime = projectEndTime;
    }

    /**
     * 方法: 取得Date
     *
     * @return: Date  创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 方法: 设置Date
     *
     * @param: Date  创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 方法: 取得Date
     *
     * @return: Date  项目修改时间
     */
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 方法: 设置Date
     *
     * @param: Date  项目修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}
