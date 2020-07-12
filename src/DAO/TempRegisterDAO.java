package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class TempRegisterDAO {

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/puzzle?characterEncoding=utf-8&serverTimezone=JST";
    private final String DB_USER = "root";
    private final String DB_PASS = "root";



    // ====== INSERT when Temporary Register / wrote by Sho ======
    public boolean doneTempRegister(User user,String nowDateTime) {

        Connection conn = null;

        try {
            conn =DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

            //INSERT文の準備
            String sql = "INSERT INTO temp(name,pass,mail,mailCode,nowDateTime) values(?,?,?,?,?)";

            //SQL文を送る
            PreparedStatement pStmt = conn.prepareStatement(sql);

            //INSERT文の?に値を設定
            pStmt.setString(1,user.getName());
            pStmt.setString(2,user.getPass());
            pStmt.setString(3,user.getMail());
            pStmt.setString(4,user.getMailCode());
            pStmt.setString(5,nowDateTime);

            //INSERT文を実行
            int rs = pStmt.executeUpdate();

            if(rs !=1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;

    }//doneTempRegister()


    //====== DELETE when doneTempRegister / wrote by Shika ======
    public boolean tempDelete(String mailCode) {
        Connection conn = null;

        try {
            conn =DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

            //DELETE文の準備
            String sql = "DELETE FROM temp WHERE mailCode = ?";

            //SQL文を送る
            PreparedStatement pStmt = conn.prepareStatement(sql);

            //DELETE文の?に値を設定
            pStmt.setString(1,mailCode);

            //DELETE文を実行
            int rs = pStmt.executeUpdate();

            if(rs != 1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }//finally

        return true;

    }//tempDelete()


    //====== getPastUser when (currentMailCode != mailCode) / wrote by Shika ======
    public User getPastUser(String mailCode) {
        Connection conn = null;
        User user = new User();

        try {
            conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
            String name = "";
            String pass = "";
            String mail = "";

            //SELECT文の準備
            String sql = "SELECT name, pass, mail FROM temp WHERE mailCode = ?";

            //SQL文を送る
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,mailCode);

            //SQL文を実行して結果を取得する
            ResultSet rs = pStmt.executeQuery();

            while(rs.next()) {
               name = rs.getString("name");
               pass = rs.getString("pass");
               mail = rs.getString("mail");
            }

            //---- set pastUserData to user ----
            user.setName(name);
            user.setPass(pass);
            user.setMail(mail);
            user.setMailCode(mailCode);

        } catch (SQLException e) {

            e.printStackTrace();
            return null;

        } finally {

            try {
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }//finally

        return user;

    }//getPastUser()



}//class
