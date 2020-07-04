package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class readFile {

  public static void main(String[] args) {
  //public StringBuilder readPage(Path path) {

    StringBuilder readPage = new StringBuilder();

    //---- read the target file text / 目標ファイルの読み取り ----
    try {
        Path path = Paths.get("C:\\Program Files\\pleiades\\workspace-web\\mailRegister\\WebContent\\Apache24_htdocs\\index.html");
        //Path path = Paths.get("C:\\Users\\MediWorks-03\\Desktop\\received-emails");

        BufferedReader reader = Files.newBufferedReader(path);
        String readLine = reader.readLine();
        String endPoint = "</html>";

        while(readLine != null ){
            readPage.append(readLine);

            if (readLine.contains(endPoint)) {
                break;
            }

        }//while

        //System.out.println(readPage);

    } catch (IOException e){
        e.printStackTrace();
    }//try catch

    //return readPage;

  }//readPage() or main()

}//class

/* ====== Test Result ======
<html><body><h1>It works!</h1></body></html>

//Path path = Paths.get("C:\\Program Files\\pleiades\\workspace-web\\mailRegister\\WebContent\\Apache24_htdocs\\index.html");

Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    at java.base/java.util.Arrays.copyOf(Arrays.java:3745)
    at java.base/java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:172)
    at java.base/java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:538)
    at java.base/java.lang.StringBuilder.append(StringBuilder.java:174)
    at model.readFile.main(readFile.java:26)


*/
