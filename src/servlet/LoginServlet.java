package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException, IOException {

	}//doGet

	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException, IOException {
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		//パラメーター取得
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String accountId =request.getParameter("accountId");

		//Userインスタンスと値の入力
		User user=new User(name,pass,accountId);

		//LoginLogicで すでに登録があるかを確認
		LoginLogic loginLogic=new LoginLogic();
        boolean isLogin = loginLogic.execute(user);

        //---- set request / session scope ----
        request.setAttribute("isLogin", isLogin);

		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		String path = "/loginResult.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);

	}//post

}
