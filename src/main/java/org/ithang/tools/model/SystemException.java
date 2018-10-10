package org.ithang.tools.model;

public class SystemException extends RuntimeException {

	private static final long serialVersionUID = -3165700461286562376L;

	private int code=0;
	
	public SystemException(String msg){
		super(msg);
	}
	
	
	public SystemException(int code,String msg){
		super(msg);
		setCode(code);
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}
	
	
	
	
}
