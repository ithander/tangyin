package org.ithang.tools.filter;

import org.ithang.tools.filter.session.SessionFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FilterConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionFilter()).addPathPatterns("/**");
		registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
		//registry.addWebRequestInterceptor(interceptor)
	}
}
