package org.ithang.system.auth.service;

import org.ithang.system.auth.bean.User;
import org.ithang.tools.database.ModelDao;
import org.ithang.tools.lang.JsonUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ModelDao<User>{

	
	public User getUser(String uname,String upass){
		User u=getBean("select * from user_info where uname=? and upass=?",uname,upass);
		return u;
	}
}
