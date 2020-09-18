package com.project.mbti.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ProjectUtils {
	
	public static String sqlDateToString(Date date, String format) {

		//format ex) YY/MM/dd hh:mm:ss, yyyy-MM-dd
		return new SimpleDateFormat(format).format(date);
	}
	
	public static Date stringToSqlDate(String strDate) {
		String year = "";
		String month = "";
		String day = "";
		if(strDate.length() == 8) {
			year = strDate.substring(0, 4);
			month = strDate.substring(4, 6);
			day = strDate.substring(6, 8);					
		} else if (strDate.length() == 10) {
			year = strDate.substring(0, 4);
			month = strDate.substring(5, 7);
			day = strDate.substring(8, 10);			
		}
		
		return Date.valueOf(year + "-" + month + "-" + day);
	}
	
	public static int getAgeFromDate(Date date) {
		int age = 0;
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		int currentYear = Integer.parseInt(yearFormat.format(System.currentTimeMillis()));
		int inputYear = Integer.parseInt(yearFormat.format(date));
		age = currentYear - inputYear;
		
		return age;
	}
	
	public static String insertStringIntoString(String oldStr, String newStr, String target) {
		int targetIndex = oldStr.indexOf(target);
		if(targetIndex == -1) return oldStr;
		
		return oldStr.substring(0, targetIndex) + newStr + oldStr.substring(targetIndex, oldStr.length());
	}
	
	public static void main(String[] args) {
		
	}

}
