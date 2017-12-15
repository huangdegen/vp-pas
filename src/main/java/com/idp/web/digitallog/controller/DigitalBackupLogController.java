package com.idp.web.digitallog.controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idp.common.base.BaseController;
import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;
import com.idp.common.util.ValidateUtils;
import com.idp.web.digitallog.entity.DigitalBackupLog;
import com.idp.web.digitallog.service.DigitalBackupLogService;

import net.sf.json.JSONObject;

/**
 * 
 * 数据库备份日志controller
 * 
 * <pre>
 * 	历史记录：
 * 	2017-06-22 123
 * 	新建文件
 * </pre>
 * 
 * @author
 * 
 * 		<pre>
 * SD
 * 	123
 * PG
 *	123
 * UT
 *
 * MA
 *         </pre>
 * 
 * @version $Rev$
 *
 *          <p/>
 *          $Id$
 *
 */
@Controller
@RequestMapping("/digitalBackupLog")
public class DigitalBackupLogController extends BaseController {

	private Logger logger = Logger.getLogger(DigitalBackupLogController.class);

	@Resource
	private DigitalBackupLogService digitalBackupLogService;

	/**
	 * 
	 * <pre>
	 * 	2017-06-22 123
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init() {

		return "digitallog/digitalBackupLogSearch";
	}

	@RequestMapping("/digitalBackup")
	public String digitalBackup() {
		try {
			Runtime rt = Runtime.getRuntime();

			// 调用 mysql 的 cmd:
			Process child = rt.exec("mysqldump -uroot -p123456 --set-charset=utf8 jeeidp");// 设置导出编码为utf8。这里必须是utf8

			// 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
			InputStream in = child.getInputStream();// 控制台的输出信息作为输入流

			InputStreamReader xx = new InputStreamReader(in, "utf8");// 设置输出流编码为utf8。这里必须是utf8，否则从流中读入的是乱码

			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			// 组合控制台输出信息字符串
			BufferedReader br = new BufferedReader(xx);
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();

			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String sdate = sdf.format(date);

			String fileUrl = "e:/";
			String fileName = sdate + "jeeidp-bak.sql";
			// 要用来做导入用的sql目标文件：
			FileOutputStream fout = new FileOutputStream(fileUrl + fileName);
			OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8");
			writer.write(outStr);
			// 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免
			writer.flush();

			// 别忘记关闭输入输出流
			in.close();
			xx.close();
			br.close();
			writer.close();
			fout.close();

			System.out.println("/* Output OK! */");

			DigitalBackupLog digitalBackupLog = new DigitalBackupLog();
			digitalBackupLog.setId(ResourceUtils.getUUID());
			digitalBackupLog.setTime(date);
			digitalBackupLog.setStoreUrl(fileUrl + fileName);
			digitalBackupLog.setFileName(fileName);
			digitalBackupLogService.add(digitalBackupLog);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "digitallog/digitalBackupLogSearch";
	}

	/**
	 * 
	 * <pre>
	 * 	2017-06-22 123
	 * 	分页查询
	 * </pre>
	 * 
	 * @param digitalBackupLog
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(DigitalBackupLog digitalBackupLog, Page<DigitalBackupLog> page, HttpServletRequest request) {

		try {

			request.setAttribute("page", digitalBackupLogService.findByPage(digitalBackupLog, page));
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}

		return "digitallog/digitalBackupLogList";
	}

	/**
	 * 
	 * <pre>
	 * 	2017-06-22 123
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/digitalBackupLog")
	public String digitalBackupLog(String id, HttpServletRequest request) {

		try {

			if (ValidateUtils.isNotEmpty(id)) {

				DigitalBackupLog digitalBackupLog = digitalBackupLogService.getById(id);
				request.setAttribute("digitalBackupLog", digitalBackupLog);
			}
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}

		return "digitallog/digitalBackupLog";
	}

	/**
	 * 
	 * <pre>
	 * 	2017-06-22 123
	 * 	保存
	 * </pre>
	 * 
	 * @param digitalBackupLog
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(DigitalBackupLog digitalBackupLog) {

		JSONObject json = new JSONObject();

		try {

			// 修改
			if (ValidateUtils.isNotEmpty(digitalBackupLog.getId())) {

				digitalBackupLogService.update(digitalBackupLog);
			}
			// 新增
			else {

				digitalBackupLogService.add(digitalBackupLog);
			}
			json.put("result", "save_success");
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
			json.put("result", "save_fail");
		}

		return json.toString();
	}

	/**
	 * 
	 * <pre>
	 * 	2017-06-22 123
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

			digitalBackupLogService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}

		return json.toString();
	}
}
