package com.gatesgtbit.utils;

import java.util.Calendar;
import java.util.TimeZone;

public class UTC {
	public static void main(String args[])
	{	Calendar cal=Calendar.getInstance(TimeZone.getTimeZone("IST"));
		cal.set(Calendar.HOUR_OF_DAY,11);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);
		cal.set(Calendar.DAY_OF_MONTH,31);
		cal.set(Calendar.MONTH,2);
		cal.set(Calendar.YEAR,2016);
		System.out.println(cal.getTimeInMillis());
	}
}
