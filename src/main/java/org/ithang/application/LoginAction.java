package org.ithang.application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.type.Alias;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.ithang.system.auth.bean.User;
import org.ithang.tools.filter.session.SessionsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class LoginAction {

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String getLogin(HttpServletRequest request){
		request.setAttribute("login", 0);
		return "application/login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String postLogin(@RequestParam("uname")String uname,@RequestParam("upass")String upass,HttpServletRequest request,HttpServletResponse response,Model model){
		try{
		    // 从SecurityUtils里边创建一个 subject 
		    Subject subject = SecurityUtils.getSubject(); 
  		    //在认证提交前准备 token（令牌）
		    UsernamePasswordToken token = new UsernamePasswordToken(uname, upass); 
            // 执行认证登陆 
		    subject.login(token);
		    model.addAttribute("login", token.getPrincipal());
		}catch(Exception e){
			model.addAttribute("login", "");
		}
		//return "redirect:/home";
		return "index";
		
	}
	
	@RequestMapping(value="loginout",method=RequestMethod.GET)
	public String loginout(HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
		return "index";
	}
	
	
}
