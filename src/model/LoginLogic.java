package model;

import DAO.LoginDAO;

/* ログイン判定  */
public class LoginLogic {

	public boolean execute(User user) {

		//LoginDAOのインスタンス化
		LoginDAO dao = new LoginDAO();

		boolean existRegister = dao.findByLogin(user);

		return existRegister;

	}//execute()

}//class
