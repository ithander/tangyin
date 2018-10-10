package org.ithang.application;

import org.springframework.stereotype.Controller;
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
	
}
