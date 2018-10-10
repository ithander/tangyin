package org.ithang.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.type.Alias;
import org.ithang.system.auth.bean.User;
import org.ithang.tools.filter.session.SessionsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("systemIndex")
@Alias("systemIndex")
@RequestMapping("sys")
public class SystemIndexAction {

	@RequestMapping
	public String index(HttpServletRequest request){
		request.setAttribute("login", 0);
		return "system/login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String getLogin(HttpServletRequest request){
		request.setAttribute("login", 0);
		return "system/login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String postLogin(@RequestParam("uname")String uname,@RequestParam("upass")String upass,HttpServletRequest request,HttpServletResponse response){
		User user=new User();
		user.setUname(uname);
		user.setUpass(upass);
		SessionsManager.updateSession(user, request);
		
		return "redirect:/sys/home";
		//return "forward:/sys/home";
		
	}
	
	@RequestMapping(value="loginout",method=RequestMethod.GET)
	public String loginout(HttpServletRequest request){
		if(SessionsManager.isLogin(request)){
			SessionsManager.clearSession(request);
		}
		return "system/login";
	}
	
	@RequestMapping("home")
	public String home(HttpServletRequest request){
		if(SessionsManager.isLogin(request)){
			return "system/system";
		}
		return "system/login";
	}
	
}
