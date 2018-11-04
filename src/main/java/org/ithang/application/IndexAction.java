package org.ithang.application;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.ithang.system.auth.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 业务首页面
 * @author zyt
 *
 */
@Controller("applicationIndex")
public class IndexAction {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(){
		return "index";
	}
	
	
	
	@RequestMapping(value="/self",method=RequestMethod.GET)
	public String self(Model model){
		Subject subject = SecurityUtils.getSubject();
		User user=(User)subject.getPrincipal();
		if(null==user){
			return "index";
		}
		model.addAttribute("user", user);
		if(1==user.getAdmin()){//如果是管理员账号
			return "system/index";
		}else{
			return "application/index";	
		}
		
	}
	
	
}
