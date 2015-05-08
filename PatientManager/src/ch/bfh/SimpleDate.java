package ch.bfh;

/**
 * A <code>SimpleDate</code> object represents a date or a number of <i>days,
 * months, years</i> which can be accessed by its fields.
 * <p>
 * Note: The input data are not validated.
 * 
 * @author hans.roethlisberger@bfh.ch
 * @version V12.08.2013
 */
public class SimpleDate { // No validation.
    /**
     * The <i>day</i> of the <i>date</i> or the number of <i>days</i>.
     */
    public final int day;

    /**
     * The <i>month</i> of the <i>date</i> or the number of <i>months</i>.
     */
    public final int month;

    /**
     * The <i>year</i> of the <i>date</i> or the number of <i>years</i>.
     */
    public final int year;

    /**
     * Constructs a <code>SimpleDate</code> object on the base of a defined date
     * or the defined number of <i>days, months and years</i>.
     * 
     * @param aDate
     *            A <i>date</i> or a number of <i>days, months, years</i> in the
     *            following format: <i>dd.mm.yyyy</i>
     */
    public SimpleDate(String aDate) {
	day = Integer.parseInt(aDate.substring(0, 2));
	month = Integer.parseInt(aDate.substring(3, 5));
	year = Integer.parseInt(aDate.substring(6, 10));
    }

    /**
     * Constructs a <code>SimpleDate</code> object on the base of a defined
     * <i>date</i> or the defined number of <i>days, months and years</i>.
     * 
     * @param aDay
     *            <i>Day</i> of a <i>date</i> or a number of <i>days</i>
     *            (without leading 0).
     * @param aMonth
     *            <i>Month</i> of a <i>date</i> or an number of <i>months</i>
     *            (without leading 0).
     * @param aYear
     *            The <i>year</i> of a <i>date</i> or a number of <i>years</i>
     *            (without leading 0).
     */
    public SimpleDate(int aDay, int aMonth, int aYear) {
	day = aDay;
	month = aMonth;
	year = aYear;
    }
}
