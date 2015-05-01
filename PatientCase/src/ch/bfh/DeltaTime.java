package ch.bfh;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * A <code>DeltaTime</code> object has two dates.
 * <p>
 * With its methods the differences between the two dates are calculated and
 * returned (time units: <i>ms, s, minutes, hours, days; years, months,
 * days</i>).
 * <p>
 * Note: The input data are not validated.
 * 
 * @author hans.roethlisberger@bfh.ch
 * @version V06.04.2014
 */
public class DeltaTime {
    private GregorianCalendar calDate1;
    private GregorianCalendar calDate2;
    private int year1;
    private int year2;
    private int month1;
    private int month2;
    private int day1;
    private int day2;
    private long date1InMilliS;
    private long date2InMilliS;

    /**
     * Constructs a <code>DeltaTime</code> object on the base of a defined date
     * and the current time.
     * 
     * @param aDay
     *            <i>Day</i> of a month (without leading 0).
     * @param aMonth
     *            <i>Month</i> of the year (without leading 0).
     * @param aYear
     *            <i>Year</i> (without leading 0).
     */
    public DeltaTime(int aDay, int aMonth, int aYear) {
	GregorianCalendar calDate1 = new GregorianCalendar();
	calDate1.set(GregorianCalendar.HOUR_OF_DAY, 0);
	calDate1.set(GregorianCalendar.MINUTE, 0);
	calDate1.set(GregorianCalendar.SECOND, 0);
	calDate1.set(GregorianCalendar.MILLISECOND, 0);
	GregorianCalendar calDate2 = new GregorianCalendar(aYear, aMonth - 1,
		aDay);
	buildCalendars(calDate1, calDate2);
    }

    /**
     * Constructs a <code>DeltaTime</code> object on the base of two defined
     * dates. The two dates can be defined in any order.
     * 
     * @param aDay1
     *            <i>Date 1: Day</i> of a month (without leading 0).
     * @param aMonth1
     *            <i>Date 1: Month</i> of the year (without leading 0).
     * @param aYear1
     *            <i>Date 1: Year</i> (without leading 0).
     * @param aDay2
     *            <i>Date 2: Day</i> of a month (without leading 0).
     * @param aMonth2
     *            <i>Date 2: Month</i> of the year (without leading 0).
     * @param aYear2
     *            <i>Date 2: Year</i> (without leading 0).
     */
    public DeltaTime(int aDay1, int aMonth1, int aYear1, int aDay2,
	    int aMonth2, int aYear2) {
	GregorianCalendar calDate1 = new GregorianCalendar(aYear1, aMonth1 - 1,
		aDay1);
	GregorianCalendar calDate2 = new GregorianCalendar(aYear2, aMonth2 - 1,
		aDay2);
	buildCalendars(calDate1, calDate2);
    }

    // Sorts the two dates in order to define its calendars.
    private void buildCalendars(GregorianCalendar aCalDate1,
	    GregorianCalendar aCalDate2) {
	// The standard time zone (id=Europe/Berlin) produces errors if the
	// date 5/6.04.1980 (introduction DST) is included in the time interval.
	aCalDate1.setTimeZone(TimeZone.getTimeZone("UTC"));
	aCalDate2.setTimeZone(TimeZone.getTimeZone("UTC"));

	if (aCalDate1.after(aCalDate2)) { // sorts the dates (date1 > date2)
	    calDate1 = aCalDate1;
	    calDate2 = aCalDate2;
	} else {
	    calDate1 = aCalDate2;
	    calDate2 = aCalDate1;
	}
	// Defines the calendars for the two dates.
	year1 = calDate1.get(Calendar.YEAR);
	month1 = calDate1.get(Calendar.MONTH) + 1;
	day1 = calDate1.get(Calendar.DAY_OF_MONTH);
	date1InMilliS = calDate1.getTimeInMillis();

	year2 = calDate2.get(Calendar.YEAR);
	month2 = calDate2.get(Calendar.MONTH) + 1;
	day2 = calDate2.get(Calendar.DAY_OF_MONTH);
	date2InMilliS = calDate2.getTimeInMillis();
    }

    /**
     * Returns the two defined dates.
     * 
     * @return The two defined dates (always sorted). Format: Date1=dd.mm.yyyy
     *         Date2=dd.mm.yyyy
     */
    public String getDatesDefined() {
	return String.format("Date1=%02d.%02d.%04d  Date2=%02d.%02d.%04d",
		day1, month1, year1, day2, month2, year2);
    }

    /**
     * Returns the difference between the two dates in <i>ms</i> (milliseconds).
     * 
     * @return The difference between the two dates in <i>ms</i> (milliseconds).
     */
    public long getDeltaTimeInMs() {
	return date1InMilliS - date2InMilliS;
    }

    /**
     * Returns the difference between the two dates in <i>s</i> (seconds).
     * 
     * @return The difference between the two dates in <i>s</i> (seconds).
     */
    public long getDeltaTimeInS() {
	return TimeUnit.MILLISECONDS.toSeconds(date1InMilliS - date2InMilliS);
    }

    /**
     * Returns the difference between the two dates in <i>min</i> (minutes).
     * 
     * @return The difference between the two dates in <i>min</i> (minutes).
     */
    public long getDeltaTimeInMin() {
	return TimeUnit.MILLISECONDS.toMinutes(date1InMilliS - date2InMilliS);
    }

    /**
     * Returns the difference between the two dates in <i>h</i> (hours).
     * 
     * @return The difference between the two dates in <i>h</i> (hours).
     */
    public long getDeltaTimeInHours() {
	return TimeUnit.MILLISECONDS.toHours(date1InMilliS - date2InMilliS);
    }

    /**
     * Returns the difference between the two dates in <i>days</i>.
     * 
     * @return The difference between the two dates in <i>days</i>.
     */
    public long getDeltaTimeInDays() {
	return TimeUnit.MILLISECONDS.toDays(date1InMilliS - date2InMilliS);
    }

    /**
     * Returns the difference between the two dates in <i>years, months,
     * days</i>.
     * 
     * @return The difference between the two dates in <i>years, months,
     *         days</i> as object of the class <i>FormattedDate</i>.
     */
    public SimpleDate getDeltaTimeInYearsMonthsDays() {
	final int MONTHS_PER_YEAR = 12;
	int years = 0;
	int months = 0;
	int days = 0;

	years = year1 - year2;

	if (month1 >= month2) {
	    months = month1 - month2;
	} else {
	    months = MONTHS_PER_YEAR - month2 + month1;
	    years--;
	}

	if (day1 >= day2) {
	    days = day1 - day2;
	} else {
	    days = calDate2.getActualMaximum(Calendar.DAY_OF_MONTH) - day2
		    + day1;
	    if (months > 0)
		months--;
	    else {
		years--;
		months = MONTHS_PER_YEAR - 1;
	    }
	}
	return new SimpleDate(days, months, years);
    }

    /**
     * Returns the difference between the two dates in <i>years</i> (rounded).
     * 
     * @return The difference between the two dates in <i>years</i> (rounded).
     */
    public int getDeltaTimeInYears() {
	final int MIDDLE_OF_THE_YEAR = 7; // middle of the year >= July, month 7
	SimpleDate simpleDate = getDeltaTimeInYearsMonthsDays();

	if (simpleDate.month < MIDDLE_OF_THE_YEAR)
	    return simpleDate.year;
	else
	    return simpleDate.year + 1;
    }
}
