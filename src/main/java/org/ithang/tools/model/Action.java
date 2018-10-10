package org.ithang.tools.model;

import javax.servlet.http.HttpServletRequest;

public class Action<T> {

	protected Page<T> getPage(HttpServletRequest request){
		return new Page<T>(request);
	}
	
	protected ActionValues getValues(HttpServletRequest request){
		return new ActionValues(request);
	}
	
	protected ActionResult success(){
		return new ActionResult();
	}
	
	protected ActionResult success(Object obj){
		return new ActionResult(obj);
	}
	
	protected ActionResult page(String page){
		ActionResult r=new ActionResult();
		r.setPage(page);
		return r;
	}
	
	protected ActionResult page(String page,Object obj){
		ActionResult r=new ActionResult();
		r.setPage(page);
		r.setResult(obj);
		return r;
	}
	
	protected ActionResult error(ErrorInfo error){
		return new ActionResult(error);
	}
	
}
