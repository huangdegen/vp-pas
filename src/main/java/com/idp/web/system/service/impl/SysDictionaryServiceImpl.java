package com.idp.web.system.service.impl;

import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;
import com.idp.web.system.dao.SysDictionaryDao;
import com.idp.web.system.entity.SysDictionary;
import com.idp.web.system.service.SysDictionaryService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据字典service实现类
 * <p>
 * <pre>
 * 	历史记录：
 * 	2017-01-07 23:45 King
 * 	新建文件
 * </pre>
 *
 * @author <pre>
 *                                 SD
 *                                 	King
 *                                 PG
 *                                 	King
 *                                 UT
 *
 *                                 MA
 *                                 </pre>
 * @version $Rev$
 *          <p>
 *          <p/> $Id$
 */
@Service("sysDictionaryService")
public class SysDictionaryServiceImpl implements SysDictionaryService {

    @Resource
    private SysDictionaryDao sysDictionaryDao;

    @Override
    public Page<SysDictionary> findByPage(SysDictionary sysDictionary, Page<SysDictionary> page) {

        page.setResult(sysDictionaryDao.find(sysDictionary, page));

        return page;
    }

    @Override
    public List<SysDictionary> findBySearch(SysDictionary sysDictionary) {

        return sysDictionaryDao.find(sysDictionary);
    }

    @Override
    public SysDictionary getById(String id) {

        SysDictionary sysDictionary = sysDictionaryDao.getById(id);
        sysDictionary.setChildren(sysDictionaryDao.getByGroupId(sysDictionary.getId()));

        return sysDictionary;
    }

    @Override
    public void add(SysDictionary sysDictionary) {

        sysDictionary.setId(ResourceUtils.getUUID());
        sysDictionaryDao.add(sysDictionary);

        if (sysDictionary.getChildren() != null && sysDictionary.getChildren().size() > 0) {
            for (SysDictionary child : sysDictionary.getChildren()) {

                child.setId(ResourceUtils.getUUID());
                child.setGroupId(sysDictionary.getId());
            }
            sysDictionaryDao.batchAdd(sysDictionary.getChildren());
        }
    }

    @Override
    @CacheEvict(value = "dictCache", key = "#sysDictionary.code")
    public void update(SysDictionary sysDictionary) {

        sysDictionaryDao.update(sysDictionary);

        sysDictionaryDao.deleteByGroupId(sysDictionary.getId());

        if (sysDictionary.getChildren() != null && sysDictionary.getChildren().size() > 0) {
            for (SysDictionary child : sysDictionary.getChildren()) {

                child.setId(ResourceUtils.getUUID());
                child.setGroupId(sysDictionary.getId());
            }
            sysDictionaryDao.batchAdd(sysDictionary.getChildren());
        }
    }

    @Override
    @CacheEvict(value = "dictCache", key = "#sysDictionary.code")
    public void delete(SysDictionary sysDictionary) {

        sysDictionaryDao.delete(sysDictionary.getId());
        sysDictionaryDao.deleteByGroupId(sysDictionary.getId());
    }

    @Override
    @Cacheable(value = "dictCache", key = "#code")
    public SysDictionary getByCode(String code) {
        SysDictionary sysDictionary = sysDictionaryDao.getByGroupCode(code);
        sysDictionary.setChildren(sysDictionaryDao.getByGroupId(sysDictionary.getId()));
        return sysDictionary;
    }

    public Map<String, String> getByCodeOverride(String code) {
        Map<String, String> dictMap = new HashMap<>();
        SysDictionary dictionary = getByCode(code);
        if (dictionary != null && !CollectionUtils.isEmpty(dictionary.getChildren())) {
            for (SysDictionary dict : dictionary.getChildren()) {
                dictMap.put(dict.getCode(), dict.getName());
            }
        }
        return dictMap;
    }
}