package org.ithang.system.log.mapper;

import java.util.List;

import org.ithang.system.log.bean.SysLog;
import org.ithang.tools.model.Page;

public interface SysLogMapper {

	/**
	 * 得到指定日志
	 * @param sysLog_id
	 * @return
	 */
	public SysLog get(long sysLog_id);
	
	/**
	 * 分页查询日志
	 * @param page
	 * @return
	 */
	public List<SysLog> list(Page<SysLog> page);
	
	/**
	 * 新增系统日志
	 * @param sysLog
	 * @return
	 */
	public int insert(SysLog sysLog);
	
	
	/**
	 * 按条件修改系统日志
	 * @param syslog
	 * @return
	 */
	public int delete(SysLog syslog);
	
}
