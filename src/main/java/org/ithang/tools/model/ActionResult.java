package org.ithang.tools.model;

public class ActionResult {

	private int code;//响应码
	private String desc;//描述
	private Object result;//结果数据
	
	private String page;//响应页面
	
	public ActionResult(){
		setCode(0);
		setDesc("操作成功!");
	}
	
	public ActionResult(Object result){
		setCode(0);
		setDesc("操作成功!");
		setResult(result);
	}
	
	public ActionResult(ErrorInfo error){
		setCode(error.getCode());
		setDesc(error.getDesc());
	}
	
	public ActionResult(ErrorInfo error,Object results){
		setCode(error.getCode());
		setDesc(error.getDesc());
		setResult(results);
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
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
}
