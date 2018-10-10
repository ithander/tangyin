package org.ithang.system.menu.service;

import org.ithang.system.menu.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	public MenuMapper getMapper(){
		return menuMapper;
	}
	
}
