package com.idp.web.system.service;

import java.util.List;
import java.util.Map;

import com.idp.common.persistence.Page;
import com.idp.web.system.entity.SysUser;

public interface SysUserService {

    public SysUser findByUsername(SysUser user);

    public Page<SysUser> findByPage(SysUser user, Page<SysUser> page);

    public SysUser getById(String id);

    public void add(SysUser user);

    public void update(SysUser user);

    void updateUserPassword(SysUser sysUser);

    public List<SysUser> finds(SysUser user);

    public List<SysUser> findForTreeTable(String parentId);

    public void delete(String id);

    /**
     * 查询用户的所有角色
     *
     * @param userId
     * @return
     */
    public List<String> findByUserId(String userId);

    /**
     * 获取用户所有有权限的菜单id
     *
     * @param userId
     * @return
     */
    public List<String> findMenuIdByUserId(String userId);


    List<SysUser> getByParentId(String parentId);

    Boolean isLastUser(String parentId);

    Boolean saveList(List<SysUser> list);

    Map<String, SysUser> findByAll();

    List<SysUser> findBySearch(SysUser sysUser);

    Map<String, SysUser> findByUserNameAndId();

    public Boolean updUserCode(String uid);

    Page<SysUser> getByCount(SysUser sysUser, Page<SysUser> page);

    List<SysUser> getByCountEmail(SysUser sysUser);


    List<SysUser> getByCountMonthEmail(SysUser sysUser);

    Page<SysUser> getByCountMonth(SysUser sysUser, Page<SysUser> page);
}
