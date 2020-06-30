package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class CommonsMail {
  //---- field definition ----
  private String toMail = "xxxx@example.com";
  private String fromMail = "yyyy@host";
  private String charset = "ISO-2022-JP";
  private String encording = "base64";

  private String name = "";
  private String pass = "";

  //for local
  private String host = "localhost";
  private int port = 2525;
  private boolean startTls = false;

  private Map<String, String> header = new HashMap<>() {
	  private static final long serialVersionUID = 1L;
	  {
	    put("Content-Transfer-Encording", encording);
	  }
  };//Hushmap define


  //====== void main() ======
  public static void main(String[] args) throws IOException{
      CommonsMail commonsMail = new CommonsMail();
      String subject = "Test Mail";
      String message = "本文";

      commonsMail.send(subject, message);

  }//main()


// ====== send() ======
  private void send(String subject, String message) {
      Email email = new SimpleEmail();

      try {
    	  email.setHostName(host);
    	  email.setSmtpPort(port);
    	  email.setHeaders(header);
    	  email.setAuthenticator(new DefaultAuthenticator(name, pass));
    	  email.setStartTLSEnabled(startTls);
    	  email.setFrom(fromMail);
    	  email.addTo(toMail);
    	  email.setSubject(subject);
    	  email.setMsg(message);
    	  email.setDebug(true);

    	  email.send();

      } catch (EmailException e) {
    	  e.printStackTrace();
      }

  }//send()

}//class
