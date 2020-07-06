package model;

import java.io.Serializable;

public class User implements Serializable{

    //------ field parameters in User(Beans) Class ------
    private String name;
    private String pass;
    private int puzzleId;
    private int point;
    private String mail;
    private String code;


    //====== constracter for general ======
    public User() {}

    //======= constracter for RegisterServlet =======
    public User(String name,String pass,String mail) {
        this.name=name;
        this.pass=pass;
        this.mail=mail;
    }

    //======= getter and setter section ======
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPuzzleId() {
        return puzzleId;
    }

    public void setPuzzleId(int puzzleId) {
        this.puzzleId = puzzleId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}//class
