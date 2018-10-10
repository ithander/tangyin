package org.ithang.tools.filter.session;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionFilter implements HandlerInterceptor{

	/**
	 * 未登陆前可访问的页面
	 */
	private static Set<String> LoginPages=new HashSet<String>();
	
	static{
		LoginPages.add("/sys");
		LoginPages.add("/sys/login");
		LoginPages.add("/sys/home");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		HttpSession session=request.getSession(false);
		String uri=request.getRequestURI();
		String method=request.getMethod().toUpperCase();
		if(null==session){//如果session不存在,则跳到登陆页面
			if(LoginPages.contains(uri)){//如果是登陆页面的请求,则返回true
				return true;
			}
			response.sendRedirect("/sys/login");
		}else{
			return session.getAttribute(SessionsManager.CURRENT_USER)==null?false:true;
		}
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {
		
	}

}
