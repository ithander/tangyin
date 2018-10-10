package org.ithang.tools.email;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import javax.mail.Session;

public class MailSession {

	private javax.mail.Session session;
	private ByteArrayOutputStream byout;
	public MailSession(String host,int port,final String username,final String password,boolean ssl){
		if(ssl){//如果开启安全加密策略
			
		}else{
			Properties config = new Properties();
	        config.put("mail.transport.protocol", "smtp");//发送邮件协议名称
	        config.put("mail.smtp.host", host);//邮件服务器主机名
	        config.put("mail.smtp.port", port);//邮件发送端口
	        config.put("mail.smtp.auth", true);//发送服务器是否需要身份验证
	        config.put("mail.debug", false);//是否开启debug调试
	        config.put("mail.smtp.ssl.enable", true);//是否开启SSL安全加密,默认开启
	        config.put("mail.smtp.timeout", "15000");//发送超时时间
	        EmailAuthenticator myauth=new EmailAuthenticator(username,password);
	        this.session = Session.getInstance(config, myauth);
	        byout=new ByteArrayOutputStream();
			PrintStream mps=new PrintStream(byout,true);
			session.setDebugOut(mps);//设置调试信息输出到内存,以便分析发送邮件是否成功
		}
	}

	public javax.mail.Session getSession() {
		return session;
	}

	public void setSession(javax.mail.Session session) {
		this.session = session;
	}
	
}
