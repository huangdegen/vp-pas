package com.idp.web.keywords.service.impl;
import com.idp.web.keywords.service.KeywordsService;
import com.idp.web.keywords.dao.KeywordsDao;
import com.idp.web.keywords.entity.Keywords;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;

/**
 * 
 * 关键词过滤service实现类
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
@Service("keywordsService")
public class KeywordsServiceImpl implements KeywordsService {

	@Resource
	private KeywordsDao keywordsDao;
	
	@Override
	public Page<Keywords> findByPage(Keywords keywords, Page<Keywords> page) {

		page.setResult(keywordsDao.find(keywords, page));
		
		return page;
	}
	
	@Override
	public List<Keywords> findBySearch(Keywords keywords) {

		return keywordsDao.find(keywords);
	}
	
	@Override
	public Keywords getById(String keywordsId) {

		return keywordsDao.getById(keywordsId);
	}

	@Override
	public void add(Keywords keywords) {

		keywords.setKeywordsId(ResourceUtils.getUUID());
		keywordsDao.add(keywords);
	}
	
	@Override
	public void update(Keywords keywords) {

		keywordsDao.update(keywords);
	}

	@Override
	public void delete(String keywordsId) {

		keywordsDao.delete(keywordsId);
	}
 	
}