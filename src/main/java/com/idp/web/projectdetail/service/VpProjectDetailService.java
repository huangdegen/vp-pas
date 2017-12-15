package com.idp.web.projectdetail.service;
import com.idp.web.projectdetail.entity.VpProjectDetail;
import java.util.List;

import com.idp.common.persistence.Page;

/**
 * 
 * 项目详情service接口
 * 
 * <pre>
 * 	历史记录：
 * 	2017-09-04 Mrli
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	Mrli
 * PG
 *	Mrli
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
public interface VpProjectDetailService{
	
 	/**
	 * 
	 * <pre>
	 * 	2017-09-04 Mrli
	 * 	分页查询
	 * </pre>
	 * 
	 * @param vpProjectDetail
	 * @param page
	 * @return
	 */
	public Page<VpProjectDetail> findByPage(VpProjectDetail vpProjectDetail, Page<VpProjectDetail> page);
	
	/**
	 * 
	 * <pre>
	 * 	2017-09-04 Mrli
	 * 	查询
	 * </pre>
	 * 
	 * @param vpProjectDetail
	 * @return
	 */
	public List<VpProjectDetail> findBySearch(VpProjectDetail vpProjectDetail);
	
	/**
	 * 
	 * <pre>
	 * 	2017-09-04 Mrli
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param VpProjectDetail
	 * @return
	 */
	public VpProjectDetail getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2017-09-04 Mrli
	 * 	新增
	 * </pre>
	 * 
	 * @param vpProjectDetail
	 */
	public void add(VpProjectDetail vpProjectDetail);
	
	/**
	 * 
	 * <pre>
	 * 	2017-09-04 Mrli
	 * 	修改
	 * </pre>
	 * 
	 * @param vpProjectDetail
	 */
	public void update(VpProjectDetail vpProjectDetail);
	
	/**
	 * 
	 * <pre>
	 * 	2017-09-04 Mrli
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(String id);
}
