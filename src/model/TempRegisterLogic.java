/**
 * @title TempRegisterLogic
 * @author Sho & Shika
 * @see TempRegisterDAO
 * @date first 2020-07-08 / last 2020-07-12
 *
 * @class Logic for Temporary Register; insert, delete, select to Database temp_tb
 * */

package model;

import DAO.TempRegisterDAO;

public class TempRegisterLogic {
    TempRegisterDAO dao = new TempRegisterDAO();

    //====== get nowDateTime and call DAO for Temporary Register ======
    public boolean executeTempRegister(User user) {

        NowDateTime ndt = new NowDateTime();
        String nowDateTime = ndt.nowDateTime();

        boolean doneTempRegister = dao.doneTempRegister(user,nowDateTime);

        return doneTempRegister;
    }//executeTempRegister()


    //====== call DAO for DELETE Temporary when Indeed Register ======
    public boolean tempDelete(String mailCode) {

        boolean tempDelete = dao.tempDelete(mailCode);

        return tempDelete;
    }//tempDelete()


    public User getPastUser(String mailCode) {

        User user = dao.getPastUser(mailCode);

        return user;
    }
}//class



/*
select * from temp;
+-------+-------+------------+------------------------------------------+-------------------------------+
| name  | pass  | mail       | mailCode                                 | nowDateTime                   |
+-------+-------+------------+------------------------------------------+-------------------------------+
| shika | shika | honey@sea1 | %m68%m6f%m6e%m65%m79%m40%m73%m65%m61%m31 | 2020年7月8日(水) 10時54分57秒 |
+-------+-------+------------+------------------------------------------+-------------------------------+
*/