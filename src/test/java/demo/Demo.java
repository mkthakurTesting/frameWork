package demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;



class Demo {

	public static void main(String[] args) {
		
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	 String	firstDate = "12/05/2015";
	 String secondDate = "15/05/2018";
	 LocalDate pastDate = LocalDate.parse(firstDate, formatter);
	 LocalDate todayDate = LocalDate.parse(secondDate, formatter);
	 long daydiff = ChronoUnit.MONTHS.between(pastDate, todayDate);
	 System.out.println("Month is :--"+daydiff);
	 
	 
	}

}
