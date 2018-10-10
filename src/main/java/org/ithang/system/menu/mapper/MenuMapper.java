package org.ithang.system.menu.mapper;

import java.util.List;

import org.ithang.system.menu.bean.Menu;
import org.ithang.tools.model.Page;

public interface MenuMapper {

	
	public Menu get(int id);
	
	public List<Menu> list(Page<Menu> page);
	
}
