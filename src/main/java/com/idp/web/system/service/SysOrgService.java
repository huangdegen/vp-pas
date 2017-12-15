package com.idp.web.system.service;

import com.idp.web.system.entity.SysOrg;

import java.util.List;
import java.util.Map;

public interface SysOrgService {

    public List<SysOrg> find(SysOrg org);

    Map<String, String> findByAll();

    public List<SysOrg> findForTreeTable(String parentId);

    public SysOrg getById(String id);

    public void add(SysOrg org);

    public void update(SysOrg org);

    public void delete(String id);
}
