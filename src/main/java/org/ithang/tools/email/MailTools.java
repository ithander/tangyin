package org.ithang.tools.email;

import java.security.GeneralSecurityException;
import java.security.Security;
import java.util.Properties;

import javax.mail.Session;

import org.ithang.tools.email.EmailAuthenticator;
import org.ithang.tools.email.MailMessage;
import org.ithang.tools.email.MailSession;

import com.sun.mail.util.MailSSLSocketFactory;

public class MailTools {

	private static MailTools mailTools;
	private static javax.mail.Session session;
	
	public static MailTools getInstance(String host,int port,String username,String password){
		if(null==session){
			session=getSession(host,port,username,password);	
		}
		
		if(null==mailTools){
			mailTools=new MailTools();
		}
		
		return mailTools;
	}
	
	public static boolean sendMail(MailSession session,MailMessage message){
		
		return false;
	}
	
	
	public static javax.mail.Session getSession(String host,int port,final String username,final String password){
		Properties config = new Properties();
        config.put("mail.transport.protocol", "smtp");//发送邮件协议名称
        config.put("mail.smtp.host", host);//邮件服务器主机名
        config.put("mail.smtp.port", port);//邮件发送端口
        config.put("mail.smtp.auth", true);//发送服务器是否需要身份验证
        config.put("mail.debug", false);//是否开启debug调试
        config.put("mail.smtp.ssl.enable", false);//是否开启SSL安全加密
        config.put("mail.smtp.timeout", "15000");//发送超时时间
        EmailAuthenticator myauth=new EmailAuthenticator(username,password);
        Session session = Session.getInstance(config, myauth);
        return session;
	}
	
	/**
	 * 创建一个邮件会话
	 * @param host 邮件服务器主机名
	 * @param port 邮件发送端口
	 * @param username 发送邮件用户名
	 * @param password 发送邮件邮箱密码
	 * @param ssl
	 * @return
	 */
	@SuppressWarnings("all")
	public static javax.mail.Session getSession(String host,int port,final String username,final String password,boolean ssl){
		try{
	         Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	         Properties config = new Properties();
	         config.put("mail.transport.protocol", "SMTP");//发送邮件协议名称
	         config.put("mail.smtp.host", host);//邮件服务器主机名
	         config.put("mail.smtp.port", port);//邮件发送端口
	         config.put("mail.smtp.socketFactory.port",port);
	         config.put("mail.smtp.auth", true);//发送服务器是否需要身份验证
	         config.put("mail.debug", false);//是否开启debug调试
	         config.put("mail.smtp.ssl.enable", ssl);
	         config.put("mail.smtp.starttls.enable", "true");
	         config.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	         config.put("mail.smtp.socketFactory.fallback", "false");
	         
	         MailSSLSocketFactory mailSSLFactory;
	 		 try {
	 			mailSSLFactory = new MailSSLSocketFactory();
	 			mailSSLFactory.setTrustAllHosts(true); 
	 		    config.put("mail.smtp.ssl.socketFactory", mailSSLFactory);
	 		 } catch (GeneralSecurityException e) {
	 			e.printStackTrace();
	 		 }
	        
	         
	 		EmailAuthenticator myauth=new EmailAuthenticator(username,password);
	        Session session = Session.getInstance(config, myauth);
	         //session.setDebug(true);
	         //session.getTransport().connect(server, port, user, pwd);
	         //session.getTransport().connect();
	         //session.getTransport().close();
	         return session;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    return null;
	}
	
	
	
	public static void sendMail(String sender,String sendMail,String[] acceptMails,String[] copyMails){
		
	}
	
	/*public static void main(String[] args) {
		Session session=MailTools.getSession("smtp.exmail.qq.com", 25, "zhangyongtao@hotpu.cn", "Zyt6789");
		session.setDebug(true);
		//PrintStream ps=session.getDebugOut();
		
		ByteArrayOutputStream byout=new ByteArrayOutputStream();
		PrintStream mps=new PrintStream(byout,true);
		session.setDebugOut(mps);
		MimeMessage msg = new MimeMessage(session);
		 try{
			 msg.setSubject("主题a");
			 msg.setContent("hello this is a test mail", "text/html;charset=UTF-8");
			 String mailSender=javax.mail.internet.MimeUtility.encodeText("药豪",MimeUtility.mimeCharset("UTF-8"),null);
			 
			 msg.setSender(new InternetAddress("zhangyongtao@hotpu.cn"));
			    msg.setFrom(mailSender+"<zhangyongtao@hotpu.cn>");
			 //msg.setFrom(new InternetAddress(mailSender+" <zhangyongtao@hotpu.cn>"));
			 //msg.setContent(javax.mail.internet.MimeUtility.encodeText("",MimeUtility.mimeCharset("UTF-8"),null));
			 //("subject", "hello java pythone", "3218138121@qq.com", RecipientType.CC,"gandilong@yeah.net");
		        msg.setRecipients(RecipientType.BCC, InternetAddress.parse("3218138121@qq.com"));
		        
		        msg.setSentDate(new Date());     //设置信件头的发送日期
		        
			 session.getTransport().send(msg);
			 System.out.println("======================\n"+byout.toString());
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}*/
}
