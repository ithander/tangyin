package org.ithang.tools.init;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目初始化
 * @author ithang
 *
 */
@Component
@ConfigurationProperties(prefix = "project.config")
public class ProjectInitializer {

	private static String profile;

	/**
	 * 得到项目主目录
	 * @return
	 */
	public static String getHomeDir(){
		return ProjectInitializer.class.getClassLoader().getResource(".").getPath();
	}
	
	public static String getProfile() {
		return profile;
	}

	public static void setProfile(String profile) {
		ProjectInitializer.profile = profile;
	}
	
	
}
