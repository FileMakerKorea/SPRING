package com.project.mbti.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ProjectUtils {
	
	public static String sqlDateToString(Date date, String format) {

		//format ex) YY/MM/dd hh:mm:ss, yyyy-MM-dd
		return new SimpleDateFormat(format).format(date);
	}
	
	public static Date stringToSqlDate(String strDate) {
		String year = strDate.substring(0, 4);
		String month = strDate.substring(4, 6);
		String day = strDate.substring(6, 8);		
		
		return Date.valueOf(year + "-" + month + "-" + day);
	}
}
