package org.ithang;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@ComponentScan("org.ithang.**")
@MapperScan(basePackages={"org.ithang.**.mapper"})
public class BootstrapApplication extends SpringBootServletInitializer{

	private final static Logger logger=LoggerFactory.getLogger(BootstrapApplication.class);
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
	}
	
	//初始化模拟数据
	@Bean
	public CommandLineRunner init(){
		return new CommandLineRunner() {
			public void run(String... strings) throws Exception {
				
			}
		};		
	}
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
	   return (container -> {
	        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
	        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
	        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
	        container.addErrorPages(error401Page, error404Page, error500Page);
	   });
	}
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(BootstrapApplication.class, args);
		logger.info("系统启动成功!");
	}
	
	
	
}
