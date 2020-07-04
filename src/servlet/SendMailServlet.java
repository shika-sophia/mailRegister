package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.RegisterDAO;
import model.User;


@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

      HttpSession session = request.getSession();
      User user = (User) session.getAttribute("user");

      String message = "登録ＯＫ";
      request.setAttribute("message", message);

      //insert文でＤＢに登録
      RegisterDAO dao = new RegisterDAO();
      dao.insertRegister(user);

      //---- forward to registerDone.jsp ----
      //String path = "/registerDone.jsp";
      //RequestDispatcher dis = request.getRequestDispatcher(path);
      //dis.forward(request, response);

  }//doGet()

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {


  }//doPost()

}//class
