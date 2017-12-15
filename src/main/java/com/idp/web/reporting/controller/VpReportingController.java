package com.idp.web.reporting.controller;

import com.idp.common.base.BaseController;
import com.idp.common.constant.AssessmentConstant;
import com.idp.common.persistence.Page;
import com.idp.common.util.ValidateUtils;
import com.idp.common.util.excle.DateUtils;
import com.idp.common.util.excle.ExportExcel;
import com.idp.web.reporting.entity.VpReporting;
import com.idp.web.reporting.entity.WorkingHoursStatistical;
import com.idp.web.reporting.service.VpReportingService;
import com.idp.web.system.entity.SysDictionary;
import com.idp.web.system.entity.SysUser;
import com.idp.web.system.service.SysDictionaryService;
import com.idp.web.system.service.SysUserService;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
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
 * 工时填报controller
 */
@Controller
@RequestMapping("/vpReportings")
public class VpReportingController extends BaseController {

    private Logger logger = Logger.getLogger(VpReportingController.class);

    @Resource
    private SysUserService sysUserService;

    @Resource
    private VpReportingService vpReportingService;

    @Resource
    private SysDictionaryService sysDictionaryService;

    /**
     * <pre>
     * 	2017-07-21 liyi
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
        return "reporting/vpReportingSearch";
    }

    /**
     * 导出Excel表格
     *
     * @param request
     * @param response
     * @param vpReporting
     * @param page
     * @return
     */
    @RequestMapping("/export")
    public String exportFile(HttpServletRequest request, HttpServletResponse response,
                             VpReporting vpReporting, Page<VpReporting> page
    ) {

        try {
            String fileName = "工时填报信息" + DateUtils.getDate("yyyyMMddHH") + ".xlsx";
            SysUser user = getCurrentUser();
            if (user != null && StringUtils.isNotEmpty(user.getUserCode())) {
                vpReporting.setUserCode(user.getUserCode());
            }
            List<VpReporting> list = vpReportingService.findExportAll(vpReporting);
            List<VpReporting> results = new ArrayList<>();
            Map<String, String> dictProject = sysDictionaryService.getByCodeOverride(AssessmentConstant.DICT_PROJECT);
            for (VpReporting Reporting : list) {
                if (StringUtils.isNotEmpty(Reporting.getReportingProject())) {
                    String projNames = "";
                    String[] projAry = Reporting.getReportingProject().split(",");
                    for (int i = 0; i < projAry.length; i++) {
                        projNames += dictProject.get(projAry[i]);
                        if ((i + 1) != projAry.length) {
                            projNames += ",";
                        }
                    }
                    Reporting.setReportingProject(projNames);
                }
                results.add(Reporting);
            }
            new ExportExcel("工时填报信息", VpReporting.class).setDataList(results).write(response, fileName).dispose();
            request.setAttribute("user", user);
            request.setAttribute("page", vpReportingService.findByPage(vpReporting, page));
        } catch (Exception e) {
            logger.error("信息导出失败!");
        }
        return null;
    }

    /**
     * 导出Excel表格
     *
     * @param response
     * @param workingHoursStatistical
     * @return
     */
    @RequestMapping("/StatisticalExport")
    public String exportFileStatistical(HttpServletResponse response,
                                        WorkingHoursStatistical workingHoursStatistical

    ) {
        try {
            String fileName = "统计工时百分比信息" + DateUtils.getDate("yyyyMMddHH") + ".xlsx";
            List<WorkingHoursStatistical> list = vpReportingService.statisticalHours(workingHoursStatistical);
            new ExportExcel("统计工时信息", WorkingHoursStatistical.class).setDataList(list).write(response, fileName).dispose();
        } catch (Exception e) {
            logger.error("信息导出失败!", e);
        }
        return null;
    }


    /**
     * <pre>
     * 	2017-07-21 liyi
     * 	分页查询
     * @param vpReporting
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(VpReporting vpReporting, Page<VpReporting> page, HttpServletRequest request) {

        try {
            SysDictionary sysDictionary = sysDictionaryService.getByCode(AssessmentConstant.DICT_PROJECT);
            SysDictionary time = sysDictionaryService.getByCode(AssessmentConstant.DICT_TIME);
            request.setAttribute("dictProject", sysDictionary.getChildren());
            request.setAttribute("dictTime", time.getChildren());
            SysUser user = getCurrentUser();
            if (user != null && StringUtils.isNotEmpty(user.getUserCode())) {
                vpReporting.setUserCode(user.getUserCode());
            }
            request.setAttribute("user", user);
            request.setAttribute("page", vpReportingService.findByPage(vpReporting, page));
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
        }

        return "reporting/vpReportingList";
    }

    /**
     * <pre>
     * 	2017-07-21 liyi
     * 	新增修改页面初始化
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/vpReporting")
    public String vpReporting(String id, HttpServletRequest request) {

        try {
            SysUser user = sysUserService.getById(getCurrentUser().getId());

            SysDictionary sysDictionary = sysDictionaryService.getByCode(AssessmentConstant.DICT_PROJECT);
            SysDictionary time = sysDictionaryService.getByCode(AssessmentConstant.DICT_TIME);
            VpReporting vpReporting = new VpReporting();
            vpReporting.setUserId(user.getId());
            vpReporting.setReportingName(user.getName());
            vpReporting.setReportingDate(new Date());
            vpReporting.setOrgId(user.getOrgCode());
            vpReporting.setOrgName(user.getOrgName());
            if (ValidateUtils.isNotEmpty(id)) {
                vpReporting = vpReportingService.getById(id);
            }
            request.setAttribute("vpReporting", vpReporting);
            request.setAttribute("dictProject", sysDictionary.getChildren());
            request.setAttribute("dictTime", time.getChildren());
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
        }

        return "reporting/vpReporting";
    }

    @RequestMapping("/vpReportingDetails")
    public String vpReportingDetails(String id, HttpServletRequest request) {
        SysUser user = sysUserService.getById(getCurrentUser().getId());
        SysDictionary sysDictionary = sysDictionaryService.getByCode(AssessmentConstant.DICT_PROJECT);
        SysDictionary time = sysDictionaryService.getByCode(AssessmentConstant.DICT_TIME);
        VpReporting vpReporting = new VpReporting();
        vpReporting.setUserId(user.getId());
        vpReporting.setReportingName(user.getName());
        vpReporting.setReportingDate(new Date());
        if (ValidateUtils.isNotEmpty(id)) {
            vpReporting = vpReportingService.getById(id);
        }
        request.setAttribute("vpReporting", vpReporting);
        request.setAttribute("dictProject", sysDictionary.getChildren());
        request.setAttribute("time", time.getChildren());
        return "reporting/vpReportingDetails";
    }

    /**
     * <pre>
     * 	2017-07-21 liyi
     * 	保存
     * @param vpReporting
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(VpReporting vpReporting, HttpServletRequest request) {

        JSONObject json = new JSONObject();
        SysUser user = sysUserService.getById(getCurrentUser().getId());
        try {

            // 修改
            if (ValidateUtils.isNotEmpty(vpReporting.getId())) {
                SysDictionary time = sysDictionaryService.getByCode(AssessmentConstant.DICT_TIME);
                vpReporting.setUserId(user.getId());
                request.setAttribute("time", time.getChildren());
                if (vpReporting.getReportingTime().intValue() > 8) {
                    json.put("result", "notReportingTime");
                    return json.toString();
                }
                int countTime = vpReportingService.getSumReportingTime(vpReporting);
                if ((vpReporting.getReportingTime().intValue() + countTime) > 8) {
                    json.put("result", "countReportingTime");
                    return json.toString();
                }
                vpReportingService.update(vpReporting);
            }
            // 新增
            else {
                vpReporting.setUserId(user.getId());
                if (vpReporting.getReportingTime().intValue() > 8) {
                    json.put("result", "notReportingTime");
                    return json.toString();
                }
                int countTime = vpReportingService.getSumReportingTime(vpReporting);
                if ((vpReporting.getReportingTime().intValue() + countTime) > 8) {
                    json.put("result", "countReportingTime");
                    return json.toString();
                }

                vpReportingService.add(vpReporting);
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
     * 	2017-07-21 liyi
     * 	删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String id) {

        JSONObject json = new JSONObject();

        try {

            vpReportingService.delete(id);
            json.put("result", "delete_success");
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            json.put("result", "delete_fail");
        }

        return json.toString();
    }
}
