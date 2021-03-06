package org.ithang.tools.init;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.ithang.tools.model.auth.AuthRealm;
import org.ithang.tools.model.auth.CredentialsMatcher;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {

	 @Bean(name="shiroFilter")
	 public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
	        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
	        bean.setSecurityManager(manager);
	        //配置登录的url和登录成功的url
	        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
	        bean.setLoginUrl("/login");
	        bean.setSuccessUrl("/home");
	        
	        
	        // 设置无权限时跳转的 url;
	        bean.setUnauthorizedUrl("/notRole");
	        
	        //配置访问权限
	        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
	        filterChainDefinitionMap.put("/index", "anon");
	        filterChainDefinitionMap.put("/login", "anon"); //表示可以匿名访问
	        filterChainDefinitionMap.put("/sys/**", "roles[user]");
	        //管理员，需要角色权限 “admin”
	        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
	        filterChainDefinitionMap.put("/logout*","anon");
	        filterChainDefinitionMap.put("/static/**","anon");
	        filterChainDefinitionMap.put("/public/**","anon");
	        //其余接口一律拦截
	        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
	        //filterChainDefinitionMap.put("/**", "authc");
	        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
	        return bean;
	    }
	    //配置核心安全事务管理器
	    @Bean(name="securityManager")
	    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
	        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
	        manager.setRealm(authRealm);
	        return manager;
	    }
	    //配置自定义的权限登录器
	    @Bean(name="authRealm")
	    public AuthRealm authRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
	        AuthRealm authRealm=new AuthRealm();
	        authRealm.setCredentialsMatcher(matcher);
	        return authRealm;
	    }
	    //配置自定义的密码比较器
	    @Bean(name="credentialsMatcher")
	    public CredentialsMatcher credentialsMatcher() {
	        return new CredentialsMatcher();
	    }
	    @Bean
	    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
	        return new LifecycleBeanPostProcessor();
	    }
	    @Bean
	    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
	        DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
	        creator.setProxyTargetClass(true);
	        return creator;
	    }
	    @Bean
	    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
	        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
	        advisor.setSecurityManager(manager);
	        return advisor;
	    }

}
