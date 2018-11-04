package org.ithang.tools.sms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

public class SDKMsg {

	private final static int appid=1400157887;
	private final static String appkey="3496723934772e0163c43224a8ceff2a";
	
	/**
	 * 
	 * @param phone
	 * @param templateId
	 * @param sign
	 * @param params //数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
	 */
	public static SmsSingleSenderResult send(String phone,int templateId,String signTxt,String[] params){
		try {
		    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
		    
		    //签名参数未提供或者为空时，会使用默认签名发送短信
		    SmsSingleSenderResult result = ssender.sendWithParam("86", phone,templateId, params, signTxt, "", "");  
		    return result;
		} catch (HTTPException e) {
		    // HTTP响应码错误
		    e.printStackTrace();
		} catch (JSONException e) {
		    // json解析错误
		    e.printStackTrace();
		} catch (IOException e) {
		    // 网络IO错误
		    e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 发送单条营销短信
	 * @param phone
	 * @param templateId
	 * @param sign
	 * @param params //数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
	 */
	public static SmsSingleSenderResult sendX(String phone,String msg){
		try {
		    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
		    
		    //签名参数未提供或者为空时，会使用默认签名发送短信
		    SmsSingleSenderResult result=ssender.send(1,"86", phone, msg, "", "");
		    return result;
		} catch (HTTPException e) {
		    // HTTP响应码错误
		    e.printStackTrace();
		} catch (JSONException e) {
		    // json解析错误
		    e.printStackTrace();
		} catch (IOException e) {
		    // 网络IO错误
		    e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 批量发送营销短信
	 * @param phones
	 * @param templateId
	 * @param signTxt
	 * @param params  数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
	 * @return
	 */
	public static void sendXs(String[] phones,String msg){
		try{
			int len=phones.length;
			SmsMultiSender msender = new SmsMultiSender(appid, appkey);
			if(phones.length>200){
				ArrayList<String> subPhones=new ArrayList<>();
				for(int i=0;i<len;i++){
					subPhones.add(phones[i]);
					if(200==subPhones.size()){
						//签名参数未提供或者为空时，会使用默认签名发送短信
						msender.send(1, "86", subPhones, msg, "", "");
				        subPhones.clear();
					}
				}
				if(subPhones.size()>0){
					msender.send(1, "86", subPhones, msg, "", "");
				}
			}else{
		        //签名参数未提供或者为空时，会使用默认签名发送短信
		        SmsMultiSenderResult result =  msender.send(1,"86", phones,msg,  "", "");
			}
		}catch (HTTPException e) {
		    // HTTP响应码错误
		    e.printStackTrace();
		} catch (JSONException e) {
		    // json解析错误
		    e.printStackTrace();
		} catch (IOException e) {
		    // 网络IO错误
		    e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param phones
	 * @param templateId
	 * @param signTxt
	 * @param params  数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
	 * @return
	 */
	public static void sends(String[] phones,int templateId,String signTxt,String[] params){
		try{
			int len=phones.length;
			SmsMultiSender msender = new SmsMultiSender(appid, appkey);
			if(phones.length>200){
				List<String> subPhones=new ArrayList<>();
				for(int i=0;i<len;i++){
					subPhones.add(phones[i]);
					if(200==subPhones.size()){
						//签名参数未提供或者为空时，会使用默认签名发送短信
				        SmsMultiSenderResult result =  msender.sendWithParam("86", subPhones.toArray(new String[]{}),templateId, params, signTxt, "", "");
				        subPhones.clear();
					}
				}
				if(subPhones.size()>0){
					SmsMultiSenderResult result =  msender.sendWithParam("86", subPhones.toArray(new String[]{}),templateId, params, signTxt, "", "");
				}
			}else{
		        //签名参数未提供或者为空时，会使用默认签名发送短信
		        SmsMultiSenderResult result =  msender.sendWithParam("86", phones,templateId, params, signTxt, "", "");
			}
		}catch (HTTPException e) {
		    // HTTP响应码错误
		    e.printStackTrace();
		} catch (JSONException e) {
		    // json解析错误
		    e.printStackTrace();
		} catch (IOException e) {
		    // 网络IO错误
		    e.printStackTrace();
		}
	}
	
	
	
	/*public static void main(String[] args) {
		// 短信应用SDK AppID
		int appid = 1400157887; // 1400开头

		// 短信应用SDK AppKey
		String appkey = "3496723934772e0163c43224a8ceff2a";

		// 需要发送短信的手机号码                                                                     
		String[] phoneNumbers = { "15638212217"};

		// 短信模板ID，需要在短信应用中申请
		int templateId = 222010; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
		//templateId7839对应的内容是"您的验证码是: {1}"
		// 签名
		String smsSign = "弈凡网络科技"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
		
		
		try {
		    String[] params = {"5658","5"};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
		    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
		    SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
		        templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
		    System.out.println(result);
		} catch (HTTPException e) {
		    // HTTP响应码错误
		    e.printStackTrace();
		} catch (JSONException e) {
		    // json解析错误
		    e.printStackTrace();
		} catch (IOException e) {
		    // 网络IO错误
		    e.printStackTrace();
		}
	}*/
	
}
