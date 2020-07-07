package model;

import java.util.List;

import DAO.TempRegisterDAO;

public class TempRegisterLogic {

	public void execute(User user) {

		TempRegisterDAO dao = new TempRegisterDAO();
		dao.doneTempRegister(user);

	}

	public boolean existTempRegister(User user) {

		TempRegisterDAO dao = new TempRegisterDAO();
		List<String> mailDB = dao.tempRegister();

		boolean existMail = existMail(user, mailDB);

		return existMail;

	}

	private boolean existMail(User user, List<String> mailDB) {

		boolean existMail = false;

		String mail = user.getMailCode();

		for(String str : mailDB) {
	      if (mail.equals(str)) {
	          existMail = true;
	          break;
	      } else {
	          existMail = false;
	      }
	    }// for

	        return existMail;
	}

}