package model;

import java.util.List;

import DAO.RegisterDAO;

public class RegisterLogic {

	public void execute(User user) {

		RegisterDAO dao = new RegisterDAO();

		dao.insertRegister(user);
	}

	public boolean existRegister(User user) {

		RegisterDAO dao = new RegisterDAO();
        List<String> mailDB = dao.selectRegister(user);

        boolean existMail = existMail(user, mailDB);

        return existMail;
	}//execute()


    private boolean existMail(User user, List<String> mailDB) {
    	boolean existMail = false;

    	String mail = user.getMail();

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

}//class
