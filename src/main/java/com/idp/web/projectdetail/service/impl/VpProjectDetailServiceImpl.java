package com.idp.web.projectdetail.service.impl;
import com.idp.web.projectdetail.service.VpProjectDetailService;
import com.idp.web.projectdetail.dao.VpProjectDetailDao;
import com.idp.web.projectdetail.entity.VpProjectDetail;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;

/**
 * 
 * 项目详情service实现类
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
@Service("vpProjectDetailService")
public class VpProjectDetailServiceImpl implements VpProjectDetailService {

	@Resource
	private VpProjectDetailDao vpProjectDetailDao;
	
	@Override
	public Page<VpProjectDetail> findByPage(VpProjectDetail vpProjectDetail, Page<VpProjectDetail> page) {

		page.setResult(vpProjectDetailDao.find(vpProjectDetail, page));
		
		return page;
	}
	
	@Override
	public List<VpProjectDetail> findBySearch(VpProjectDetail vpProjectDetail) {

		return vpProjectDetailDao.find(vpProjectDetail);
	}
	
	@Override
	public VpProjectDetail getById(String id) {

		return vpProjectDetailDao.getById(id);
	}

	@Override
	public void add(VpProjectDetail vpProjectDetail) {

		vpProjectDetail.setId(ResourceUtils.getUUID());
		vpProjectDetailDao.add(vpProjectDetail);
	}
	
	@Override
	public void update(VpProjectDetail vpProjectDetail) {

		vpProjectDetailDao.update(vpProjectDetail);
	}

	@Override
	public void delete(String id) {

		vpProjectDetailDao.delete(id);
	}
 	
}