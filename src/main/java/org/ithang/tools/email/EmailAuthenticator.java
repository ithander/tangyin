package org.ithang.tools.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 邮件的认证实体类
 * @author ithang
 *
 */
public class EmailAuthenticator extends Authenticator{

	 private String userName=null;  
	 private String password=null;  
	 
	 public EmailAuthenticator(){  
         setUserName("");
         setPassword("");
	 }
	 
	 public EmailAuthenticator(String userName,String password){
		 setUserName(userName);
		 setPassword(password);
	 }  
	 
	 protected PasswordAuthentication getPasswordAuthentication(){     
	     return new PasswordAuthentication(userName, password);     
	 }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	 
	 
}
