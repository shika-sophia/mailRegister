package test;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class encryptTokenSampleModel {
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

	  public  void main(String[] args) {
	 //public  String main(String[] args) {






	  //public String encryptToken(String test)  {
		  String start="fail";

		  try {


			System.out.println("start");

			 /*※Cipher　暗号機能を提供するクラス、getInstanceメソッドを呼び出し、変換する
			  *変換には必ずAESなどの暗号化アルゴリズムを使用
			  *例；Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			*/

			Cipher encrypter = Cipher.getInstance(ALGORITHM);
	    	/*ENCRYPT_MODE　暗号を暗号モードに初期化するのに使用する定数
		     *
		     * */
		    encrypter.init(Cipher.ENCRYPT_MODE, this.key, iv);
		    byte[] byteToken = encrypter.doFinal(test.getBytes());
		    System.out.println("暗号化した文字列byteTokenは"+byteToken+"testは"+test);


		    //エンコード方法を試行錯誤中
		   // return new String(Base64.getEncoder().encode(byteToken));

		/*} catch (UnsupportedEncodingException e) {
			e.printStackTrace();*/
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();


		} catch (NoSuchPaddingException e) {
			e.printStackTrace();

		} catch (InvalidKeyException e) {
			e.printStackTrace();

		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();

		} catch (BadPaddingException e) {
			e.printStackTrace();

		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();

		}
		//return start;

		//}catch() {
			//System.out.println("errr");
			//e.printStackTrace();

	         // return null;
		//}//trycatch
	  }//encryptToken

}
