package org.ithang.system.phone.service;

import org.ithang.system.phone.bean.Phone;
import org.ithang.tools.database.ModelDao;
import org.springframework.stereotype.Service;

@Service
public class PhoneService extends ModelDao<Phone>{

	
	public int addPhone(String phone){
		return addPhone(phone,null);
	}
	
	public int addPhone(String phone,String area){
		if(null==area){
			area="";
		}
		try{
			if(0==getsInt("select count(0) from phone where phone=?", phone)){
			    return updatesSQL("insert into (phone,area)values(?,?)", phone,area);				
			}
		}catch(Exception e){
			
		}
		return 0;
		
	}
	
}
