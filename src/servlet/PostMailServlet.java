package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.RegisterDAO;
import model.User;


@WebServlet("/PostMailServlet")
public class PostMailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

  }//doGet()

  //====== <form> action from registerConfirm.jsp ======
  //@parm mailCode: String メールで送ったmailCode
  //@parm currentMailCode: String 現在User(Beans)に保存されているmailCode
  //【註】mailCode と currentMailCodeが違う場合も考える
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");
    String mailCode = request.getParameter("mailCode");

    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");
    String currentMailCode = user.getMailCode();

    if (currentMailCode.equals(mailCode)) {
        RegisterDAO dao = new RegisterDAO();
        boolean doneInsert = dao.insertRegister(user);

        if (doneInsert) {
        	//for TempRegister -> mailCodeを渡して その仮登録を削除、本登録

            String message = "本登録完了";
            request.setAttribute("message", message);

            String path = "/registerDone.jap";
            RequestDispatcher dis = request.getRequestDispatcher(path);
            dis.forward(request, response);

        } else {
            ; //登録の失敗時はエラーのため処理なし
        }//if doneInsert

    } else { //mailCode と 現在のcurrentMailCodeが違う場合
    	//for TempRegisterにmailCode を渡して、そのuserデータを取得
    	//それを本登録
    }//if mailCode
  }//doPost()

}//class
