package com.idp.web.assessment.controller;

import com.idp.common.base.BaseController;
import com.idp.common.constant.AssessmentConstant;
import com.idp.common.persistence.Page;
import com.idp.common.util.ValidateUtils;
import com.idp.common.util.excle.DateUtils;
import com.idp.common.util.excle.ExportExcel;
import com.idp.web.assessment.entity.Assessment;
import com.idp.web.assessment.service.AssessmentService;
import com.idp.web.system.entity.SysDictionary;
import com.idp.web.system.entity.SysRole;
import com.idp.web.system.entity.SysUser;
import com.idp.web.system.service.SysDictionaryService;
import com.idp.web.system.service.SysRoleService;
import com.idp.web.system.service.SysUserService;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 考核评分controller
 * 历史记录：
 * 2017-07-06 mrli
 * 新建文件
 * </pre>
 */
@Controller
@RequestMapping("/assessment")
public class AssessmentController extends BaseController {

    private Logger logger = Logger.getLogger(AssessmentController.class);

    @Resource
    private AssessmentService assessmentService;
    @Resource
    private SysDictionaryService sysDictionaryService;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysRoleService sysRoleService;

    /**
     * <pre>
     * 	2017-07-06 mrli
     * 	初始化查询页面
     * </pre>
     *
     * @return
     */
    @RequestMapping("/init")
    public String init(HttpServletRequest request) {
        SysUser user = getCurrentUser();
        Boolean isLastUser = sysUserService.isLastUser(user.getId());
        SysDictionary sysDictionary = sysDictionaryService.getByCode(AssessmentConstant.DICT_PROJECT);
        request.setAttribute("dictProject", sysDictionary.getChildren());
        request.setAttribute("isLastUser", isLastUser);
        return "assessment/assessmentSearch";
    }

    /**
     * <pre>
     * 	2017-07-06 mrli
     * 	分页查询
     * </pre>
     *
     * @param assessment
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(Assessment assessment, Page<Assessment> page, HttpServletRequest request) {
        try {


            SysDictionary sysDictionary = sysDictionaryService.getByCode(AssessmentConstant.DICT_PROJECT);
            request.setAttribute("dictProject", sysDictionary.getChildren());
            SysDictionary isPositive = sysDictionaryService.getByCode(AssessmentConstant.DICT_IS_POSITIVE);
            request.setAttribute("isPositive", isPositive.getChildren());
            SysDictionary address = sysDictionaryService.getByCode(AssessmentConstant.DICT_ADDRESS);
            request.setAttribute("address", address.getChildren());
            SysUser user = getCurrentUser();
            if (user != null && StringUtils.isNotEmpty(user.getUserCode())) {
                assessment.setUserCode(user.getUserCode());
            }
            request.setAttribute("user", user);
            request.setAttribute("page", assessmentService.findByPage(assessment, page));

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
        }
        return "assessment/assessmentList";
    }


    /**
     * 导出Excel表格
     * @param request
     * @param response
     * @param assessment
     * @param page
     * @return
     */
    @RequestMapping("/export")
    public String exportFile(HttpServletRequest request, HttpServletResponse response,
                             Assessment assessment, Page<Assessment> page
    ) {

        try {
            String fileName = "考核数据" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
            SysUser user = getCurrentUser();
            if (user != null && StringUtils.isNotEmpty(user.getUserCode())) {
                assessment.setUserCode(user.getUserCode());
            }
            List<Assessment> list = assessmentService.findByPageStatisticsMonthExport(assessment);
            List<Assessment> results = new ArrayList<>();
            Map<String, String> dictProject = sysDictionaryService.getByCodeOverride(AssessmentConstant.DICT_PROJECT);
            Map<String, String> dictIsPositive = sysDictionaryService.getByCodeOverride(AssessmentConstant.DICT_IS_POSITIVE);
            Map<String, String> dictAddress = sysDictionaryService.getByCodeOverride(AssessmentConstant.DICT_ADDRESS);
            for (Assessment assessmente : list) {
                assessmente.setRotation(dictIsPositive.get(assessmente.getRotation()));
                assessmente.setAddress(dictAddress.get(assessmente.getAddress()));
                if (StringUtils.isNotEmpty(assessmente.getProjects())) {
                    String projNames = "";
                    String[] projAry = assessmente.getProjects().split(",");
                    for (int i = 0; i < projAry.length; i++) {
                        projNames += dictProject.get(projAry[i]);
                        if ((i + 1) != projAry.length) {
                            projNames += ",";
                        }
                    }
                    assessmente.setProjects(projNames);
                }
                results.add(assessmente);
            }
            new ExportExcel("考核信息", Assessment.class).setDataList(results).write(response, fileName).dispose();
            request.setAttribute("user", user);
            request.setAttribute("page", assessmentService.findByPage(assessment, page));
        } catch (Exception e) {
            logger.error("信息导出失败!");
        }
        return null;
    }

    /**
     * <pre>
     * 	2017-07-06 mrli
     * 	新增修改页面初始化
     * </pre>
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/assessment")
    public String assessment(String id, HttpServletRequest request) {

        try {
            //HttpSession session = ContextHolderUtil.getSession();
            SysUser user = sysUserService.getById(getCurrentUser().getId());
            SysDictionary sysDictionary = sysDictionaryService.getByCode(AssessmentConstant.DICT_PROJECT);
            SysDictionary isPositive = sysDictionaryService.getByCode(AssessmentConstant.DICT_IS_POSITIVE);
            SysDictionary address = sysDictionaryService.getByCode(AssessmentConstant.DICT_ADDRESS);

            List<String> roleIds = sysUserService.findByUserId(user.getId());
            Assessment assessment = new Assessment();
            if (!CollectionUtils.isEmpty(roleIds)) {
                SysRole sysRole = new SysRole();
                sysRole.setId(roleIds.get(0));
                List<SysRole> roleList = sysRoleService.findBySearch(sysRole);
                assessment.setRoleId(roleIds.get(0));
                if (!CollectionUtils.isEmpty(roleList)) {
                    assessment.setRoleName(roleList.get(0).getRoleName());
                }
            }
            assessment.setUserId(user.getId());
            assessment.setUserName(user.getName());
            assessment.setOrgId(user.getOrgCode());
            assessment.setOrgName(user.getOrgName());
            assessment.setRotation(user.getRotationId());
            if (ValidateUtils.isNotEmpty(id)) {
                assessment = assessmentService.getMentById(id);
            }
            request.setAttribute("dictProject", sysDictionary.getChildren());
            request.setAttribute("isPositive", isPositive.getChildren());
            request.setAttribute("address", address.getChildren());

            request.setAttribute("assessment", assessment);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "assessment/assessment";
    }

    /**
     * <pre>
     * 	2017-07-06 mrli
     * 	新增修改页面初始化
     * </pre>
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/assessmentScore")
    public String assessmentScore(String id, HttpServletRequest request) {
        assessment(id, request);
        return "assessment/assessmentScore";
    }


    /***
     * 评分
     * @param assessment
     * @param request
     * @return
     */
    @RequestMapping("/saveScore")
    @ResponseBody
    public String saveScore(Assessment assessment, HttpServletRequest request) {
        JSONObject json = new JSONObject();
        try {
            // 修改
            if (ValidateUtils.isNotEmpty(assessment.getId())) {
                SysDictionary sysDictionary = sysDictionaryService.getByCode(AssessmentConstant.DICT_PROJECT);
                SysDictionary address = sysDictionaryService.getByCode(AssessmentConstant.DICT_ADDRESS);
                request.setAttribute("dictProject", sysDictionary.getChildren());
                request.setAttribute("address", address.getChildren());
                SysUser user = sysUserService.getById(getCurrentUser().getId());
                assessment.setScoreUserId(user.getParentId());
                assessment.setIsCommit(AssessmentConstant.DICT_ISCOMMIT2);
                assessmentService.updateNotNull(assessment);
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
     * 	2017-07-06 mrli
     * 	保存
     * </pre>
     *
     * @param assessment
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(Assessment assessment, HttpServletRequest request) {

        JSONObject json = new JSONObject();

        try {

            // 修改
            if (ValidateUtils.isNotEmpty(assessment.getId())) {
                SysDictionary sysDictionary = sysDictionaryService.getByCode(AssessmentConstant.DICT_PROJECT);
                SysDictionary address = sysDictionaryService.getByCode(AssessmentConstant.DICT_ADDRESS);
                request.setAttribute("dictProject", sysDictionary.getChildren());
                request.setAttribute("address", address.getChildren());
                assessmentService.update(assessment);
            }
            // 新增
            else {
                SysUser user = sysUserService.getById(getCurrentUser().getId());
                //当前用户当月有填写考核信息的不能再进行填写，
                int isassessment = assessmentService.getByUserIdAssessment(user.getId(),assessment.getPasMonth());
                if (isassessment != 0) {
                    json.put("result", "returnNotNull");
                    return json.toString();
                }
                assessment.setScoreUserId(user.getParentId());
                assessmentService.add(assessment);
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
     * 	2017-07-06 mrli
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
            assessmentService.del(id);
            json.put("result", "delete_success");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            json.put("result", "delete_fail");
        }
        return json.toString();
    }
}
