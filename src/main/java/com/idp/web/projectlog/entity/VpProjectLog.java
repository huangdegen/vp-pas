package com.idp.web.projectlog.entity;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.idp.common.base.BaseEntity;

/**
 * 
 * 项目管理日志实体类.
 * 
 * <pre>
 * 	历史记录：
 * 	2017-09-05 mrLi
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	mrLi
 * PG
 *	mrLi
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
public class VpProjectLog extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**id*/
	private String id;
	/**项目名称*/
	private String projectName;
	/**项目经理*/
	private String projectManger;
	/**项目成员*/
	private String projectMember;
	/**项目所属地址*/
	private String projectAddress;
	/**项目描述*/
	private String projectDescribe;
	/**项目起始时间*/
	private Date projectStartTime;
	/**项目结束时间*/
	private Date projectEndTime;
	/**parentId*/
	private String parentId;
	/**项目进度*/
	private Integer projectProgress;
	/**更改后的经理人*/
	private String updateManger;
	/**修改时间*/
	private Date updateDate;
	
	
	/**
	 *方法: 取得String
	 *@return: String  id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置String
	 *@param: String  id
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  项目名称
	 */
	public String getProjectName(){
		return this.projectName;
	}

	/**
	 *方法: 设置String
	 *@param: String  项目名称
	 */
	public void setProjectName(String projectName){
		this.projectName = projectName;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  项目经理
	 */
	public String getProjectManger(){
		return this.projectManger;
	}

	/**
	 *方法: 设置String
	 *@param: String  项目经理
	 */
	public void setProjectManger(String projectManger){
		this.projectManger = projectManger;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  项目成员
	 */
	public String getProjectMember(){
		return this.projectMember;
	}

	/**
	 *方法: 设置String
	 *@param: String  项目成员
	 */
	public void setProjectMember(String projectMember){
		this.projectMember = projectMember;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  项目所属地址
	 */
	public String getProjectAddress(){
		return this.projectAddress;
	}

	/**
	 *方法: 设置String
	 *@param: String  项目所属地址
	 */
	public void setProjectAddress(String projectAddress){
		this.projectAddress = projectAddress;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  项目描述
	 */
	public String getProjectDescribe(){
		return this.projectDescribe;
	}

	/**
	 *方法: 设置String
	 *@param: String  项目描述
	 */
	public void setProjectDescribe(String projectDescribe){
		this.projectDescribe = projectDescribe;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  项目起始时间
	 */
	public Date getProjectStartTime(){
		return this.projectStartTime;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  项目起始时间
	 */
	public void setProjectStartTime(Date projectStartTime){
		this.projectStartTime = projectStartTime;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  项目结束时间
	 */
	public Date getProjectEndTime(){
		return this.projectEndTime;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  项目结束时间
	 */
	public void setProjectEndTime(Date projectEndTime){
		this.projectEndTime = projectEndTime;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  parentId
	 */
	public String getParentId(){
		return this.parentId;
	}

	/**
	 *方法: 设置String
	 *@param: String  parentId
	 */
	public void setParentId(String parentId){
		this.parentId = parentId;
	}
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  项目进度
	 */
	public Integer getProjectProgress(){
		return this.projectProgress;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  项目进度
	 */
	public void setProjectProgress(Integer projectProgress){
		this.projectProgress = projectProgress;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  更改后的经理人
	 */
	public String getUpdateManger(){
		return this.updateManger;
	}

	/**
	 *方法: 设置String
	 *@param: String  更改后的经理人
	 */
	public void setUpdateManger(String updateManger){
		this.updateManger = updateManger;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  修改时间
	 */
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  修改时间
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	
	
}
