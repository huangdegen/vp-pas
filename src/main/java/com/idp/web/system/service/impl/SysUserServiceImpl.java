package com.idp.web.system.service.impl;

import com.idp.common.persistence.Page;
import com.idp.common.util.MD5Utils;
import com.idp.common.util.ResourceUtils;
import com.idp.web.system.dao.SysRoleMenuDao;
import com.idp.web.system.dao.SysUserDao;
import com.idp.web.system.dao.SysUserRoleDao;
import com.idp.web.system.entity.SysUser;
import com.idp.web.system.entity.SysUserRole;
import com.idp.web.system.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SysUserRoleDao sysUserRoleDao;
    @Resource
    private SysRoleMenuDao sysRoleMenuDao;

    @Override
    public SysUser findByUsername(SysUser user) {
        return sysUserDao.findByUsername(user.getUsername());
    }

    @Override
    public Page<SysUser> findByPage(SysUser user, Page<SysUser> page) {
        page.setResult(sysUserDao.find(user, page));
        return page;
    }

    @Override
    public SysUser getById(String id) {
        return sysUserDao.getById(id);
    }

    @Override
    public void add(SysUser user) {

        user.setId(ResourceUtils.getUUID());
        buildCode(user);
        sysUserDao.add(user);

        if (StringUtils.isNotEmpty(user.getRoleIds())) {
            List<SysUserRole> userRoleList = new ArrayList<SysUserRole>();
            for (String roleId : user.getRoleIds().split(",")) {
                if (StringUtils.isNotEmpty(roleId)) {
                    SysUserRole userRole = new SysUserRole();
                    userRole.setId(ResourceUtils.getUUID());
                    userRole.setRoleId(roleId);
                    userRole.setUserId(user.getId());
                    userRoleList.add(userRole);
                }
            }

            if (userRoleList.size() > 0) {
                sysUserRoleDao.batchAdd(userRoleList);
            }
        }
    }

    @Override
    public void update(SysUser user) {

        // 上层组织改变时，改变组织编码
        SysUser olduser = sysUserDao.getByIds(user.getId());
        if (StringUtils.isNotEmpty(user.getParentId()) && user.getParentId() != olduser.getParentId()) {
            //修改自己
            buildCode(user);
        }
        sysUserDao.update(user);
        if (StringUtils.isNotEmpty(user.getParentId()) && user.getParentId() != olduser.getParentId()) {
            //修改所有下级
            updUserCode(user);
        }

        // 删除旧数据
        sysUserRoleDao.deleteByUserId(user.getId());

        if (StringUtils.isNotEmpty(user.getRoleIds())) {
            List<SysUserRole> userRoleList = new ArrayList<SysUserRole>();
            for (String roleId : user.getRoleIds().split(",")) {
                if (StringUtils.isNotEmpty(roleId)) {
                    SysUserRole userRole = new SysUserRole();
                    userRole.setId(ResourceUtils.getUUID());
                    userRole.setRoleId(roleId);
                    userRole.setUserId(user.getId());
                    userRoleList.add(userRole);
                }
            }

            if (userRoleList.size() > 0) {
                sysUserRoleDao.batchAdd(userRoleList);
            }
        }
    }

    public void buildCode(SysUser user) {
        String maxCode = sysUserDao.getMaxCode(user.getParentId());
        if (StringUtils.isNotEmpty(maxCode)) {
            String preno = maxCode.substring(0, maxCode.length() - 3);
            int no = Integer.valueOf(maxCode.substring(maxCode.length() - 3));
            DecimalFormat df = new DecimalFormat("000");
            user.setUserCode(preno + df.format(no + 1));
        } else {
            SysUser parentUser = sysUserDao.getByIds(user.getParentId());
            user.setUserCode(parentUser.getUserCode() + "001");
            user.setParentName(parentUser.getName());
        }
    }

    public void buildCode2(SysUser user, SysUser parentUpUser) {
        if (parentUpUser != null) {
            user.setUserCode(parentUpUser.getUserCode() + "001");
            user.setParentName(parentUpUser.getName());
            return;
        }
        String maxCode = sysUserDao.getMaxCode(user.getParentId());
        if (StringUtils.isNotEmpty(maxCode)) {
            String preno = maxCode.substring(0, maxCode.length() - 3);
            int no = Integer.valueOf(maxCode.substring(maxCode.length() - 3));
            DecimalFormat df = new DecimalFormat("000");
            user.setUserCode(preno + df.format(no + 1));
        } else {
            SysUser parentUser = sysUserDao.getByIds(user.getParentId());
            user.setUserCode(parentUser.getUserCode() + "001");
            user.setParentName(parentUser.getName());
        }
    }


    public void deleteChildren(String id) {
        SysUser param = new SysUser();
        param.setParentId(id);
        List<SysUser> children = sysUserDao.finds(param);
        if (children != null && children.size() > 0) {
            for (SysUser child : children) {
                deleteChildren(child.getId());
            }
            sysUserDao.deleteByParentId(id);
        }
    }

    @Override
    public void delete(String id) {
        sysUserDao.delete(id);
    }

    @Override
    public List<String> findByUserId(String userId) {
        return sysUserRoleDao.findByUserId(userId);
    }

    @Override
    public List<String> findMenuIdByUserId(String userId) {
        return sysRoleMenuDao.findMenuIdByUserId(userId);
    }

    @Override
    public List<SysUser> getByParentId(String parentId) {
        return sysUserDao.getByParentId(parentId);
    }

    @Override
    public Boolean isLastUser(String parentId) {
        return CollectionUtils.isEmpty(sysUserDao.getByParentId(parentId));
    }

    @Override
    public Boolean saveList(List<SysUser> list) {
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        for (SysUser user : list) {
            user.setPassword(MD5Utils.encodeToMD5("123456"));
            add(user);
        }
        return true;
    }

    @Override
    public void updateUserPassword(SysUser sysUser) {
        sysUserDao.updateUserPassword(sysUser);

    }

    @Override
    public List<SysUser> finds(SysUser user) {
        return sysUserDao.finds(user);
    }

    @Override
    public Map<String, SysUser> findByAll() {
        Map<String, SysUser> userMap = new HashMap<>();
        List<SysUser> list = finds(new SysUser());
        for (SysUser user : list) {
            userMap.put(user.getUserCode(), user);
        }
        return userMap;
    }

    @Override
    public List<SysUser> findBySearch(SysUser sysUser) {
        return sysUserDao.findByNameAndId(sysUser);
    }


    @Override
    public Map<String, SysUser> findByUserNameAndId() {
        Map<String, SysUser> userMap = new HashMap<>();
        List<SysUser> list = findBySearch(new SysUser());
        for (SysUser user : list) {
            userMap.put(user.getId(), user);
        }
        return userMap;
    }

    @Override
    public List<SysUser> findForTreeTable(String parentId) {
        return sysUserDao.findForTreeTable(parentId);
    }


    @Override
    public Boolean updUserCode(String uid) {
        SysUser u1 = new SysUser();
        u1.setParentId(uid);
        List<SysUser> uList = sysUserDao.finds(u1);
        for (SysUser u : uList) {
            buildCode(u);
            sysUserDao.updateByUserCode(u);
            updUserCode(u.getId());
        }
        return true;
    }

    @Override
    public Page<SysUser> getByCount(SysUser sysUser,Page<SysUser> page) {

        page.setResult(sysUserDao.getByCount(sysUser, page));
        return page;
    }

    @Override
    public List<SysUser> getByCountEmail(SysUser sysUser) {
        return sysUserDao.getByCountEmail(sysUser);
    }

    @Override
    public List<SysUser> getByCountMonthEmail(SysUser sysUser) {
        return sysUserDao.getByCountMonthEmail(sysUser);
    }

    @Override
    public Page<SysUser> getByCountMonth(SysUser sysUser, Page<SysUser> page) {
        page.setResult(sysUserDao.getByCountMonth(sysUser, page));
        return page;
    }

    public Boolean updUserCode(SysUser user) {
        SysUser u1 = new SysUser();
        u1.setParentId(user.getId());
        List<SysUser> uList = sysUserDao.finds(u1);
        int i = 1;
        for (SysUser u : uList) {
            u.setUserCode(user.getUserCode() + "00" + i);
            u.setParentName(user.getName());
            sysUserDao.updateByUserCode(u);
            updUserCode(u);
            i++;
        }
        return true;
    }


}
