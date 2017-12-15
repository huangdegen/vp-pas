package com.idp.web.task;

import com.idp.common.persistence.Page;
import com.idp.web.system.entity.SysUser;
import com.idp.web.system.service.SysUserService;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.idp.common.util.SendMailUtil.sendFtlMail;

/**
 * 定时任务范例类
 *
 * @author King
 */
@Component
public class TimeTaskDemo {

    @Resource
    private SysUserService sysUserService;

    private Logger logger = Logger.getLogger(TimeTaskDemo.class);

    @PostConstruct
    public void init() {
        logger.info("===============init==================");
    }

   /* @Scheduled(cron = "0/5 * * * * ?")
    public void doSomething() {
        // something that should execute periodically
        logger.info("===============doSomething==================");
    }*/

    /**
     * 运行方法
     * <p>
     * 星期天 到 星期一
     * SUN MON TUE WED THU FRI SAT
     */
    public void runReportingTask() {
        logger.info("===============Reporting定时任务开始==================");
        SysUser sysUser = new SysUser();
        List<SysUser> listUser = sysUserService.getByCountEmail(sysUser);
        for (SysUser user : listUser) {
            Map<String, Object> map = new HashMap<>();
            map.put("subject", "您好:" + user.getName());
            map.put("content", "pas.vpclub.cn");
            String templatePath = "reportingEmail.ftl";
            String templaePath = "reportingEmail.ftl";
            //sendFtlMail(user.getEmail(), "考核系统", templatePath, map);
        }
    }

    public void runAssessmentEmailTask() {
        logger.info("===============Assessment定时任务开始==================");
        SysUser sysUser = new SysUser();
        List<SysUser> listUser = sysUserService.getByCountMonthEmail(sysUser);
        for (SysUser user : listUser) {
            Map<String, Object> map = new HashMap<>();
            map.put("subject", "您好:" + user.getName());
            map.put("content", "pas.vpclub.cn");
            String templatePath = "assessmentEmail.ftl";
            //sendFtlMail(user.getEmail(), "考核系统", templatePath, map);
        }
    }
}
