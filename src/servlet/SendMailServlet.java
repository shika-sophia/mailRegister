package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommonsMail;
import model.User;


@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

  }//doGet()

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String pass = request.getParameter("pass");
    String mail = request.getParameter("mail");

    //---- input each parameter to user ----
    User user = new User(name, pass, mail);

    //---- set user to session scope ----
    HttpSession session = request.getSession();
    session.setAttribute("user", user);

    //---- call CommonsMail() ----
    CommonsMail commonsMail = new CommonsMail();

    String toMail = commonsMail.buildMail(user);

    String subject = "Verify Mail";
    String message = "http://localhost:80?name=" + name + "&mail=" + toMail;

    //EncodeURL encodeURL = new EncodeURL();
    //String encodeMessage = encodeURL.toUniCode(message);
    //---- send mail ----
    boolean doneMail = commonsMail.send(subject, message, toMail);

    //---- set result of if done mail to request scope ----
    request.setAttribute("doneMail", doneMail);

    //---- forward to registerResult ----
    String path = "/mailDone.jsp";
    RequestDispatcher dis = request.getRequestDispatcher(path);
    dis.forward(request, response);

  }//doPost()

}//class
