package com.idp.web.projectdetail.controller;

import com.idp.common.constant.AssessmentConstant;
import com.idp.web.projectdetail.entity.VpProjectDetail;
import com.idp.web.projectdetail.service.VpProjectDetailService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.idp.web.projectlog.entity.VpProjectLog;
import com.idp.web.projectlog.service.VpProjectLogService;
import com.idp.web.system.entity.SysDictionary;
import com.idp.web.system.entity.SysUser;
import com.idp.web.system.service.SysDictionaryService;
import com.idp.web.system.service.SysUserService;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idp.common.base.BaseController;
import com.idp.common.persistence.Page;
import com.idp.common.util.ValidateUtils;

import net.sf.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目详情controller
 * <p>
 * <pre>
 * 	历史记录：
 * 	2017-09-04 Mrli
 * 	新建文件
 * </pre>
 *
 * @author <pre>
 *         SD
 *         	Mrli
 *         PG
 *         	Mrli
 *         UT
 *
 *         MA
 *         </pre>
 * @version $Rev$
 *          <p>
 *          <p/> $Id$
 */
@Controller
@RequestMapping("/vpProjectDetail")
public class VpProjectDetailController extends BaseController {

    private Logger logger = Logger.getLogger(VpProjectDetailController.class);

    @Resource
    private VpProjectDetailService vpProjectDetailService;

    @Resource
    private SysDictionaryService sysDictionaryService;

    @Resource
    private SysUserService sysUserService;

    @Resource
    private VpProjectLogService projectLogService;
    /**
     * <pre>
     * 	2017-09-04 Mrli
     * 	初始化查询页面
     * </pre>
     *
     * @return
     */
    @RequestMapping("/init")
    public String init(HttpServletRequest request) {
        return "projectdetail/vpProjectDetailSearch";
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
     * 	2017-09-04 Mrli
     * 	分页查询
     * </pre>
     *
     * @param vpProjectDetail
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(VpProjectDetail vpProjectDetail, Page<VpProjectDetail> page, HttpServletRequest request) {

        try {
            SysDictionary sysDictionary = sysDictionaryService.getByCode(AssessmentConstant.DICT_PROJECT);
            SysDictionary address = sysDictionaryService.getByCode(AssessmentConstant.DICT_ADDRESS);
            List<SysUser> userList = sysUserService.findBySearch(new SysUser());
            request.setAttribute("userList", userList);
            request.setAttribute("address", address.getChildren());
            request.setAttribute("dictProject", sysDictionary.getChildren());
            request.setAttribute("page", vpProjectDetailService.findByPage(vpProjectDetail, page));

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
        }

        return "projectdetail/vpProjectDetailList";
    }

    /**
     * <pre>
     * 	2017-09-04 Mrli
     * 	新增修改页面初始化
     * </pre>
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/vpProjectDetail")
    public String vpProjectDetail(String id, HttpServletRequest request) {

        try {

            SysDictionary sysDictionary = sysDictionaryService.getByCode(AssessmentConstant.DICT_PROJECT);
            SysDictionary address = sysDictionaryService.getByCode(AssessmentConstant.DICT_ADDRESS);

            request.setAttribute("address", address.getChildren());
            request.setAttribute("dictProject", sysDictionary.getChildren());
            if (ValidateUtils.isNotEmpty(id)) {

                VpProjectDetail vpProjectDetail = vpProjectDetailService.getById(id);
                vpProjectDetail.setOldProjectManger(vpProjectDetail.getProjectManger());
                request.setAttribute("vpProjectDetail", vpProjectDetail);
            }

            List<SysUser> userList = sysUserService.findBySearch(new SysUser());
            request.setAttribute("userList", userList);
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
        }

        return "projectdetail/vpProjectDetail";
    }

    /**
     * <pre>
     * 	2017-09-04 Mrli
     * 	保存
     * </pre>
     *
     * @param vpProjectDetail
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(VpProjectDetail vpProjectDetail, HttpServletRequest request) {

        JSONObject json = new JSONObject();

        try {
            SysDictionary sysDictionary = sysDictionaryService.getByCode(AssessmentConstant.DICT_PROJECT);
            SysDictionary address = sysDictionaryService.getByCode(AssessmentConstant.DICT_ADDRESS);
            request.setAttribute("address", address.getChildren());
            request.setAttribute("dictProject", sysDictionary.getChildren());
            // 修改
            if (ValidateUtils.isNotEmpty(vpProjectDetail.getId())) {


                vpProjectDetailService.update(vpProjectDetail);

                VpProjectLog projectLog = new VpProjectLog();
                projectLog.setProjectName(vpProjectDetail.getProjectName());
                projectLog.setProjectManger(vpProjectDetail.getProjectManger());
                projectLog.setProjectMember(vpProjectDetail.getProjectMember());
                projectLog.setProjectAddress(vpProjectDetail.getProjectAddress());
                projectLog.setProjectDescribe(vpProjectDetail.getProjectDescribe());
                projectLog.setProjectStartTime(vpProjectDetail.getProjectStartTime());
                projectLog.setProjectEndTime(vpProjectDetail.getProjectEndTime());
                projectLog.setUpdateManger(vpProjectDetail.getProjectManger());
                projectLog.setProjectProgress(vpProjectDetail.getProjectProgress());
                projectLog.setUpdateDate(new Date());
                if (!vpProjectDetail.getProjectManger().equals(vpProjectDetail.getOldProjectManger())) {
                    projectLog.setProjectManger(vpProjectDetail.getOldProjectManger());
                    projectLog.setUpdateManger(vpProjectDetail.getProjectManger());
                }
                projectLogService.add(projectLog);
            }
            // 新增
            else {

                vpProjectDetailService.add(vpProjectDetail);
            }
            json.put("result", "save_success");
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            json.put("result", "save_fail");
        }

        return json.toString();
    }

    /**
     * <pre>
     * 	2017-09-04 Mrli
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

            vpProjectDetailService.delete(id);
            json.put("result", "delete_success");
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            json.put("result", "delete_fail");
        }

        return json.toString();
    }
}
