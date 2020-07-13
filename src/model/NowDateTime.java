package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class NowDateTime {

    //public static void main(String[] args) {
    public String nowDateTime() {

        LocalDateTime now = LocalDateTime.now();

        //---- Formatter (see Result following) ----
        //String nowDateTime = ldt.format(DateTimeFormatter.
        //	ofPattern("Y年M月d日(E) h時m分s秒"));

        //---- Format for MySQL as like 'YYYY-MM-DD hh:mm:ss' ----
        String nowStr = now.toString().substring(0, 19); // "."以下を除去
        String[] division = nowStr.toString().split("T");// "T"で分割
        String nowDateTime = String.join(" ", division);// " "で再結合

        //System.out.println(now);
        //System.out.println(nowDateTime);

        return nowDateTime;

    }//nowDateTime() or main()

    public String over24hDateTime() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime over24h = now.plus(24, ChronoUnit.HOURS);

        //---- Formatter (see Result following) ----
        //String nowDateTime = ldt.format(DateTimeFormatter.
        //	ofPattern("Y年M月d日(E) h時m分s秒"));

        //---- Format for MySQL as like 'YYYY-MM-DD hh:mm:ss' ----
        String over24hStr = over24h.toString().substring(0, 19); // "."以下を除去
        String[] division = over24hStr.toString().split("T");// "T"で分割
        String over24hDateTime = String.join(" ", division);// " "で再結合

        //System.out.println(now);
        //System.out.println(over24hDateTime);

        return over24hDateTime;

    }//Over24hDateTime()

}//class


/*
//====== Result / 結果 ======
LocalDateTime:2020-07-07T12:04:25.180645500
LocalDateTimeFormatter:2020年7月7日(火) 11時57分40秒

//====== Result after remake DB from varchar(40) to DateTime ======
LocalDateTime: 2020-07-13T08:47:30.169852200
nowDateTime:   2020-07-13 08:47:30

//====== Result of 'over24h' ======
LocalDateTime.now: 2020-07-13T09:33:38.926300300
over24hDateTime:   2020-07-14 09:33:38
*/
