package model;

import java.util.ArrayList;
import java.util.List;

public class Encode {

  //###### Test Hexadecimal Encode by Unicode / 16進数エンコード ######
  //16進数Unicodeでエンコードすると JavaScript unescpe()で簡単にデコードできる
  //public static void main(String[] args) {
      //String mail = "honey@love";

  //====== buildNameCode() ======
  public String buildNameCode(String name){
      int nameLength = name.length();
      List<Integer> nameUni = new ArrayList<>(64);

      for (int i = 0; i <= nameLength - 1 ; i++){
          nameUni.add(name.codePointAt(i));
      }//for

      StringBuilder nameCodeBuilder = new StringBuilder();

      for (int nameBit : nameUni) {
          String hexaStr = Integer.toHexString(nameBit);

          nameCodeBuilder.append("%n").append(hexaStr);

      }//for nameBit

      String nameCode = nameCodeBuilder.toString();
      return nameCode;

  }//buildNameCode()

  //====== buildPassCode() ======
  public String buildPassCode(String pass) {
      StringBuilder passCodeBuilder = new StringBuilder();
      int passLength = pass.codePointCount(0, pass.length());

      for (int i = 1; i <= passLength; i++){
          passCodeBuilder.append("*");
      }//for

      String passCode = passCodeBuilder.toString();
      return passCode;

  }//buildPassCode()

  //====== buildMailCode() ======
  public String buildMailCode(String mail){
      int mailLength = mail.length();
      List<Integer> mailUni = new ArrayList<>(64);

      for (int i = 0; i <= mailLength - 1 ; i++){
          mailUni.add(mail.codePointAt(i));
      }//for

      StringBuilder mailCodeBuilder = new StringBuilder();

      for (int mailBit : mailUni) {
          String hexaStr = Integer.toHexString(mailBit);
          mailCodeBuilder.append("%m").append(hexaStr);

      }//for mailBit

      String mailCode = mailCodeBuilder.toString();
      //String mailDecode = decodeMailCode(mailCode);

      //System.out.println("mail: " + mail);
      //System.out.println("mailCode: " + mailCode);
      //System.out.println("mailDecode: " + mailDecode);

      return mailCode;

  }//buildMailCode() or main()


  //====== Decode Section ======
  public String decodeNameCode (String nameCode) {
      StringBuilder nameDecodeBuilder = new StringBuilder();
      String[] nameCodeDivision = nameCode.substring(2).split("%m");

      for (String hexaStr : nameCodeDivision) {
          int hexaCode = Integer.parseInt(hexaStr, 16);
          char character = (char)hexaCode;
          nameDecodeBuilder.append(character);
      }//for hexaStr

      String nameDecode = nameDecodeBuilder.toString();
      return nameDecode;

  }//decodeNameCode()


  public String decodeMailCode (String mailCode) {
      StringBuilder mailDecodeBuilder = new StringBuilder();
      String[] mailCodeDivision = mailCode.substring(2).split("%m");

      for (String hexaStr : mailCodeDivision) {
          int hexaCode = Integer.parseInt(hexaStr, 16);
          char character = (char)hexaCode;
          mailDecodeBuilder.append(character);
      }//for hexaStr

      String mailDecode = mailDecodeBuilder.toString();
      return mailDecode;

  }//decodeMailCode()

}//class

/*
//====== for Test Section======
//====== Test Result of Hexadecimal Encorde by Unicode ======
mail: honey@love
mailCode: %m68%m6f%m6e%m65%m79%m40%m6c%m6f%m76%m65
mailDecode: honey@love
 */

/*
//###### Test Decimal Encode by Unicode ######
public static void main(String[] args) {
      String mail = "honey@love";

  //public StringBuilder buildMailCode(String mail){
      int mailLength = mail.length();
      List<Integer> mailUni = new ArrayList<>(64);

      for (int i = 0; i <= mailLength - 1 ; i++){
          mailUni.add(mail.codePointAt(i));
      }//for

      StringBuilder mailCode = new StringBuilder();

      for (int mailBit : mailUni) {

          mailCode.append("%m").append(mailBit);

      }//for mailBit

      StringBuilder mailRestruct = decodeMailUni(mailUni);

      System.out.println("mail: " + mail);
      System.out.println("mailCode: " + mailCode);
      System.out.println("mailResturuct: " + mailRestruct);

      //return mailCode;

  }//buildMailCode() or main()


  private static StringBuilder decodeMailUni(List<Integer> mailUni) {
      StringBuilder mailRestruct = new StringBuilder();

      for (int mailBit : mailUni) {
          String hexaStr = Integer.toHexString(mailBit);
          int hexaCode = Integer.parseInt(hexaStr, 16);
          char character = (char)hexaCode;
          mailRestruct.append(character);
      }//for mailBit

      return mailRestruct;
  }//decodeMailUni()

  //====== Test Result of Decimal Encode by Unicode ======
mail: honey@love
mailCode: %m104%m111%m110%m101%m121%m64%m108%m111%m118%m101
mailResturuct: honey@love
*/