package com.gatesgtbit.utils;

import java.util.Calendar;
import java.util.TimeZone;

public class UTC {
	public static void main(String args[])
	{	Calendar cal=Calendar.getInstance(TimeZone.getTimeZone("IST"));
		cal.set(Calendar.HOUR_OF_DAY,9);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);
<<<<<<< HEAD
		cal.set(Calendar.DAY_OF_MONTH,30);
=======
		cal.set(Calendar.DAY_OF_MONTH,29);
		
		//Dont Change these
>>>>>>> 58ad659243679437b43c7ea70d52c5cc3328b1c7
		cal.set(Calendar.MONTH,2);
		cal.set(Calendar.YEAR,2016);
		System.out.println(cal.getTimeInMillis());
	}
}
