package org.ithang.tools.email;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class MailMessage {

	private MimeMessage message;
	
	/**
	 * 邮件件信息实体 
	 * @param session 
	 * @param sendMail 发送邮件帐号
	 * @param sender 发送人昵称
	 * @param acceptMails 接收邮件账号,多个账号用逗号分隔
	 * @param copyMails 抄送邮件账号
	 * @param subject 主题
	 * @param content 发件内容
	 */
	public MailMessage(MailSession session,String sender,String sendMail,String acceptMails,String copyMails,String subject,String content){
		message=new MimeMessage(session.getSession());
		try{
			String mailSender=javax.mail.internet.MimeUtility.encodeText(sender,MimeUtility.mimeCharset("UTF-8"),null);
		    message.setSubject(subject);
		    message.setSender(new InternetAddress(sendMail));//发送账号
		    message.setFrom(mailSender+"<"+sendMail+">");
		    message.setContent(content, "text/html;charset=UTF-8");
		    //message.setRecipients(RecipientType.BCC, null);//密送
		    message.setRecipients(RecipientType.TO, InternetAddress.parse(acceptMails));//收件人
		    message.setRecipients(RecipientType.CC, InternetAddress.parse(copyMails));//抄送人
		    message.setReplyTo(InternetAddress.parse(sendMail));//回复地址
		    message.setSentDate(new java.util.Date());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public MimeMessage getMessage() {
		return message;
	}

	public void setMessage(MimeMessage message) {
		this.message = message;
	}
	
	
}
