import java.io.*;
import java.lang.String;
import java.util.*;
import org.joda.time.DateTime;
import org.joda.time.DateMidnight;
import org.joda.time.Months;
import org.joda.time.MutableDateTime;

import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.Months;

class MyTime 
{
	public static void main(String args[])
	{
					String pattern = "E MM/dd/yyyy HH:mm:ss.SSS";
					System.out.println("mytime");
					DateTime dt = new DateTime();
					int month = dt.getMonthOfYear();
					System.out.println("month="+month);
					System.out.println(dt.toString(pattern));

                    /*
                    DateTime mydt = new DateTime();
					System.out.println("now()="+mydt.toString(pattern));
                    */

					DateMidnight start = new DateMidnight("2010-01-01");
					DateMidnight end = new DateMidnight(new Date());

					int mon = Months.monthsBetween(start, end).getMonths();

					System.out.println("Months between" + start.toString("yyyy-MM-dd") + " and "
													+ end.toString("yyyy-MM-dd") + " = " + mon + " month(s)");

					MutableDateTime dateTime = new MutableDateTime();
					System.out.println("dateTime="+dateTime);

					dateTime.addMonths(1);
					dateTime.setDayOfMonth(1);
					dateTime.setMillisOfDay(0);
					System.out.println("First day of next month=" + dateTime);

					DateTime startDate = new DateTime();
					DateTime endDate = startDate.plus(Months.months(2));

					//create an interval from a start to end instant.

					Interval interval = new Interval(startDate, endDate);
					System.out.println("Interval=" + interval);
					System.out.println("Start   =" + interval.getStart());
					System.out.println("End     =" + interval.getEnd());

					//Add one more month to the interval
					interval = interval.withEnd(interval.getEnd().plusMonths(1));
					System.out.println("Interval =" + interval);

					//Gets teh duration of the time interval

					Duration duration = interval.toDuration();
					System.out.println("Duration =" + duration);

					DateTime mydatetime = new DateTime();
					System.out.println("mydatetime=" + mydatetime);

					//plus some hours, minutes, and second to the original time
                    System.out.println("Plus 1 hours is " + mydatetime.plusHours(1));	
                    System.out.println("Plus 10 minutes is " + mydatetime.plusMinutes(10));	
                    System.out.println("Plus 59 second is " + mydatetime.plusSeconds(59));	

					//minus some hours, minutes, and seconds to the original DateTime
					System.out.println("Minus 1 hours is "+mydatetime.minusHours(1));
					System.out.println("Minus 10 minutes is "+mydatetime.minusMinutes(10));
					System.out.println("Minus 59 second is "+mydatetime.minusSeconds(59));


  }
}
