package org.ithang.tools.model;

public enum DBType {

	MySQL(1),Oracle(2);
	
	private int type;
	
	private DBType(int type){
		this.type=type;
	}
	
	
	public int getType() {
		return type;
	}
	
}
