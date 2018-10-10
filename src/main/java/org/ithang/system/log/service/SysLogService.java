package org.ithang.system.log.service;

import java.util.List;

import org.ithang.system.log.bean.SysLog;
import org.ithang.system.log.mapper.SysLogMapper;
import org.ithang.tools.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogService {

	
	@Autowired
	private SysLogMapper sysLogMapper;
	
	
	public SysLog get(long id){
		return sysLogMapper.get(id);
	}
	
	public List<SysLog> list(Page<SysLog> page){
		return sysLogMapper.list(page);
	}
	
	public int insert(SysLog log){
		return sysLogMapper.insert(log);
	}
	
	public int delete(SysLog log){
		return sysLogMapper.delete(log);
	}
	
}
