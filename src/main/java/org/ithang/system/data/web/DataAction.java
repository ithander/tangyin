package org.ithang.system.data.web;

import java.util.List;
import java.util.Map;

import org.ithang.system.data.bean.Data;
import org.ithang.system.data.bean.SysInfo;
import org.ithang.system.data.bean.SysTable;
import org.ithang.system.data.service.DataService;
import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * 管理平台，控制台页面，显示各种统计信息
 * @author zyt
 *
 */
@Controller
@RequestMapping("system/data")
public class DataAction extends Action<Data>{

	@Autowired
	private DataService dataService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		Map<String,Object> data=null;
		model.addAttribute("data", data);
		return "system/data/index";
	}
	
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
