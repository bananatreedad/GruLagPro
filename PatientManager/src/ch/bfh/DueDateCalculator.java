package ch.bfh;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * A <code>DueDateCalculator</code> object has a date of a last menstrual
 * period. With its methods the expected due date is calculated according to
 * different rules.
 * <p>
 * Note: The input data are not validated.
 * 
 * @author hans.roethlisberger@bfh.ch
 * @version V12.08.2013
 */
public class DueDateCalculator {
    private final int year;
    private final int month;
    private final int day;

    /**
     * Constructs a <code>DueDateCalculator</code> object on the base of a
     * defined date of a last menstrual period.
     * 
     * @param aDay
     *            Day of a month (without leading 0).
     * @param aMonth
     *            Month of the year (without leading 0).
     * @param aYear
     *            Year (without leading 0).
     */
    public DueDateCalculator(int aDay, int aMonth, int aYear) {
	year = aYear;
	month = aMonth;
	day = aDay;
    }

    /**
     * Returns the expected due date according to the "standard rule".
     * 
     * @return Expected due date (Format: dd.mm.yyyy).
     */
    public String getDueDate() {
	GregorianCalendar date = new GregorianCalendar(year, month - 1, day);
	date.add(Calendar.WEEK_OF_YEAR, 40);
	date.add(Calendar.DAY_OF_YEAR, -1);
	return formatDate(date);
    }

    /**
     * Returns the expected due date according to Naegele's rule.
     * 
     * @return Expected due date (Format: dd.mm.yyyy).
     */
    public String getDueDateNaegele() {
	GregorianCalendar date = new GregorianCalendar(year, month - 1, day);
	date.add(Calendar.DAY_OF_YEAR, 7);
	date.add(Calendar.MONTH, -3);
	date.add(Calendar.YEAR, 1);
	return formatDate(date);
    }

    /**
     * Returns a date in a common format (dd.mm.yyyy).
     * 
     * @return Formatted date (Format: dd.mm.yyyy).
     */
    private String formatDate(GregorianCalendar calendarDate) {
	int year = calendarDate.get(Calendar.YEAR);
	int month = calendarDate.get(Calendar.MONTH) + 1;
	int day = calendarDate.get(Calendar.DAY_OF_MONTH);
	return String.format("%02d.%02d.%04d", day, month, year);
    }
}
