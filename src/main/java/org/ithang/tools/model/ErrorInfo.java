package org.ithang.tools.model;

/**
 * 报错信息
 * @author zyt
 *
 */
public enum ErrorInfo {

	
	UnknowError(1,"未知错误"),
	InternalError(2,"内部异常");
	
	private int code;
	private String desc;
	
	private ErrorInfo(int _code,String _desc){
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
}
