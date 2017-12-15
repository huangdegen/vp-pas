/*
package com.idp.web.task;

import com.idp.web.system.entity.SysUser;
import com.idp.web.system.service.SysUserService;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.idp.common.util.SendMailUtil.sendFtlMail;

public class TimeTaskReporting {

    @Resource
    private SysUserService sysUserService;

    private Logger logger = Logger.getLogger(TimeTaskDemo.class);

    */
/**
     * 星期天 到 星期一
     * SUN MON TUE WED THU FRI SAT
     * 对未提交工时填报的人员进行邮件提醒
     *//*

    public void runReportingTask() {
        logger.info("===============Reporting定时任务开始==================");
        SysUser sysUser = new SysUser();
        List<SysUser> listUser = sysUserService.getByCountEmail(sysUser);
        for (SysUser user : listUser) {
            Map<String, Object> map = new HashMap<>();
            map.put("subject", "您好:" + user.getName());
            map.put("content", "pas.vpclub.cn");
            String templatePath = "reportingEmail.ftl";
            sendFtlMail(user.getEmail(), "考核系统", templatePath, map);
        }
    }
}
*/
