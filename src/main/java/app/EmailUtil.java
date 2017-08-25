package app;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;


/**
 * This is the utility for sending the email:
 * SimpleEmail, HTMLEmail, MutiEmail
 * 
 * @author Xiaoxue CHEN
 * 
 */
public class EmailUtil {

	private static String hostName;
	private static String authenticationName;
	private static String authenticationPwd;
	private static String sentFrom;
	private static String subject;
	private static String sentTo[];
	private static String ccTo;

	static {
		hostName = "smtp.gmail.com";
		authenticationName = "";
		authenticationPwd = "";
		sentFrom = "";
		subject = "GNIB update";
		sentTo=new String[]{""};
		ccTo =""; 
	}

	public static void sendHTMLEmail(String str) throws EmailException {
			HtmlEmail email = new HtmlEmail();
			email.setSmtpPort(587); //for gmail
			email.setHostName(hostName);
			email.setAuthentication(authenticationName, authenticationPwd);
			email.getMailSession().getProperties().put("mail.smtps.auth", "true");
			email.getMailSession().getProperties().put("mail.debug", "true");
			email.getMailSession().getProperties().put("mail.smtps.port", "587");
			email.getMailSession().getProperties().put("mail.smtps.socketFactory.port", "587");
			email.getMailSession().getProperties().put("mail.smtps.socketFactory.class",   "javax.net.ssl.SSLSocketFactory");
			email.getMailSession().getProperties().put("mail.smtps.socketFactory.fallback", "false");
			email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
			email.setCharset("UTF-8");
			email.addTo(sentTo);
			email.setFrom(sentFrom);// here must the same as AuthenticationName
			email.setSubject(subject);
//			email.attach(getZipAsAttachement("target","target.zip"));
//			email.attach(getZipAsAttachement("log","log.zip"));
//			email.setHtmlMsg(getHTMLReport());
			email.setHtmlMsg(str);
//			email.addCc(ccTo);
			email.send();
	}
	
	public static void sendSimpleEmail(String content) throws EmailException {
			SimpleEmail email = new SimpleEmail();
			email.setHostName(hostName);
			email.setAuthentication(authenticationName, authenticationPwd);
			email.setCharset("UTF-8");
			email.addTo(sentTo);
			email.setFrom(sentFrom);// here must the same as AuthenticationName
			email.setSubject(subject);
			email.setMsg(content);
			email.send();
	}
}
