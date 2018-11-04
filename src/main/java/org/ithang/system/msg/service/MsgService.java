package org.ithang.system.msg.service;

import java.util.List;

import org.ithang.system.msg.bean.MsgTemplate;
import org.ithang.tools.database.ModelDao;
import org.ithang.tools.model.ActionValues;
import org.ithang.tools.sms.SDKMsg;
import org.springframework.stereotype.Service;

@Service
public class MsgService extends ModelDao<MsgTemplate>{

	
	public List<MsgTemplate> list(ActionValues values){
		StringBuilder sber=new StringBuilder("select m.*,u.title user_name from msg_template m left join user_info u on m.user_id=u.id  ");
		
		sber.append(" where 1=1 ");
		if(values.isNotEmpty("user_name")){
			sber.append(" u.title like '%").append(values.getStr("user_name")).append("%' ");
		}
		
		if(values.isNotEmpty("title")){
			sber.append(" m.title like '%").append(values.getStr("title")).append("%' ");
		}
		
		return listsBean(sber.toString());
	}
	
	
	public void send(int temp_id,int num,String[] phones){
		String content=getsStr("select content from msg_template where id=?", temp_id);
		
		if(null!=phones&&phones.length>0){
			SDKMsg.sendXs(phones, content);
		}
		
		if(num>0){
			List<String> tels=listsStr("select phone from phone limit 0,"+num);
			SDKMsg.sendXs(tels.toArray(new String[]{}),content);
		}
	}
	
}
