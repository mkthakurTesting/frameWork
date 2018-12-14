package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeAndDate {
	static DateFormat dateFormat;	
	static Date date ;
	
	public static String getTodayDate(){
		
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		date = new Date();
	  return 	dateFormat.format(date);
		
	}
	
	public static String getCurrentTime(){
		dateFormat = new SimpleDateFormat("HH:mm:ss");
		date = new Date();
	  return 	dateFormat.format(date);	
		
	}
	
	public static  String getFutureDate(int EnterFutureDate){
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		date = new Date();
		Calendar cal = Calendar.getInstance();
	  
	   cal.add(Calendar.DATE, EnterFutureDate);
	
	   return   dateFormat.format(cal.getTime());
		
		
	}
	
	public static String getFutureMonth(int EnterFutureMonth){
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		date = new Date();
		Calendar cal = Calendar.getInstance();
	  
	   cal.add(Calendar.MONTH, EnterFutureMonth);
	
	   return   dateFormat.format(cal.getTime());
		
	}
	public static String getFutureYear(int EnterFutureYear){
		
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		date = new Date();
		Calendar cal = Calendar.getInstance();
	  
	   cal.add(Calendar.YEAR, EnterFutureYear);
	
	   return   dateFormat.format(cal.getTime());
		
	}
	
	

}
