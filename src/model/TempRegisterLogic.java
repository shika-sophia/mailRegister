/**
 * @title TempRegisterLogic
 * @author Sho & Shika
 * @see TempRegisterDAO
 * @date first 2020-07-08 / last 2020-07-12
 *
 * @class Logic for Temporary Register; insert, delete, select to Database temp_tb
 * */

package model;

import java.util.List;

import DAO.TempRegisterDAO;

public class TempRegisterLogic {
    //---- field definition ----
    TempRegisterDAO dao = new TempRegisterDAO();
    NowDateTime ndt = new NowDateTime();

    //====== get nowDateTime and call DAO for Temporary Register ======
    public boolean executeTempRegister(User user) {

        //---- get nowDateTime for tempRegister ----
        String nowDateTime = ndt.nowDateTime();

        //---- call DAO for tempRegister ----
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
    }//getPastUser()


    //====== Logic to delete Temporary Register when be over 24hours ======
    //【未実装】まだServer Test, DB Testをしていないので、ここを呼び出すServletの記述なし
    public boolean tempDeleteOver24h () {
        //---- get nowDateTime for tempRegister ----
        String over24hDateTime = ndt.over24hDateTime();

        //---- call DAO for select rows over 24h ----
        List<String> over24hList= dao.selectOver24h(over24hDateTime);
        boolean beClear = dao.tempDeleteOver24h(over24hList);

        return beClear;
    }//tempDeleteOver24h()
}//class



/*
select * from temp;
+-------+-------+------------+------------------------------------------+-------------------------------+
| name  | pass  | mail       | mailCode                                 | nowDateTime                   |
+-------+-------+------------+------------------------------------------+-------------------------------+
| shika | shika | honey@sea1 | %m68%m6f%m6e%m65%m79%m40%m73%m65%m61%m31 | 2020年7月8日(水) 10時54分57秒 |
+-------+-------+------------+------------------------------------------+-------------------------------+
*/