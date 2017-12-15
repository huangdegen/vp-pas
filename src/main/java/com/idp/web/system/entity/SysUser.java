package com.idp.web.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.idp.common.base.BaseEntity;
import com.idp.common.util.excle.ExcelField;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysUser extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -802158862722106613L;

    /**
     * 用户账号
     */
    @ExcelField(title = "用户名", align = 2, sort = 1, fieldType = String.class)
    private String username;

    /**
     * 用户密码
     */
   /* @Length(min = 1, max = 100, message = "登录名长度必须介于 1 和 100 之间")
    @NotNull(message = "用户密码不能为空")
    @ExcelField(title = "用户密码",  align = 2, sort = 2)*/
    private String password;

    private String newPassword;

    /**
     * 姓名
     */
    @NotNull(message = "姓名不能为空")
    @ExcelField(title = "姓名", type = 2, align = 2, sort = 2)
    private String name;
    /**
     * 组织ID
     */
    @ExcelField(title = "所属组织", type = 2, align = 2, sort = 3)
    private String orgId;
    /**
     * 出生日期
     */

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ExcelField(title = "出生日期", type = 2, align = 2, sort = 7, fieldType = Date.class)
    private Date birthday;
    /**
     * 电话
     */

    @Length(min = 1, max = 100, message = "电话长度必须介于 1 和 100 之间")
    @ExcelField(title = "电话", type = 2, align = 2, sort = 8)
    private String phone;
    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    @Length(min = 0, max = 200, message = "邮箱长度必须介于 1 和 200 之间")
    @ExcelField(title = "邮箱", type = 2, align = 2, sort = 9)
    private String email;
    /**
     * 描述
     */
    @ExcelField(title = "描述", type = 2, align = 2, sort = 10)
    private String description;
    /**
     * 用户头像
     */
    private String userPhoto;

    /**
     * 组织编码
     */
    private String orgCode;
    /**
     * 组织名称
     */

    private String orgName;

    /**
     * 角色id,逗号分隔
     */
    @ExcelField(title = "岗位", type = 2, align = 2, sort = 4)
    private String roleIds;

    /**
     * 直属上级
     */
    @ExcelField(title = "直属上级", type = 2, align = 2, sort = 6)
    private String parentId;

    @ExcelField(title = "是否转正", type = 2, align = 2, sort = 5)
    private String rotationId;


    private String userCode;

    private String parentName;

    private SysUser parentUser;

    private String validateCode;


    /**
     * 是否在职
     *
     * @return
     */
    private String isWork;


    /**
     * 用户菜单
     */

    private List<SysMenu> menuList;


    public String getIsWork() {
        return isWork;
    }

    public void setIsWork(String isWork) {
        this.isWork = isWork;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getRotationId() {
        return rotationId;
    }

    public void setRotationId(String rotationId) {
        this.rotationId = rotationId;
    }

    public List<SysMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<SysMenu> menuList) {
        this.menuList = menuList;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public SysUser getParentUser() {
        return parentUser;
    }

    public void setParentUser(SysUser parentUser) {
        this.parentUser = parentUser;
    }


    @Override
    public String toString() {
        return "SysUser [username=" + username + ", password=" + password + ", name=" + name + ", orgId=" + orgId
                + ", birthday=" + birthday + ", phone=" + phone + ", email=" + email + ", description=" + description
                + ", userPhoto=" + userPhoto + ", orgCode=" + orgCode + ", orgName=" + orgName + ", roleIds=" + roleIds
                + ",parentId=" + parentId + ",rotationId=" + rotationId + ",userCode=" + userCode + ",parentName=" + parentName
                + ",parentUser=" + parentUser
                + ", menuList=" + menuList + "]";
    }


}
