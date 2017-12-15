package com.idp.web.system.controller;

import com.idp.common.base.BaseController;
import com.idp.common.constant.AssessmentConstant;
import com.idp.common.model.UploadModel;
import com.idp.common.persistence.Page;
import com.idp.common.util.HanyuPinyinHelper;
import com.idp.common.util.MD5Utils;
import com.idp.common.util.UploadUtils;
import com.idp.common.util.ValidateUtils;
import com.idp.common.util.excle.ExportExcel;
import com.idp.common.util.excle.ImportExcel;
import com.idp.web.assessment.entity.Assessment;
import com.idp.web.assessment.service.AssessmentService;
import com.idp.web.system.entity.SysDictionary;
import com.idp.web.system.entity.SysRole;
import com.idp.web.system.entity.SysUser;
import com.idp.web.system.service.SysDictionaryService;
import com.idp.web.system.service.SysOrgService;
import com.idp.web.system.service.SysRoleService;
import com.idp.web.system.service.SysUserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理controller
 * <p>
 * <pre>
 * 	历史记录：
 * 	2016-07-17 21:17 King
 * 	新建文件
 */
@Controller
@RequestMapping("/user")
public class SysUserController extends BaseController {

    private Logger logger = Logger.getLogger(SysUserController.class);

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysOrgService sysOrgService;
    @Resource
    private SysDictionaryService sysDictionaryService;
    private Validator validator;
    @Resource
    private AssessmentService assessmentService;


    /**
     * <pre>
     * 	2016-07-17 21:17 King
     * 	初始化查询页面
     * </pre>
     *
     * @return
     */
    @RequestMapping("/init")
    public String init() {
        return "system/user/userSearch";
    }


    /**
     * 查询顶级菜单
     *
     * @param request
     * @return
     */
    @RequestMapping("/lists")
    public String list(HttpServletRequest request) {
        try {
            request.setAttribute("userList", sysUserService.findForTreeTable("0"));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "system/user/userList";
    }

    /**
     * 查询下级组织
     *
     * @param parentId
     * @return
     */
    @RequestMapping("/treeTables")
    @ResponseBody
    public String treeTable(String parentId) {
        JSONArray json = new JSONArray();

        try {
            json.addAll(sysUserService.findForTreeTable(parentId));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return json.toString();
    }


    /**
     * 获取组织树状结构
     *
     * @return
     */
    @RequestMapping("/getOrgForTrees")
    @ResponseBody
    public String getOrgForTree(String parentId) {
        JSONArray json = new JSONArray();

        List<SysUser> userList = sysUserService.finds(new SysUser());

        if (userList != null && userList.size() > 0) {
            for (SysUser user : userList) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", user.getId());
                map.put("name", user.getName());
                map.put("code", user.getUserCode());
                map.put("pId", user.getParentId());
                map.put("pName", user.getParentName());
                json.add(map);
            }
        }
        return json.toString();
    }


    /**
     * <pre>
     * 	2016-07-17 21:17 King
     * 	分页查询
     * </pre>
     *
     * @param sysUser
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(SysUser sysUser, Page<SysUser> page, HttpServletRequest request) {

        try {
            SysDictionary isPositive = sysDictionaryService.getByCode(AssessmentConstant.DICT_IS_POSITIVE);
            SysDictionary isWork = sysDictionaryService.getByCode(AssessmentConstant.DICT_IS_WORK);
            request.setAttribute("isWork", isWork.getChildren());
            request.setAttribute("isPositive", isPositive.getChildren());
            request.setAttribute("page", sysUserService.findByPage(sysUser, page));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "system/user/userList";
    }
    /*@RequestMapping("/findUserList")
    public String findList(HttpServletRequest request,SysUser sysUser){
	    sysUser = sysUserService.findByUsername(sysUser);
		request.setAttribute("user", sysUser);
		return "system/user/updateUserPassword";
	}*/

    @RequestMapping("/jump")
    public String jumpUpdateJSP() {
        return "system/user/updateUserPassword";
    }

    @RequestMapping("/updateUserPassword")
    @ResponseBody
    public String updateUserPasswords(SysUser user) {
        JSONObject json = new JSONObject();

        if (user.getPassword().equals(user.getNewPassword())) {
            SysUser sessionUser = getCurrentUser(); // 获取当前用户的信息
            SysUser newUser = sysUserService.findByUsername(sessionUser);
            newUser.setPassword(MD5Utils.encodeToMD5(user.getPassword()));
            sysUserService.updateUserPassword(newUser);
            cleanUserSession();
            json.put("result", "save_success");
        } else {
            json.put("result", "save_fail");
        }
        return json.toString();
    }


    /**
     * <pre>
     * 	2016-07-17 21:17 King
     * 	新增修改页面初始化
     * </pre>
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/user")
    public String user(String id, HttpServletRequest request) {

        try {

            List<String> roleIds = null;
            SysDictionary isPositive = sysDictionaryService.getByCode(AssessmentConstant.DICT_IS_POSITIVE);
            SysDictionary isWork = sysDictionaryService.getByCode(AssessmentConstant.DICT_IS_WORK);

            if (ValidateUtils.isNotEmpty(id)) {
                SysUser user = sysUserService.getById(id);
                request.setAttribute("user", user);
                roleIds = sysUserService.findByUserId(id);
            }

            List<SysRole> roleList = sysRoleService.findBySearch(new SysRole());
            if (roleIds != null) {
                for (SysRole role : roleList) {
                    if (roleIds.contains(role.getId())) {
                        role.setUserHas(true);
                    }
                }
            }
            request.setAttribute("isWork", isWork.getChildren());
            request.setAttribute("isPositive", isPositive.getChildren());
            request.setAttribute("roleList", roleList);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return "system/user/user";
    }

    /**
     * <pre>
     * 	2016-07-17 21:17 King
     * 	保存
     * </pre>
     *
     * @param request
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(HttpServletRequest request) {

        JSONObject json = new JSONObject();

        try {
            SysUser user = new SysUser();
            SysDictionary isPositive = sysDictionaryService.getByCode(AssessmentConstant.DICT_IS_POSITIVE);
            SysDictionary isWork = sysDictionaryService.getByCode(AssessmentConstant.DICT_IS_WORK);

            UploadModel model = new UploadModel(UploadUtils.getServerUploadBasePath(UploadUtils.PATH_IMAGES), UploadModel.IMAGES, user);
            UploadUtils.uploadFileSealedObject(request, model);

            if (ValidateUtils.isEmpty(user.getParentId())) {
                user.setParentId("0");
            }

            if (model.isSuccess()) {
                // 修改
                if (ValidateUtils.isNotEmpty(user.getId())) {
                    user.setPassword(MD5Utils.encodeToMD5(user.getPassword()));
                    sysUserService.update(user);

                    if (!ValidateUtils.isEmpty(user)) {
                        Assessment assessment = new Assessment();
                        assessment = assessmentService.getMentByIds(user.getId());
                        assessment.setRotation(user.getRotationId());
                        assessmentService.update(assessment);
                    }
                }
                // 新增
                else {
                    user.setPassword(MD5Utils.encodeToMD5(user.getPassword()));
                    sysUserService.add(user);
                }
                json.put("result", "save_success");
            } else {
                json.put("result", model.getMessage());
            }
            request.setAttribute("isWork", isWork.getChildren());
            request.setAttribute("isPositive", isPositive.getChildren());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            json.put("result", "save_fail");
        }
        return json.toString();
    }

    /**
     * <pre>
     * 	2016-07-17 21:17 King
     * 	删除
     * </pre>
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String id) {

        JSONObject json = new JSONObject();
        try {
            sysUserService.delete(id);
            json.put("result", "delete_success");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            json.put("result", "delete_fail");
        }

        return json.toString();
    }


    /**
     * 导入用户数据
     *
     * @param file
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "import", method = RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            ImportExcel ei = new ImportExcel(file, 0, 0);
            List<SysUser> list = ei.getDataList(SysUser.class);
            Map<String, String> orgMap = sysOrgService.findByAll();
            Map<String, String> roleMap = sysRoleService.findByAll();
            Map<String, SysUser> userMap = sysUserService.findByAll();
            SysUser parentUser;
            for (SysUser user : list) {
                if (StringUtils.isEmpty(user.getUsername())) {
                    user.setUsername(HanyuPinyinHelper.toHanyuPinyin(user.getName()));
                }
                if (StringUtils.isEmpty(user.getOrgId())) {
                    logger.warn("所属组织不能为空");
                    redirectAttributes.addFlashAttribute("msg", "所属组织不能为空");
                    return "redirect:list";
                }
                if (StringUtils.isEmpty(user.getRoleIds())) {
                    logger.warn("岗位不能为空");
                    redirectAttributes.addFlashAttribute("msg", "岗位不能为空");
                    return "redirect:list";
                }
                if (sysUserService.findByUsername(user) != null) {
                    logger.warn("用户名重复");
                    redirectAttributes.addFlashAttribute("msg", "用户名重复:" + user.getUsername());
                    return "redirect:list";
                }
                if (orgMap.get(user.getOrgId()).isEmpty()) {
                    logger.warn("无效组织");
                    redirectAttributes.addFlashAttribute("msg", "无效组织");
                    return "redirect:list";
                }
                if (roleMap.get(user.getRoleIds()).isEmpty()) {
                    logger.warn("无效角色");
                    redirectAttributes.addFlashAttribute("msg", "无效角色");
                    return "redirect:list";
                }
                user.setOrgId(orgMap.get(user.getOrgId()));
                user.setRoleIds(roleMap.get(user.getRoleIds()));
                parentUser = userMap.get(user.getParentId());
                if (parentUser != null) {
                    user.setParentId(parentUser.getId());
                    user.setParentName(parentUser.getName());
                } else {
                    user.setParentId("0");
                }
            }
            Boolean isSuccess = sysUserService.saveList(list);
            redirectAttributes.addFlashAttribute("msg", "导入数据成功!");
            logger.info("导入数据成功!");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("导入数据失败!");
        }
        return "redirect:list";
    }


    /**
     * 下载导入用户数据模板
     *
     * @param response
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
        try {
            String fileName = "用户数据导入模板.xlsx";
            SysUser sessionUser = getCurrentUser();
            List<SysUser> list = new ArrayList<>();
            list.add(sessionUser);
            new ExportExcel("用户数据", SysUser.class, 2).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            logger.error("导入模板下载失败！失败信息");
            //addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "updUserCode")
    public Boolean updUserCode(String uid) {
        if (StringUtils.isEmpty(uid)) {
            return false;
        }
        return sysUserService.updUserCode(uid);
    }


    /***
     * 统计昨日没有提交工时的员工
     * @param sysUser
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/statistics")
    public String statisticsCount(SysUser sysUser,Page<SysUser> page,HttpServletRequest request) {
        try {
        request.setAttribute("page",sysUserService.getByCount(sysUser,page));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "reporting/vpCountList";
    }

    /***
     * 统计上月没有提交考核信息的员工
     * @param sysUser
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/statisticsMonth")
    public String statisticsMonth(SysUser sysUser,Page<SysUser> page,HttpServletRequest request) {
        try {
            request.setAttribute("page",sysUserService.getByCountMonth(sysUser,page));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "assessment/assessmentMonthList";
    }
}
