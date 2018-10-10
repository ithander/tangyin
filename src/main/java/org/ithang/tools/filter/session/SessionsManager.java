package org.ithang.tools.filter.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ithang.system.auth.bean.User;

public class SessionsManager {
	
	public static String CURRENT_USER="cuser";

	/**
	 * 是否登陆
	 * @param uname
	 * @param request
	 * @return
	 */
	public static boolean isLogin(HttpServletRequest request){
		HttpSession session=request.getSession(false);
		if(null!=session){
			return session.getAttribute(CURRENT_USER)==null?false:true;
		}
		return false;
	}
	
	/**
	 * 更新session
	 * @param user
	 * @param request
	 */
	public static String updateSession(User user,HttpServletRequest request){
		HttpSession session=request.getSession(true);
		session.setAttribute(CURRENT_USER, user);
		return session.getId();
	}
	
	public static void clearSession(HttpServletRequest request){
		HttpSession session=request.getSession(false);
		if(null!=session){
			session.removeAttribute(CURRENT_USER);
		}
	}
	
}
