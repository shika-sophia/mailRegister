package model;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void main(String[] args) {

		SendMail sm = new SendMail();
		sm.send("JavaMail テストメール","テストメールの本文");

	}

	public void send(String subject,String content) {

		final String to = ""; //送り先
		final String from = "matsubara~@gmail.com"; //自分

		//Google account mail address
		final String username = "matsubara~@gmail.com";
		//Google App password
		final String password = "********";

		//final String charset = "ISO-2022-JP";
		final String charset = "UTF-8";

		final String encoding = "base64";

		//for gmail
		String host = "smtp.gmail.com";
		String port = "25";
		String starttls = "true";

		Properties p = new Properties();
		p.put("mail.smtp.host", host);
		p.put("mail.smtp.port", port);
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", starttls);

		p.put("mail.smtp.connectiontimeout", "10000");
		p.put("mail.smtp.timeout", "10000");

		p.put("mail.debug", "true");

		Session session = Session.getInstance(p,
	            new javax.mail.Authenticator() {
	               protected PasswordAuthentication getPasswordAuthentication() {
	                  return new PasswordAuthentication(username, password);
	               }
	            });

		try {
            MimeMessage message = new MimeMessage(session);

            // Set From:
            message.setFrom(new InternetAddress(from, "Sho Matsubara"));
            // Set ReplyTo:
            message.setReplyTo(new Address[]{new InternetAddress(from)});
            // Set To:
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject(subject, charset);
            message.setText(content, charset);

            message.setHeader("Content-Transfer-Encoding", encoding);

            Transport.send(message);

          } catch (MessagingException e) {
            throw new RuntimeException(e);
          } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
          }

	}

}

/*
課題
 ①送り先
 ②送信方法
   →Googleアカウント管理にログインして、二段認証を設定して、アプリ（メール）のパスワードを発行して、送信できる？
*/
