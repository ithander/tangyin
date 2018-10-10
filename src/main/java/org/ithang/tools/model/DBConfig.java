package org.ithang.tools.model;

public class DBConfig {

	private String uname;
	private String upass;
	private String url;
	
	public DBConfig(String uname,String upass,String url){
		setUname(uname);
		setUpass(upass);
		setUrl(url);
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
