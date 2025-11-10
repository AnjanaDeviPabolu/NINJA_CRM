package ninjaCRM;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFromCalenderCode {

	public static void main(String[] args) {

		Date date=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		sdf.format(date);
		
		Calendar cal=sdf.getCalendar();
		
		cal.add(Calendar.DAY_OF_MONTH, 20);
		
		String requiredDate = sdf.format(cal.getTime());
		
		
		
//		Date date=new Date();
//		
//		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
//		
//		Calendar cal=Calendar.getInstance();
//		
//		//cal.setTime(date);
//		
//		cal.add(Calendar.DAY_OF_MONTH, -10);
//		
//		//cal.add(Calendar.YEAR, -1);
//		
//		System.out.println(sdf.format(cal.getTime()));
		
	}

}
