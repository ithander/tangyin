package org.ithang.system.auth.service;

import java.util.List;

import org.ithang.system.auth.bean.User;
import org.ithang.tools.database.ModelDao;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ModelDao<User>{

	
	public User getUser(String uname,String upass){
		User u=getBean("select * from user_info where uname=? and upass=?",uname,upass);
		return u;
	}
	
	
	public List<String> listRoles(int user_id){
	    return listsStr("select role from user_role where user_id=?", user_id);
	}
	
	public List<String> listResources(int user_id){
		return listsStr("select role from user_resource where user_id=?", user_id);
	}
}
