package app;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 * This is the utility for sending the email: SimpleEmail, HTMLEmail, MutiEmail
 *
 * @author Xiaoxue CHEN
 */
public class EmailUtil {

  private static final String HOST_NAME="smtp.gmail.com";
  private static final String AUTH_NAME="xx@tcd.ie";
  private static final String AUTH_PWD = "xxxxxxx";
  private static final String MAIL_SUBJECT="GNIB Appointment Update";
  private static final String[] SEND_TO=new String[] {"xx@gmail.com"};


  public static void sendHTMLEmail(String str) throws EmailException {
    HtmlEmail email = new HtmlEmail();
    email.setSmtpPort(587); // for gmail
    email.setHostName(HOST_NAME);
    email.setAuthentication(AUTH_NAME, AUTH_PWD);
    email.getMailSession().getProperties().put("mail.smtps.auth", "true");
    email.getMailSession().getProperties().put("mail.debug", "true");
    email.getMailSession().getProperties().put("mail.smtps.port", "587");
    email.getMailSession().getProperties().put("mail.smtps.socketFactory.port", "587");
    email
        .getMailSession()
        .getProperties()
        .put("mail.smtps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    email.getMailSession().getProperties().put("mail.smtps.socketFactory.fallback", "false");
    email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
    email.setCharset("UTF-8");
    email.addTo(SEND_TO);
    email.setFrom(AUTH_NAME);
    email.setSubject(MAIL_SUBJECT);
    email.setHtmlMsg(str);
    email.send();
  }
}
