package com.number.common;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getStringDate() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(currentTime);  
	    return dateString;  
	} 
	
	public static Date getNowDateShort() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String dateString = formatter.format(currentTime);  
	    ParsePosition pos = new ParsePosition(8);  
	    Date currentTime_2 = formatter.parse(dateString, pos);  
	    return currentTime_2;  
	}
	
	public static String getStringDateShort() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String dateString = formatter.format(currentTime);  
	    return dateString;  
	}  
	
	public static String dateToStrLong(java.util.Date dateDate) {  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(dateDate);  
	    return dateString;  
	}  
}
