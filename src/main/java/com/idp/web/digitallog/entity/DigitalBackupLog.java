package com.idp.web.digitallog.entity;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.idp.common.base.BaseEntity;

/**
 * 
 * 数据库备份日志实体类.
 * 
 * <pre>
 * 	历史记录：
 * 	2017-06-22 123
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	123
 * PG
 *	123
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
public class DigitalBackupLog extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**id*/
	private String id;
	/**time*/
	private Date time;
	/**storeUrl*/
	private String storeUrl;
	/**fileName*/
	private String fileName;
	
	/**time开始*/
	private Date timeStart;
	/**time结束*/
	private Date timeEnd;
	
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
	 *方法: 取得Date
	 *@return: Date  time
	 */
	public Date getTime(){
		return this.time;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  time
	 */
	public void setTime(Date time){
		this.time = time;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  storeUrl
	 */
	public String getStoreUrl(){
		return this.storeUrl;
	}

	/**
	 *方法: 设置String
	 *@param: String  storeUrl
	 */
	public void setStoreUrl(String storeUrl){
		this.storeUrl = storeUrl;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  fileName
	 */
	public String getFileName(){
		return this.fileName;
	}

	/**
	 *方法: 设置String
	 *@param: String  fileName
	 */
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	
	
	/**
	 *方法: 取得Date
	 *@return: Date  time开始
	 */
	public Date getTimeStart(){
		return this.timeStart;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  time开始
	 */
	public void setTimeStart(Date timeStart){
		this.timeStart = timeStart;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  time结束
	 */
	public Date getTimeEnd(){
		return this.timeEnd;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  time结束
	 */
	public void setTimeEnd(Date timeEnd){
		this.timeEnd = timeEnd;
	}
	
}
