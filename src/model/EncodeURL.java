package model;

import java.util.ArrayList;
import java.util.List;

public class EncodeURL {

  public static void main(String[] args) {
      String message = "http://localhost:80?name=honey&mail=honey@sea";
      String name = "honey";
      String pass = "love";
      String mail = "honey@sea";

      StringBuilder urlCode = new StringBuilder();
      StringBuilder messageCode = new StringBuilder();

      // ---- get StringLength ----
      int nameLength = name.length();
      int passLength = pass.length();
      int mailLength = mail.length();

      // ---- String to unicode List----
      List<Integer> nameUni = new ArrayList<>();
      List<Integer> mailUni = new ArrayList<>(64);

      for (int i = 0; i <= nameLength - 1; i++){
          nameUni.add(name.codePointAt(i));
      }//for

      for (int i = 0; i <= mailLength - 1; i++){
          mailUni.add(mail.codePointAt(i));
      }//for

      // ---- List nameUni to StringBuilder nameCode ----
      StringBuilder nameCode = buildNameCode(nameUni);

      // ---- passLength to "*" ----
      StringBuilder passCode = buildPassCode(pass);

      // ---- List mailUni to StringBuilder mailCode ----
      StringBuilder mailCode = buildMailCode(mailUni);

      // ---- make urlCode ----
      urlCode.append("http://localhost:80/?name=").append(nameCode);
      urlCode.append("&pass=").append(passCode);
      urlCode.append("&mail=").append(mailCode);

      // ---- make messageCode ----
      //<a href=\"http://localhost:80/?name= &pass= &mail= ">http://localhost:80/?name= &pass= &mail= </a>
      messageCode.append("<a href=\"");
      messageCode.append(urlCode);
      messageCode.append("\">");
      messageCode.append(urlCode);
      messageCode.append("</a>");

  //public String toUniCode(String message) {

  //  return null;
      //System.out.println(urlCode);
      //System.out.println(messageCode);

      List<String> urlDeCode = deCodeURL(urlCode);
      System.out.println(urlDeCode);
  }//main()


//====== buildNameCode() ======
  private static StringBuilder buildNameCode(List<Integer> nameUni) {
	  StringBuilder nameCode = new StringBuilder();

	  for (int nameBit : nameUni) {
          nameCode.append("%u").append(nameBit);
	  }// for nameBit

      return nameCode;
  }//buildNameCode()

  //====== buildPassCode() ======
  public static StringBuilder buildPassCode(String pass) {
      StringBuilder passCode = new StringBuilder();
      int passLength = pass.codePointCount(0, pass.length());

      for (int i = 1; i <= passLength; i++){
          passCode.append("*");
      }//for

      return passCode;
  }//buildPassCode()

  //====== buildMailCode() ======
  private static StringBuilder buildMailCode(List<Integer> mailUni) {
      StringBuilder mailCode = new StringBuilder();

      for (int mailBit : mailUni) {
          mailCode.append("%u").append(mailBit);
      }// for mailBit

      return mailCode;
  }//buildMailCode()


//====== DeCode to Remake name, pass, mail ======
 // Web Page上の想定なので渡せる引数はurlCodeのみ
 private static List<String> deCodeURL(StringBuilder urlCode) {
     List<String> urlDeCode = new ArrayList<>();
     List<Integer> nameUni = new ArrayList<>();
     List<Integer> mailUni = new ArrayList<>();
     String passCode = "";

     int startPoint = urlCode.indexOf("name=%u");
     return urlDeCode;
 }//deCodeURL()


}//class

/*//====== Test Result ======
 * urlCode : http://localhost:80/?name=%u104%u111%u110%u101%u121
       &pass=****&mail=%u104%u111%u110%u101%u121%u64%u115%u101%u97

 * messageCode : <a href="http://localhost:80/?name=%u104%u111%u110%u101%u121
       &pass=****&mail=%u104%u111%u110%u101%u121%u64%u115%u101%u97">
       http://localhost:80/?name=%u104%u111%u110%u101%u121
       &pass=****&mail=%u104%u111%u110%u101%u121%u64%u115%u101%u97</a>

*/
