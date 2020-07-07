package test;

import java.io.IOException;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Samplea1
 */
@WebServlet("/Samplea1")
public class Samplea1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// アルゴリズム/ブロックモード/パディング方式
	   String ALGORITHM = "AES/CBC/PKCS5Padding";
	  // 暗号化＆復号化で使用する鍵
	  //private static final String ENCRYPT_KEY = "mkm";
	  String ENCRYPT_KEY = "yourEncryptKey01";
	  // 初期ベクトル
	  //private static final String INIT_VECTOR = "mkm";
	   String INIT_VECTOR = "yourInitVector01";

	  //呼び出し
	  //()内のバイトを IV として使用して IvParameterSpec オブジェクトを生成します。
	    IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes());
	  //指定されたバイト配列(ENCRYPT_KEY.getBytes())から秘密鍵を構築します。
	    SecretKeySpec key = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
	  //TEST関数
	  String test="testメッセージ";



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		encryptTokenSampleModel eTS=new encryptTokenSampleModel();
		System.out.println("hello");
		System.out.println(eTS+"modelからの戻り値");




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
