package users.helperFuncs;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalcAge {
	public int age (Calendar input) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = sdf.format(input.getTime());
		int inputYear = Integer.parseInt(formatted.substring(0, 4));
		int inputMonth = Integer.parseInt(formatted.substring(5, 7));
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH);
		
		int yearDifference = currentYear - inputYear;	
		
		return 	(inputMonth > currentMonth)? yearDifference-1 : yearDifference;
	}
}
