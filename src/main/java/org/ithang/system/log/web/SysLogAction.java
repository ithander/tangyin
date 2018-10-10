package org.ithang.system.log.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ithang.system.log.bean.SysLog;
import org.ithang.system.log.service.SysLogService;
import org.ithang.tools.lang.DateUtils;
import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.Const;
import org.ithang.tools.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sys/log")
public class SysLogAction extends Action<SysLog>{

	@Autowired
	private SysLogService sysLogService;
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	@ResponseBody
	public void insert(){
		SysLog log=new SysLog();
		log.setContent("test:"+System.currentTimeMillis());
		log.setCreate_time(DateUtils.getSystime());
		log.setLog_type(Const.LogType_SystemBoot);
		log.setOperator("system");
		sysLogService.insert(log);
	}

	@ResponseBody
	@RequestMapping("list")
	public ActionResult list(HttpServletRequest request){
		Page<SysLog> page=getPage(request);
		List<SysLog> result=sysLogService.list(page);
		page.setData(result);
		return success(page);
	}
	
}
