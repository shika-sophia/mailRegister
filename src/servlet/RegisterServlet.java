package servlet;//RegisterServlet

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommonsMail;
import model.RegisterLogic;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    //====== Start Point of Application "mailRegister" ======
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
      throws ServletException, IOException {

      String message = "";
      request.setAttribute("message", message);

      User user = new User();
      user.setName("");
      user.setPass("");
      user.setMail("");

      HttpSession session =request.getSession();
      session.setAttribute("user", user);

      //---- start to register.jsp ----
      String path = "/register.jsp";
      RequestDispatcher dis = request.getRequestDispatcher(path);
      dis.forward(request, response);

    }//doGet


    //====== <form> action from "register.jsp" ======
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
      throws ServletException, IOException{

      //---- get parameter from register.jsp ----
      request.setCharacterEncoding("UTF-8");
      String name = request.getParameter("name");
      String pass = request.getParameter("pass");
      String mail = request.getParameter("mail");

      //---- input each parameter to user ----
      User user = new User(name, pass, mail);

      //---- set user to session scope ----
      HttpSession session = request.getSession();
      session.setAttribute("user", user);

      //---- call existRegister ----
      RegisterLogic rl = new RegisterLogic();
      boolean existMail = (boolean) rl.existRegister(user);
      request.setAttribute("existMail",existMail);

      String message = "";

      if (existMail) {
          //---- existMail == true ----
          message = "そのMail Address は すでに使われています";
          request.setAttribute("message", message);

          //---- return to "register.jsp"----
          String path = "/register.jsp";
          RequestDispatcher dis = request.getRequestDispatcher(path);
          dis.forward(request, response);

      } else {
          //---- no existMail -> send Mail ----
          //---- call CommonsMail() ----
          CommonsMail commonsMail = new CommonsMail();

          String toMail = commonsMail.buildMail(user);

          String subject = "Verify Mail";
          String mailMessage = "http://localhost:80?name=" + name + "&mail=" + toMail;

          //EncodeURL encodeURL = new EncodeURL();
          //String encodeMessage = encodeURL.toUniCode(mailMessage);
          //---- send mail ----
          boolean doneMail = commonsMail.send(subject, mailMessage, toMail);

          //---- set result of if mail was done,to request scope ----
          request.setAttribute("doneMail", doneMail);

          //---- forward to "mailDone.jsp" ----
          String path = "/mailDone.jsp";
          RequestDispatcher dis = request.getRequestDispatcher(path);
          dis.forward(request, response);
      }//if existRegister

    }//doPost

}//class
