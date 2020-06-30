package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


@WebServlet("/MailSendServlet")
public class MailSendServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  //private parameter for SMTP-Server's host name
  private String host = "";


  // ====== read initialized parameter ======
  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    this.host = config.getServletContext().getInitParameter("smpt.host");
  }//init()

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    SimpleEmail email = new SimpleEmail();

    try {
      email.setHostName(this.host);
      email.addTo("address@test", "アドレス名", "ISO-2022-JP");
      email.setFrom("xxxx@nifty.ne.jp", "差出人", "ISO-2022-JP");
      email.setCharset("ISO-2022-JP");
      email.setSubject("タイトル");
      email.setMsg("本文");

      // ---- mail送信 ----
      email.send();

    } catch (EmailException e) {
        throw new ServletException(e);
    }

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("メール送信完了");

  }//doGet()


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

  }//doPost()

}//class
