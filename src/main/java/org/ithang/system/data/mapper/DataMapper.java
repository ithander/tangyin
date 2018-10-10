package org.ithang.system.data.mapper;

import java.util.List;

import org.ithang.system.data.bean.SysInfo;
import org.ithang.system.data.bean.SysTable;
import org.ithang.tools.model.Page;

public interface DataMapper {

	/**
	 * 最新系统信息
	 * @return
	 */
	public SysInfo info();
	
	/**
	 * 分页得到系统表结构
	 * @return
	 */
	public List<SysTable> tables(Page<SysTable> page);
}
