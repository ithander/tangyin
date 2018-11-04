package org.ithang.system.msg.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ithang.system.msg.bean.MsgTemplate;
import org.ithang.system.msg.service.MsgService;
import org.ithang.tools.model.ActionValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("sys/msg")
public class MSGAction {

	@Autowired
	private MsgService msgService;
	
	@RequestMapping("temp_list")
	public String templateList(HttpServletRequest request,Model model){
		ActionValues values=new ActionValues(request);
		List<MsgTemplate> temps=msgService.list(values);
		model.addAttribute("temps", temps);
		return "system/msg/temp_list";
		
	}
	
	@RequestMapping("tosend/{temp_id}")
	public String tosend(@PathVariable int temp_id,HttpServletRequest request,Model model){
		ActionValues values=new ActionValues(request);
		List<MsgTemplate> temps=msgService.list(values);
		model.addAttribute("temps", temps);
		model.addAttribute("temp_id", temp_id);
		return "system/msg/send_page";
	}
	
	@RequestMapping(value="send",method=RequestMethod.POST)
	public String send(int temp_id,@RequestParam(value="num",required=false,defaultValue="0")int num,@RequestParam(value="phones",required=false,defaultValue="")String phones){
		msgService.send(temp_id, num, phones.split("\r\n"));
		return "system/msg/send_page";
	}
	
	
}
