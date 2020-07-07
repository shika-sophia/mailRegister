package test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesTest {
	public static final String ENCRYPT_KEY = "1234567890123456";
	public static final String ENCRYPT_IV = "abcdefghijklmnop";

	/**
	 * メインメソッド
	 *
	 * @param args
	 */

	public static void main(String[] args) {/*暗号化したtextの表示をするメソッド*/
		// 暗号化メソッド呼出
		//System.out.println(encrypt(args[0]));
		String text = "sho@demo";
		System.out.println(text);
		String decordresult = decrypt(text);
		System.out.println("成功=" + decordresult);

		// 復号化メソッド呼出
		//System.out.println(decrypt(encrypt(args[0])));
		String encordresult = encrypt(decordresult);
		System.out.println(encordresult);

	}//main

	public static String decrypt(String text) {
		/**
		 * 暗号化メソッド
		 *
		 * @param text 暗号化する文字列
		 * @return 暗号化文字列
		 */
		// 変数初期化
		String strResult = null;

		try {
			// 文字列をバイト配列へ変換
			byte[] byteText = text.getBytes("UTF-8");
			System.out.println("sho@demoを変換したbyteText="+byteText);

			// 暗号化キーと初期化ベクトルをバイト配列へ変換
			byte[] byteKey = ENCRYPT_KEY.getBytes("UTF-8");
			byte[] byteIv = ENCRYPT_IV.getBytes("UTF-8");

			// 暗号化キーと初期化ベクトルのオブジェクト生成
			SecretKeySpec key = new SecretKeySpec(byteKey, "AES");
			IvParameterSpec iv = new IvParameterSpec(byteIv);

			// Cipherオブジェクト生成
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

			// Cipherオブジェクトの初期化
			cipher.init(Cipher.ENCRYPT_MODE, key, iv);

			// 暗号化の結果格納
			byte[] byteResult = cipher.doFinal(byteText);

			// Base64へエンコード
			//strResult = Base64.getMimeEncoder();
			System.out.println("暗号化した値はbyteResult=" + byteResult);

			strResult = Base64.getEncoder()
					.encodeToString(byteResult);
			System.out.println("ByteResultをエンコードした値はstrResult=" + strResult);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
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

		// 暗号化文字列を返却
		return strResult;
	}//decrypt

	private static String encrypt(String decordresult) {
		/**
		 * 復号化メソッド
		 *
		 * @param text 復号化する文字列
		 * @return 復号化文字列
		 */
		// 変数初期化
		String strResult = null;

		try {
			//?byte[] dec = new Sun.misc.BASE64Decoder().decodeBuffer(str);
			// デコードは Base64.getDecoder() で得られるオブジェクトを利用する
			/*String decoded = new String(Base64.getDecoder()
			        .decode(encoded));*/
			//byte[] byteText = text.getBytes("UTF-8");
			// Base64をデコード

			byte[] byteText = decordresult.getBytes();

			System.out.println("decordresult=" + decordresult);

			System.out.println("byteText="+byteText);

			/*strResult = Base64.getEncoder()
					.encodeToString();*/
			//base64へデコード
			String decoded = new String(Base64.getDecoder()
					.decode(decordresult));
			System.out.println("decoded=" + decoded);
			//byte[] byteText = decoded.getBytes("UTF-8");
			//byte[] byteText = Base64.decodeBase64(decordresult);//本来の文

			// 暗号化キーと初期化ベクトルをバイト配列へ変換
			byte[] byteKey = ENCRYPT_KEY.getBytes("UTF-8");
			byte[] byteIv = ENCRYPT_IV.getBytes("UTF-8");

			// 復号化キーと初期化ベクトルのオブジェクト生成
			SecretKeySpec key = new SecretKeySpec(byteKey, "AES");
			IvParameterSpec iv = new IvParameterSpec(byteIv);

			System.out.println("141行目");

			// Cipherオブジェクト生成
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

			// Cipherオブジェクトの初期化
			cipher.init(Cipher.DECRYPT_MODE, key, iv);

			// 復号化の結果格納
			byte[] byteResult = cipher.doFinal(byteText);

			// バイト配列を文字列へ変換
			strResult = new String(byteResult, "UTF-8");


		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
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

		// 復号化文字列を返却
		return strResult;

	}//encrypt

}//class
