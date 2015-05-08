package ch.bfh;

/**
 * A <code>PatientCase</code> object represents a <code>Patient</code> with its
 * most important data (for example: admission reason, admission date, weight,
 * size, ...) in order to define a patient case (simplification).
 * <p>
 * The class provides methods to get and set diverse indices.
 * <p>
 * Note: The input data are not validated.
 * 
 * @author hans.roethlisberger@bfh.ch
 * @version V20.11.2014
 */
public class PatientCase {
    private final long caseID;
    private final String admReason;
    private final String admDate; // Admission date: dd.mm.yyyy
    private final int size; // cm
    private final double weight; // kg
    private final char gender;

    private final DeltaTime age;
    private final BodyData bodyData;
    private String menstrDate = null; // For calculating the due date: dd.mm.yyy

    /**
     * Constructs a <code>PatientCase</code> object on the base of different
     * parameters.
     * 
     * @param aCaseID
     *            Case ID
     * @param anAdmReason
     *            Reason of the admission.
     * @param anAdmDate
     *            Date of the admission (Format: <i>dd.mm.yyyy</i>).
     * @param aSize
     *            Size of the patient in <i>cm</i> (should be: > 0, reasonable >
     *            140).
     * @param aWeight
     *            Weight of the patient in <i>kg</i> (should be: > 0).
     * @param aDateOfBirth
     *            Date of birth of the patient (Format: <i>dd.mm.yyyy</i>).
     * @param aGender
     *            Gender of the patient (should be: <i>m</i>, <i>f</i>).
     */
    public PatientCase(long aCaseID, String anAdmReason, String anAdmDate,
	    int aSize, int aWeight, String aDateOfBirth, char aGender) {
	caseID = aCaseID; // The case ID is normally provided by the DB.
	admReason = anAdmReason;
	admDate = anAdmDate;
	size = aSize;
	weight = aWeight;
	SimpleDate dateOfBirth = new SimpleDate(aDateOfBirth);
	gender = aGender;

	SimpleDate date = new SimpleDate(anAdmDate);
	age = new DeltaTime(date.day, date.month, date.year, dateOfBirth.day,
		dateOfBirth.month, dateOfBirth.year);
	bodyData = new BodyData(gender, age.getDeltaTimeInYears(), size, weight);
    }

    /**
     * Returns the admission date.
     * 
     * @return The admission date (Format: <i>dd.mm.yyyy</i>)
     */
    public String getAdmissionDate() {
	return admDate;
    }

    /**
     * Returns the admission reason.
     * 
     * @return The admission reason.
     */
    public String getAdmissionReason() {
	return admReason;
    }

    /**
     * Returns the age of the patient in <i>years</i>, <i>months</i> and
     * <i>days</i> at the admission.
     * 
     * @return The age of the patient in <i>years</i>, <i>months</i> and
     *         <i>days</i> at the admission.
     */
    public SimpleDate getAge() {
	return age.getDeltaTimeInYearsMonthsDays();
    }

    /**
     * Returns the age of the patient in <i>years</i> at the admission.
     * 
     * @return The age of the patient in <i>years</i> at the admission.
     */
    public int getAgeInYears() {
	return age.getDeltaTimeInYears();
    }

    /**
     * Returns the Body Mass Index (BMI) on the base of the weight and the size
     * at the admission.
     * 
     * @return The Body Mass Index (BMI).
     */
    public double getBMI() {
	return bodyData.getBMI();
    }

    /**
     * Returns the Body Surface Area (BSA) in <i>m<sup>2</sup></i> on the base
     * of the age, size and weight at the admission.
     * 
     * @return The Body Surface Area (BSA) in <i>m<sup>2</sup></i>.
     */
    public double getBSA() {
	return bodyData.getBSA();
    }

    /**
     * Returns the case ID.
     * 
     * @return The case ID.
     */
    public long getCaseID() {
	return caseID;
    }

    /**
     * Returns the expected due date according to the "standard rule" on the
     * base of the date of the last menstrual period.
     * 
     * @return The expected due date according to the "standard rule" (Format:
     *         <i>dd.mm.yyyy</i>). If no date is defined, <code>null</code> is
     *         returned.
     */
    public String getDueDate() {
	if (menstrDate == null)
	    return null; // No date defined.
	SimpleDate date = new SimpleDate(menstrDate);
	return new DueDateCalculator(date.day, date.month, date.year)
		.getDueDate();
    }

    /**
     * Returns the expected due date according to Naegele's rule on the base of
     * the date of the last menstrual period.
     * 
     * @return The expected due date according to Naegele's rule (Format:
     *         <i>dd.mm.yyyy</i>). If no date is defined, <code>null</code> is
     *         returned.
     */
    public String getDueDateNaegele() {
	if (menstrDate == null)
	    return null; // No date defined.
	SimpleDate date = new SimpleDate(menstrDate);
	return new DueDateCalculator(date.day, date.month, date.year)
		.getDueDateNaegele();
    }

    /**
     * Returns the size of the patient in <i>cm</i> at the admission.
     * 
     * @return The size of the patient in <i>cm</i> at the admission.
     */
    public int getSize() {
	return size;
    }

    /**
     * Returns the weight of the patient in <i>kg</i> at the admission.
     * 
     * @return The weight of the patient in <i>kg</i> at the admission.
     */
    public double getWeight() {
	return weight;
    }

    /**
     * Sets the date of the last menstrual period.
     * 
     * @param aDate
     *            The date of the last menstrual period (Format: dd.mm.yyyy).
     */
    public void setDateOfLastMenstrualPeriod(String aDate) {
	menstrDate = aDate;
    }

    /**
     * Returns a String representation of this <code>PatientCase</code>.
     * 
     * @return String representation of this <code>PatientCase</code>.
     */
    @Override
    public String toString() {
	String str;
	str = String
		.format("FID: %d | Adm. reason: %s | Adm. date: %s%nAge(years|"
			+ "months|days): %d|%d|%d%nSize: %d | Weight: %.1f%nBMI: %.1f | BSA: "
			+ "%.2f ", caseID, admReason, admDate, getAge().year,
			getAge().month, getAge().day, size, weight,
			bodyData.getBMI(), bodyData.getBSA());
	if (gender == 'f' && menstrDate != null) {
	    str = str
		    + String.format(
			    "%nLast menstr: %s | Due date: %s%nDue date"
				    + "(Naegele): %s", menstrDate,
			    getDueDate(), getDueDateNaegele());
	}
	return str;
    }
}
