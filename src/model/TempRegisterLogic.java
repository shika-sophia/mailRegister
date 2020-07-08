package model;

import DAO.TempRegisterDAO;

public class TempRegisterLogic {

	public boolean executeTempRegister(User user) {

		NowDateTime ndt = new NowDateTime();
		String nowDateTime = ndt.nowDateTime();

		TempRegisterDAO dao = new TempRegisterDAO();
		boolean doneTempRegister = dao.doneTempRegister(user,nowDateTime);

		return doneTempRegister;
	}
}

	/*
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
*/

/*
select * from temp;
+-------+-------+------------+------------------------------------------+-------------------------------+
| name  | pass  | mail       | mailCode                                 | nowDateTime                   |
+-------+-------+------------+------------------------------------------+-------------------------------+
| shika | shika | honey@sea1 | %m68%m6f%m6e%m65%m79%m40%m73%m65%m61%m31 | 2020年7月8日(水) 10時54分57秒 |
+-------+-------+------------+------------------------------------------+-------------------------------+
*/