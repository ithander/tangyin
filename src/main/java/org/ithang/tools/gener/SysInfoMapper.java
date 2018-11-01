package org.ithang.tools.gener;

import java.util.List;

import org.ithang.tools.model.Page;

public interface SysInfoMapper {

	
	public SysInfo get(int id);
	
	public List<SysInfo> list(Page<SysInfo> page);
	
	public int update(SysInfo sysInfo);
	
	public int delete(int id);
	
}