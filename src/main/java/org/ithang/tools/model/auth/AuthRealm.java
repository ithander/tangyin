package org.ithang.tools.model.auth;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.ithang.system.auth.bean.User;
import org.ithang.system.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		User user = (User) pc.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(userService.listRoles(user.getId()));
		//info.addStringPermissions(resourceManager.getResourceNameByUser(shiroUser.getId()));
		return info;
	}

	/**
	 * 用户认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
		
		UsernamePasswordToken token = (UsernamePasswordToken) authToken; 
		// 从数据库获取对应用户名密码的用户 
		User user = userService.getUser(token.getUsername(), String.valueOf(token.getPassword())); 
		if (null == user) { 
			 throw new AccountException("用户名或密码不正确"); 
	    }
		return  new SimpleAuthenticationInfo(user, user.getUpass(), user.getTitle());
	}

	
	
}
