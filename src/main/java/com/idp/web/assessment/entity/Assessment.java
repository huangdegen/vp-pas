package com.idp.web.assessment.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.idp.common.base.BaseEntity;
import com.idp.common.util.excle.ExcelField;

/**
 * 考核评分实体类.
 * <p>
 * <pre>
 * 	历史记录：
 * 	2017-07-06 mrli
 * 	新建文件
 * </pre>
 *
 * @author <pre>
 *                                                                         SD
 *                                                                         	mrli
 *                                                                         PG
 *                                                                         	mrli
 *                                                                         UT
 *
 *                                                                         MA
 *                                                                         </pre>
 * @version $Rev$
 *          <p>
 *          <p/> $Id$
 */
public class Assessment extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;
    /**
     * 用户id
     */

    private String userId;
    /**
     * 员工名称
     */
    @ExcelField(title = "名称", align = 2, sort = 1)
    private String userName;
    /**
     * 部门id
     */
    private String orgId;
    /**
     * 部门名称
     */
    @ExcelField(title = "部门名称", align = 2, sort = 2)
    private String orgName;
    /**
     * 岗位id
     */
    private String roleId;
    /**
     * 岗位名称
     */
    @ExcelField(title = "岗位名称", align = 2, sort = 3)
    private String roleName;
    /**
     * 考核月份
     */
    @ExcelField(title = "考核月份", align = 2, sort = 4)
    private String pasMonth;
    /**
     * 员工地址
     */
    @ExcelField(title = "地址", align = 2, sort = 5)
    private String address;
    /**
     * 员工是否转正
     */
    @ExcelField(title = "是否转正", align = 2, sort = 6)
    private String rotation;

    /**
     * 项目编码
     */
    @ExcelField(title = "项目编码", align = 2, sort = 8)
    private String projectsCode;

    /**
     * 项目名称
     */
    @ExcelField(title = "项目名称", align = 2, sort = 7)
    private String projects;
    /**
     * 员工月工作内容
     */
    @ExcelField(title = "员工月工作内容", align = 2, sort = 11)
    private String monthContent;
    /**
     * 团队协作
     */
    @ExcelField(title = "团队协作", align = 2, sort = 9)
    private String teamworkContent;
    /**
     * 团队评分
     */
    @ExcelField(title = "团队评分", align = 2, sort = 10)
    private Integer teamScoring;
    /**
     * 自评分
     */
    @ExcelField(title = "自评分", align = 2, sort = 12)
    private Integer selfScoring;
    /**
     * 领导评分
     */
    @ExcelField(title = "领导评分", align = 2, sort = 13)
    private Integer leadeScore;
    /**
     * 综合评分
     */
    @ExcelField(title = "综合评分", align = 2, sort = 14)
    private double comprehensiveScore;
    /**
     * 评语
     */
    @ExcelField(title = "评语", align = 2, sort = 15)
    private String comment;
    /**
     * 排名
     */

    private Integer ranking;
    /**
     * 删除标识
     */
    private String delFlag;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * updateUser
     */
    private String updateUser;
    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 是否提交 0暂存 1提交
     */
    private String isCommit;

    /**
     * 评分报告权限标识
     */
    private String userCode;

    private String scoreUserId;

    private String userParentCode;

    private String validateCode;

    @ExcelField(title = "排名", align = 2, sort = 16)
    private String rank;


    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getUserParentCode() {
        return userParentCode;
    }

    public void setUserParentCode(String userParentCode) {
        this.userParentCode = userParentCode;
    }

    public String getScoreUserId() {
        return scoreUserId;
    }

    public void setScoreUserId(String scoreUserId) {
        this.scoreUserId = scoreUserId;
    }

    /**
     * 方法: 取得Integer
     *
     * @return: Integer  id
     */
    public String getId() {
        return this.id;
    }

    /**
     * 方法: 设置Integer
     *
     * @param: Integer  id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  用户id
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  员工名称
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  员工名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  部门id
     */
    public String getOrgId() {
        return this.orgId;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  部门id
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  部门名称
     */
    public String getOrgName() {
        return this.orgName;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  部门名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  岗位id
     */
    public String getRoleId() {
        return this.roleId;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  岗位id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  岗位名称
     */
    public String getRoleName() {
        return this.roleName;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  岗位名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  考核月份
     */
    public String getPasMonth() {
        return this.pasMonth;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  考核月份
     */
    public void setPasMonth(String pasMonth) {
        this.pasMonth = pasMonth;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  员工地址
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  员工地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  员工是否转正
     */
    public String getRotation() {
        return this.rotation;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  员工是否转正
     */
    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  项目名称
     */
    public String getProjects() {
        return this.projects;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  项目名称
     */
    public void setProjects(String projects) {
        this.projects = projects;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  员工月工作内容
     */
    public String getMonthContent() {
        return this.monthContent;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  员工月工作内容
     */
    public void setMonthContent(String monthContent) {
        this.monthContent = monthContent;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  团队协作
     */
    public String getTeamworkContent() {
        return this.teamworkContent;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  团队协作
     */
    public void setTeamworkContent(String teamworkContent) {
        this.teamworkContent = teamworkContent;
    }

    /**
     * 方法: 取得Double
     *
     * @return: Double  团队评分
     */
    public Integer getTeamScoring() {
        return this.teamScoring;
    }

    /**
     * 方法: 设置Double
     *
     * @param: Double  团队评分
     */
    public void setTeamScoring(Integer teamScoring) {
        this.teamScoring = teamScoring;
    }

    /**
     * 方法: 取得Double
     *
     * @return: Double  自评分
     */
    public Integer getSelfScoring() {
        return this.selfScoring;
    }

    /**
     * 方法: 设置Double
     *
     * @param: Double  自评分
     */
    public void setSelfScoring(Integer selfScoring) {
        this.selfScoring = selfScoring;
    }

    /**
     * 方法: 取得Double
     *
     * @return: Double  领导评分
     */
    public Integer getLeadeScore() {
        return this.leadeScore;
    }

    /**
     * 方法: 设置Double
     *
     * @param: Double  领导评分
     */
    public void setLeadeScore(Integer leadeScore) {
        this.leadeScore = leadeScore;
    }

    /**
     * 方法: 取得Double
     *
     * @return: Double  综合评分
     */
    public double getComprehensiveScore() {
        return this.comprehensiveScore;
    }

    /**
     * 方法: 设置Double
     *
     * @param: Double  综合评分
     */
    public void setComprehensiveScore(double comprehensiveScore) {
        this.comprehensiveScore = comprehensiveScore;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  评语
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  评语
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 方法: 取得Integer
     *
     * @return: Integer  排名
     */
    public Integer getRanking() {
        return this.ranking;
    }

    /**
     * 方法: 设置Integer
     *
     * @param: Integer  排名
     */
    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  删除标识
     */
    public String getDelFlag() {
        return this.delFlag;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  删除标识
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  创建人
     */
    public String getCreateUser() {
        return this.createUser;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 方法: 取得Date
     *
     * @return: Date  创建时间
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 方法: 设置Date
     *
     * @param: Date  创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public String getProjectsCode() {
        return projectsCode;
    }

    public void setProjectsCode(String projectsCode) {
        this.projectsCode = projectsCode;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  updateUser
     */
    public String getUpdateUser() {
        return this.updateUser;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  updateUser
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 方法: 取得Date
     *
     * @return: Date  修改时间
     */
    public Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * 方法: 设置Date
     *
     * @param: Date  修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getIsCommit() {
        return isCommit;
    }

    public void setIsCommit(String isCommit) {
        this.isCommit = isCommit;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

}
