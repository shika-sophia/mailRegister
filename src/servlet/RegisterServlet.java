package servlet;//RegisterServlet

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.RegisterDAO;
import model.RegisterLogic;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request,HttpServletResponse response)
      throws ServletException, IOException {

        //index.jspのactionリクエストパラメータを取得する
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action == null) {
            String message = "";
            request.setAttribute("message", message);

            User user = new User();
            user.setName("");
            user.setPass("");
            user.setMail("");

            HttpSession session =request.getSession();
            session.setAttribute("user", user);

            //register.jspへフォワード
            String path = "/register.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(path);
            dis.forward(request, response);

        }else if(action.equals("done")) {

            //セッションスコープの情報を取得する
            HttpSession session = request.getSession();
            User user =(User) session.getAttribute("user");

            //RegisterLogicのインスタンス化
            RegisterLogic rl = new RegisterLogic();
            boolean existMail = (boolean) rl.existRegister(user);

            String message = "";

            if (existMail) {

                message = "そのMail Address は すでに使われています";
                request.setAttribute("message", message);
                request.setAttribute("existMail",existMail);

                String path = "/registerDone.jsp";
                RequestDispatcher dis = request.getRequestDispatcher(path);
                dis.forward(request, response);
            } else {
                message = "登録ＯＫ";
                request.setAttribute("message", message);
                request.setAttribute("existMail",existMail);

                //insert文でＤＢに登録
                RegisterDAO dao = new RegisterDAO();
                dao.insertRegister(user);

                //forward で結果を表示
                String path = "/registerDone.jsp";
                RequestDispatcher dis = request.getRequestDispatcher(path);
                dis.forward(request, response);
            }//if else

        }//if action
    }//doGet


    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String mail = request.getParameter("mail");

        //User(Beans)に入力更新 mail追加
        User user = new User(name, pass, mail);

        //---- set seesion scope ----
        HttpSession session = request.getSession();
        session.setAttribute("user",user);

        //registerConfirm.jspへフォワード
        String path = "/registerConfrim.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        dis.forward(request, response);

    }//doPost

}
