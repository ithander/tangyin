package org.ithang.system.data.bean;

public class FieldInfo {

	private String field;//字段名称
	private String type;//字段类型
	private String allowNull;//是否可为空
	private String iskey;//是否为主键或外键
	private String defaultValue;//默认值
	private String extra;//其它,如auto_increment自增长
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAllowNull() {
		return allowNull;
	}
	public void setAllowNull(String allowNull) {
		this.allowNull = allowNull;
	}
	public String getIskey() {
		return iskey;
	}
	public void setIskey(String iskey) {
		this.iskey = iskey;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	
	
}
