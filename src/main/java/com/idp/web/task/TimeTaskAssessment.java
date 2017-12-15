/*
package com.idp.web.task;

import com.idp.web.system.entity.SysUser;
import com.idp.web.system.service.SysUserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.idp.common.util.SendMailUtil.sendFtlMail;

*/
/**
 * Created by sulite on 2017/11/2.
 *//*

public class TimeTaskAssessment {

    @Resource
    private SysUserService sysUserService;

    private Logger logger = Logger.getLogger(TimeTaskDemo.class);


    */
/**
     * 对未提交月度考核的人员进行邮件提醒
     *//*

    public void runAssessmentEmailTask() {
        logger.info("===============Assessment定时任务开始==================");
        SysUser sysUser = new SysUser();
        List<SysUser> listUser = sysUserService.getByCountMonthEmail(sysUser);
        for (SysUser user : listUser) {
            Map<String, Object> map = new HashMap<>();
            map.put("subject", "您好:" + user.getName());
            map.put("content", "pas.vpclub.cn");
            String templatePath = "assessmentEmail.ftl";
            sendFtlMail(user.getEmail(), "考核系统", templatePath, map);
        }
    }
}


*/
