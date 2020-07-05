package model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class CommonsMail {
  //---- field definition ----
  private String subject = "Verify Mail";
  private String toMail = "xxxx@example.com";
  private String fromMail = "HoneySea@host";
  private String charset = "ISO-2022-JP";//
  private String encording = "base64";

  private String name = "";
  private String pass = "";

  //for local
  private String host = "localhost";
  private int port = 25;
  private boolean startTls = false;

  private Map<String, String> header = new HashMap<>() {
      private static final long serialVersionUID = 1L;
      {
        put("Content-Transfer-Encording", encording);
      }
  };//Hushmap define


  //====== void main() ======
  //public static void main(String[] args) throws IOException{

  //====== buildMail() ======
  public StringBuilder buildMail(User user) {
      this.name = user.getName();
      this.pass = user.getPass();
      this.toMail = user.getMail();

      EnCodeURL enCodeUrl = new EnCodeURL();
      StringBuilder passCode = enCodeUrl.buildPassCode(this.pass);

      StringBuilder buildURL = new StringBuilder();
          buildURL.append("http://localhost:80/?name=").append(this.name);
          buildURL.append("&pass=").append(passCode.toString());
          buildURL.append("&mail=").append(this.toMail);

      StringBuilder mailMessage = new StringBuilder();
          mailMessage.append("<a href=\"").append(buildURL.toString());
          mailMessage.append("\">").append(buildURL.toString());
          mailMessage.append("</a>");

      return mailMessage;

  }//buildMail()


// ====== send() ======
  public boolean send(StringBuilder mailMessage) {
      boolean doneMail = false;

      Email email = new SimpleEmail();

      try {
          email.setHostName(host);
          email.setSmtpPort(port);
          email.setHeaders(header);
          email.setAuthenticator(new DefaultAuthenticator(name, pass));
          email.setStartTLSEnabled(startTls);
          email.setFrom(fromMail);
          email.addTo(toMail);
          email.setCharset(charset);
          email.setSubject(subject);
          email.setMsg(mailMessage.toString());
          email.setDebug(true);

          email.send();

          doneMail = true;

      } catch (EmailException e) {
          e.printStackTrace();
          doneMail = false;
      }

      return doneMail;
  }//send()

}//class

/*
Thu, 02 Jul 2020 15:26:59 +0900 (JST)
Date: Thu, 2 Jul 2020 15:26:54 +0900 (JST)
From: yyyy@host
To: honey@sea
Message-ID: <350658136.0.1593671215119.JavaMail.MediWorks-03@MediWorks-02-PC>
Subject: Verify Mail
MIME-Version: 1.0
Content-Type: text/plain; charset=ISO-2022-JP
Content-Transfer-Encoding: 7bit
Content-Transfer-Encording: base64

http://localhost:80?name=honey&mail=honey@sea

=1B$BK\J8!!=1B(B http://localhost
↑この部分、元は「本文　」が正しくde-codeされていない
 */