package org.ithang.system.auth.web;


import org.ithang.system.auth.bean.User;
import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("sys/auth")
public class AuthController extends Action<User>{

	@RequestMapping(value="users",method=RequestMethod.GET)
	public ActionResult users(){
		return success();
	}
	
}
