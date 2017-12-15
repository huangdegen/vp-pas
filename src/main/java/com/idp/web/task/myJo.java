package com.idp.web.task;

import com.idp.web.system.entity.SysUser;
import com.idp.web.system.service.SysUserService;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.idp.common.util.SendMailUtil.sendFtlMail;

/*
 * Created by sulite on 2017/11/2.
 */


public class myJo implements Job {
    @Resource
    private SysUserService sysUserService;

    private Logger logger = Logger.getLogger(TimeTaskDemo.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("===============Reporting定时任务开始==================");
        SysUser sysUser = new SysUser();
        List<SysUser> listUser = sysUserService.getByCountEmail(sysUser);
        for (SysUser user : listUser) {
            Map<String, Object> map = new HashMap<>();
            map.put("subject", "您好:" + user.getName());
            map.put("content", "pas.vpclub.cn");
            String templatePath = "reportingEmail.ftl";
            //sendFtlMail(user.getEmail(), "考核系统", templatePath, map);
        }
    }
}
