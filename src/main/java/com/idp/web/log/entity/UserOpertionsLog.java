package com.idp.web.log.entity;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.idp.common.base.BaseEntity;
import com.idp.web.system.entity.SysUser;

/**
 * 
 * 审计日志实体类.
 * 
 * <pre>
 * 	历史记录：
 * 	2017-04-12 ivan
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	ivan
 * PG
 *	ivan
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
public class UserOpertionsLog extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**主键*/
	private String id;
	/**datetime*/
	private Date datetime;
	/**userId*/
	private String userId;
	private SysUser sysUser;
	/**IP地址*/
	private String ipAddress;
	/**模块名*/
	private String models;
	/**动作*/
	private String action;
	/**结果*/
	private Integer result;
	/**消息*/
	private String message;
	
	private String sysUserName;
	
	/**datetime开始*/
	private Date datetimeStart;
	/**datetime结束*/
	private Date datetimeEnd;
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  主键
	 */
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  datetime
	 */
	public Date getDatetime(){
		return this.datetime;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  datetime
	 */
	public void setDatetime(Date datetime){
		this.datetime = datetime;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 *方法: 取得String
	 *@return: String  userId
	 */
	public SysUser getSysUser() {
		return sysUser;
	}

	/**
	 *方法: 设置String
	 *@param: String  userId
	 */
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	
	
	/**
	 *方法: 取得String
	 *@return: String  IP地址
	 */
	public String getIpAddress(){
		return this.ipAddress;
	}

	

	/**
	 *方法: 设置String
	 *@param: String  IP地址
	 */
	public void setIpAddress(String ipAddress){
		this.ipAddress = ipAddress;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  模块名
	 */
	public String getModels(){
		return this.models;
	}

	/**
	 *方法: 设置String
	 *@param: String  模块名
	 */
	public void setModels(String models){
		this.models = models;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  动作
	 */
	public String getAction(){
		return this.action;
	}

	/**
	 *方法: 设置String
	 *@param: String  动作
	 */
	public void setAction(String action){
		this.action = action;
	}
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  结果
	 */
	public Integer getResult(){
		return this.result;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  结果
	 */
	public void setResult(Integer result){
		this.result = result;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  消息
	 */
	public String getMessage(){
		return this.message;
	}

	/**
	 *方法: 设置String
	 *@param: String  消息
	 */
	public void setMessage(String message){
		this.message = message;
	}
	
	
	public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	/**
	 *方法: 取得Date
	 *@return: Date  datetime开始
	 */
	public Date getDatetimeStart(){
		return this.datetimeStart;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  datetime开始
	 */
	public void setDatetimeStart(Date datetimeStart){
		this.datetimeStart = datetimeStart;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  datetime结束
	 */
	public Date getDatetimeEnd(){
		return this.datetimeEnd;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  datetime结束
	 */
	public void setDatetimeEnd(Date datetimeEnd){
		this.datetimeEnd = datetimeEnd;
	}
	
}
