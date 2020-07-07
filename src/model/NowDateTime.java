package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NowDateTime {

	//public static void main(String[] args) {
	public String nowDateTime() {

		LocalDateTime ldt = LocalDateTime.now();
		String nowDateTime = ldt.format(DateTimeFormatter.
			ofPattern("Y年M月d日(E) h時m分s秒"));

		//System.out.println(nowDateTime);

		return nowDateTime;

	}

}

/*結果
LocalDateTime:2020-07-07T12:04:25.180645500
LocalDateTimeFormatter:2020年7月7日(火) 11時57分40秒
*/
