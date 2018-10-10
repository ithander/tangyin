package org.ithang.system.menu.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ithang.system.menu.bean.Menu;
import org.ithang.system.menu.service.MenuService;
import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sys/menu")
public class MenuAction extends Action<Menu>{

	@Autowired
	private MenuService menuService;
	
	@RequestMapping("{id}")
	public ActionResult get(@PathVariable("id")int id){
		
		return success();
	}
	
	@RequestMapping("add")
	public ActionResult add(Menu menu){
		
		return success();
	}
	
	@RequestMapping("list")
	public ActionResult list(HttpServletRequest request){
		Page<Menu> page=getPage(request);
		List<Menu> rs=menuService.getMapper().list(page);
		return success(rs);
	}
	
	
	
}
