package org.ithang.system.data.web;

import java.util.List;

import org.ithang.system.data.bean.Data;
import org.ithang.system.data.bean.SysInfo;
import org.ithang.system.data.bean.SysTable;
import org.ithang.system.data.service.DataService;
import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系统数据维护功能
 * 包括:
 * 系统安装初始化与升级
 * 菜单管理
 * 表结构管理
 * @author zyt
 *
 */
@Controller
@RequestMapping("system/data")
public class DataAction extends Action<Data>{

	@Autowired
	private DataService dataService;
	
	@RequestMapping(value="info",method=RequestMethod.GET)
	public ActionResult info(){
		SysInfo info=dataService.info();
		return page("info",info);
	}
	
	@RequestMapping(value="tables",method=RequestMethod.GET)
	public ActionResult tables(Page<SysTable> page){
		List<SysTable> tables=dataService.tables(page);
		page.setData(tables);
		return success(page);
	}
	
}
