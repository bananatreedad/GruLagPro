/**
 * 
 */
package ch.bananatreedad.bfh.java.deltatime;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author bananatreedad
 *
 */
public class DeltaTime {

    private final GregorianCalendar date1;
    private final GregorianCalendar date2;

    /**
     * Constructs a DeltaTime object on the base of a defined date and the
     * current time.
     * 
     * @param aDay
     * @param aMonth
     * @param aYear
     */
    DeltaTime(int aDay, int aMonth, int aYear) {
	date1 = new GregorianCalendar(aYear, aMonth, aDay);
	date2 = new GregorianCalendar(0, 0, 0);
	System.out.println(date2);
    }

    /**
     * 
     * @param aDay1
     * @param aMonth1
     * @param aYear1
     * @param aDay2
     * @param aMonth2
     * @param aYear2
     */
    DeltaTime(int aDay1, int aMonth1, int aYear1, int aDay2, int aMonth2,
	    int aYear2) {

	date1 = new GregorianCalendar(aYear1, aMonth1, aDay1);
	date2 = new GregorianCalendar(aYear2, aMonth2, aDay2);
    }

    /**
     * Returns the two dates defined (always sorted).<br>
     * Format: Date1=dd.mm.yyyy Date2=dd.mm.yyyy
     */
    public String getDatesDefined() {
	return "Date1=" + date1.get(Calendar.DAY_OF_MONTH) + " Date2=" + date2.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Returns the difference between the two dates in days.
     * 
     * @return
     */
    public long getDeltaTimeInDays() {
	return date1.getTime().getTime() - date2.getTime().getTime();
    }

    /**
     * Returns the difference between the two dates in h (hours).
     * 
     * @return
     */
    public long getDeltaTimeInMin() {
	return (date1.getTime().getTime() - date2.getTime().getTime()/1000/60);
    }

    /**
     * Returns the difference between the two dates in ms (milliseconds).
     * 
     * @return
     */
    public long getDeltaTimeInMs() {
	return (date1.getTime().getTime() - date2.getTime().getTime());
    }

    /**
     * Returns the difference between the two dates in s (seconds).  
     * 
     * @return 
     */
    public long getDeltaTimeInS() {
	return ((date1.getTime().getTime() - date2.getTime().getTime())/1000);
    }

    /**
    * Returns the difference between the two dates in years (rounded).
    * 
    * @return 
    */
    public long getDeltaTimeInYears() {
	return date1.get(Calendar.YEAR) - date2.get(Calendar.YEAR);
    }

    /**
     * Returns the difference between the two dates in years, months, days.
     * 
     * @return
     */
//    public SimpleDate getDeltaTimeInYearsMonthsDays() {
//
//    }
}
