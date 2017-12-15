package com.idp.web.keywords.entity;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.idp.common.base.BaseEntity;

/**
 * 
 * 关键词过滤实体类.
 * 
 * <pre>
 * 	历史记录：
 * 	2017-04-13 java23
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	java23
 * PG
 *	java23
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
public class Keywords extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**ID*/
	private String keywordsId;
	/**关键词*/
	private String keywordsName;
	/**时间*/
	private Date keywordsTime;
	
	/**时间开始*/
	private Date keywordsTimeStart;
	/**时间结束*/
	private Date keywordsTimeEnd;
	
	/**
	 *方法: 取得String
	 *@return: String  ID
	 */
	public String getKeywordsId(){
		return this.keywordsId;
	}

	/**
	 *方法: 设置String
	 *@param: String  ID
	 */
	public void setKeywordsId(String keywordsId){
		this.keywordsId = keywordsId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  关键词
	 */
	public String getKeywordsName(){
		return this.keywordsName;
	}

	/**
	 *方法: 设置String
	 *@param: String  关键词
	 */
	public void setKeywordsName(String keywordsName){
		this.keywordsName = keywordsName;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  时间
	 */
	public Date getKeywordsTime(){
		return this.keywordsTime;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  时间
	 */
	public void setKeywordsTime(Date keywordsTime){
		this.keywordsTime = keywordsTime;
	}
	
	
	/**
	 *方法: 取得Date
	 *@return: Date  时间开始
	 */
	public Date getKeywordsTimeStart(){
		return this.keywordsTimeStart;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  时间开始
	 */
	public void setKeywordsTimeStart(Date keywordsTimeStart){
		this.keywordsTimeStart = keywordsTimeStart;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  时间结束
	 */
	public Date getKeywordsTimeEnd(){
		return this.keywordsTimeEnd;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  时间结束
	 */
	public void setKeywordsTimeEnd(Date keywordsTimeEnd){
		this.keywordsTimeEnd = keywordsTimeEnd;
	}
	
}
