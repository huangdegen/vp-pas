package com.idp.web.system.dao;

import com.idp.common.base.BaseDao;
import com.idp.common.persistence.Page;
import com.idp.web.assessment.entity.Assessment;
import com.idp.web.system.entity.SysOrg;
import com.idp.web.system.entity.SysRole;
import com.idp.web.system.entity.SysUser;

import java.util.List;

public interface SysUserDao extends BaseDao<SysUser, String> {

	public SysUser findByUsername(String username);
	
	void updateUserPassword(SysUser sysUser);

	public List<SysUser> finds(SysUser user);

	List<SysUser> findByNameAndId(SysUser user);

	public List<SysUser> findForTreeTable(String parentId);

	public String getMaxCode(String parentId);

	public void deleteByParentId(String parentId);

	public SysUser getByIds(String parentId);

	List<SysUser> getByParentId(String parentId);

	void updateByUserCode(SysUser sysUser);

	List<SysUser> getByCount(SysUser sysUser,Page<SysUser> page);


	List<SysUser> getByCountEmail(SysUser sysUser);

	List<SysUser> getByCountMonthEmail(SysUser sysUser);

	List<SysUser> getByCountMonth(SysUser sysUser,Page<SysUser> page);

}
