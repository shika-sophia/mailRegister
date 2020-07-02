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
    	Path path = Paths.get("C:\\Program Files\\Apache24\\htdocs\\index.html");
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

*/
