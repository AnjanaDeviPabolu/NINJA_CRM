package utility_Files;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtilityFile {
	
	public String getRequireddate(int days){
		Date date=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		sdf.format(date);
		
		Calendar cal=sdf.getCalendar();
		
		cal.add(Calendar.DAY_OF_MONTH, days);
		
		String requiredDate = sdf.format(cal.getTime());
		
		return requiredDate;
	}
	
	public int generateNineDigitNum() {
		Random random=new Random();
		int randomNum=random.nextInt(100000000, 999999999);
		return randomNum;
	}
	
	public int generateThreeDigitNum() {
		Random randomnumber=new Random();
		int randomThreeDigitNum=randomnumber.nextInt(100,999);
		return randomThreeDigitNum;
	}
	
	public String getCurrentdateandTime() {
		Date d=new Date();
		String date=d.toString().replace(" ", "_").replace(":", "_");
		return date;
	}

}
