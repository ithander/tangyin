package org.ithang.system.data.bean;

import java.util.List;

public class TableInfo {

	private String tableName;
	private List<FieldInfo> fields;

	public TableInfo(){}
	
	public TableInfo(String tableName,List<FieldInfo> fields){
		setTableName(tableName);
		setFields(fields);
	}
	
	
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<FieldInfo> getFields() {
		return fields;
	}

	public void setFields(List<FieldInfo> fields) {
		this.fields = fields;
	}
	
}
