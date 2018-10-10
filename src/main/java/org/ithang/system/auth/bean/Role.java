package org.ithang.system.auth.bean;

/**
 * 角色表
 * @author ithang
 *
 */
public class Role {

	private String id;//英文标识
	private String title;//中文标识
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
