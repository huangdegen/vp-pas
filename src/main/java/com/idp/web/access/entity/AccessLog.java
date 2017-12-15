package com.idp.web.access.entity;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.idp.common.base.BaseEntity;
import com.idp.web.system.entity.SysUser;

/**
 * 
 * 访问日志实体类.
 * 
 * <pre>
 * 	历史记录：
 * 	2017-04-13 00
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	00
 * PG
 *	00
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
public class AccessLog extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**accessLogId*/
	private String accessLogId;
	/**访问时间*/
	private Date accessLogTime;
	/**用户名*/
	private String userId;
	/**IP地址*/
	private String accessIp;
	/**地址*/
	private String accessUrl;
	
	
	private SysUser sysUser;
	
	private String sysUserName;
	
	
	
	
	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	/**
	 *方法: 取得String
	 *@return: String  accessLogId
	 */
	public String getAccessLogId(){
		return this.accessLogId;
	}

	/**
	 *方法: 设置String
	 *@param: String  accessLogId
	 */
	public void setAccessLogId(String accessLogId){
		this.accessLogId = accessLogId;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  访问时间
	 */
	public Date getAccessLogTime(){
		return this.accessLogTime;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  访问时间
	 */
	public void setAccessLogTime(Date accessLogTime){
		this.accessLogTime = accessLogTime;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  用户名
	 */
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置String
	 *@param: String  用户名
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  IP地址
	 */
	public String getAccessIp(){
		return this.accessIp;
	}

	/**
	 *方法: 设置String
	 *@param: String  IP地址
	 */
	public void setAccessIp(String accessIp){
		this.accessIp = accessIp;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  地址
	 */
	public String getAccessUrl(){
		return this.accessUrl;
	}

	/**
	 *方法: 设置String
	 *@param: String  地址
	 */
	public void setAccessUrl(String accessUrl){
		this.accessUrl = accessUrl;
	}
	
	
}
