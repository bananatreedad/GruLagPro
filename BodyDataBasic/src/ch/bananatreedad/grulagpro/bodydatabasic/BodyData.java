package ch.bananatreedad.grulagpro.bodydatabasic;

/**
 * This class encapsulates the body data of a human person. <br>
 * These are:
 * <ul>
 * <li>the persons size</li>
 * <li>the persons weight</li>
 * <li>the persons gender</li>
 * <li>the persons age</li>
 * </ul>
 * 
 * 
 * @author bananatreedad
 * @version 2.0
 *
 */
public class BodyData {

    final private double SIZE;
    final private double WEIGHT;
    final private BodyData.Gender GENDER;
    final private int AGE;

    /**
     * Construcs a <code>BodyData</code> with <b>unchangable</b> content.
     * 
     * @param size
     *            The size in centimetres.
     * @param weight
     *            The weight in kilograms.
     * @param gender
     *            The gender - 'm' for male or 'f' for female.
     * @param age
     *            The age in years.
     */
    public BodyData(double size, double weight, BodyData.Gender gender, int age) {
	super();
	this.SIZE = size;
	this.WEIGHT = weight;
	this.GENDER = gender;
	this.AGE = age;
    }

    /**
     * Computes and returns the BMI of the person with the set {@code size} and
     * {@code weight} as a double accurate to 2 decimal places.
     * 
     * @return the Body Mass Index (BMI) on the base of the size and the weight.
     */
    public double getBMI() {
	double bmi = WEIGHT / Math.pow(SIZE / 100, 2);

	return Double.parseDouble(String.format("%.2f", bmi));
    }
    
    /**
     * Computes and returns the BSA <i>(Body Surface Area)</i> in m2 of the
     * person with the set {@code size} and {@code weight} as a double acurate
     * to 2 decimal places - for adults {@code (age >= 22years)}.
     * 
     * @return the BSA in m2
     */
    private double getBSAadults() {
	double bsa = ((Math.pow(WEIGHT, 0.425) * Math.pow(SIZE, 0.725)) * 71.84) / 10000;

	return Double.parseDouble(String.format("%.2f", bsa));
    }

    /**
     * Computes and returns the BSA <i>(Body Surface Area)</i> in m2 of the
     * person with the set {@code size} and {@code weight} as a double acurate
     * to 2 decimal places - for children {@code (age < 7 years)}.
     * 
     * @return the BSA in m2
     */
    private double getBSAchildren() {
	double bsa = Math.sqrt(WEIGHT * SIZE / 3600);

	return Double.parseDouble(String.format("%.2f", bsa));
    }

    /**
     * Computes and returns the BSA <i>(Body Surface Area)</i> in m2 of the
     * person with the set {@code size} and {@code weight} as a double acurate
     * to 2 decimal places - for young Adults {@code (17 <= age < 22 years)}.
     * 
     * @return the BSA in m2
     */
    private double getBSAyoungAdults() {
	return Double.parseDouble(String.format("%.2f",
		(getBSAchildren() + getBSAadults()) / 2));
    }

    /**
     * Calculates the BSA <i>(Body Surface Area</i> out of the given body data.
     * 
     * @param age
     *            the age of the given person
     * @return the BSA in m2
     */
    public double getBSA() {

	if (this.AGE >= 22) {
	    return getBSAadults();
	} else if (this.AGE < 17) {
	    return getBSAchildren();
	} else if (this.AGE >= 17 && this.AGE < 22) {
	    return getBSAyoungAdults();
	} else
	    throw new IllegalArgumentException(
		    "No idea how you could enter an int with this value.. :|");
    }

    /**
     * Computes and returns the rounded IBW <i>(Ideal Body Weight)</i> for a
     * men.
     * 
     * @return the Ideal Body Weight (IBW) in kg (rounded to floor) for men
     *         according to the Broca index on the base of the size
     */
    private int getIBWmen() {
	double IBWunrounded = ((SIZE - 100) * 0.9);

	return castLongToInt(Math.round(IBWunrounded));
    }

    /**
     * Computes and returns the rounded IBW <i>(Ideal Body Weight)</i> for a
     * woman.
     * 
     * @return the Ideal Body Weight (IBW) in kg (rounded to floor) for women
     *         according to the Broca index on the base of the size
     */
    private int getIBWwomen() {
	double IBWunrounded = ((SIZE - 100) * 0.8);

	return castLongToInt(Math.round(IBWunrounded));
    }

    public enum Gender {
	MALE, FEMALE, UNSPECIFIED;

	/**
	 * This function takes a String containing {@code 'm'} or {@code 'male'}
	 * for a man or {@code 'f'} or {@code 'female'} for a woman and returns
	 * the {@code BodyDataBasic.Gender} for this gender.
	 * 
	 * @param gender
	 *            the gender
	 * @return the gender in {@code BodyDataBasic.Gender}
	 */
	public static BodyData.Gender parseGender(String gender) {

	    if (gender.equals("m") || gender.equals("male")) {
		return Gender.MALE;
	    } else if (gender.equals("f") || gender.equals("female")) {
		return Gender.FEMALE;
	    } else
		return Gender.UNSPECIFIED;
	}
    }

    /**
     * Calculates and returns the IBW <i>Ideal Body Weight</i> out of the actual
     * body data.
     * 
     * @param gender
     *            the gender
     * @return the IBW
     */
    public int getIBW() throws Exception {

	if (SIZE >= 190 || SIZE <= 160) {
	    throw new Exception(
		    "The size has to be between 190 and 160 cm for reliable IBW calculation.");
	}

	if (this.GENDER == Gender.FEMALE) {
	    return getIBWwomen();
	} else if (this.GENDER == Gender.MALE) {
	    return getIBWmen();
	} else
	    throw new IllegalArgumentException("No valid gender as argument.");
    }

    /**
     * Computes and returns the rounded IBW <i>(Ideal Body Weight)</i> for the
     * given person in kg.
     * 
     * @return the Normal Body Weight (NBW) in kg according to the Broca index
     *         on the base of the size.
     */
    public int getNBW() {
	return castLongToInt(Math.round(SIZE - 100));
    }

    /**
     * This function provides the possibility to cast a {@code long} to
     * {@code int} without a loss of data. If the given data is out of range of
     * the int-size it returns an {@code IllegalArgumentException}.
     * 
     * @param toBeCasted
     *            the long to cast to int
     * @return the int value of the given long
     * @throws IllegalArgumentException
     */
    private static int castLongToInt(long toBeCasted)
	    throws IllegalArgumentException {

	if (toBeCasted > Integer.MAX_VALUE || toBeCasted < Integer.MIN_VALUE) {
	    throw new IllegalArgumentException("Data would be lost if casted.");
	}
	return (int) toBeCasted;

    }

    /**
     * Returns the Object fomatted as the following string:<br>
     * ch.banananatreedad.grulagpro.bodydatabasic.BodyDataBasic@2b193f2dsize:
     * 180.0cm, weight: 72.0kg, age: 22 years, gender: male
     */
    @Override
    public String toString() {
	String gender = "male";
	if (this.GENDER == Gender.FEMALE) {
	    gender = "female";
	} else if (this.GENDER == Gender.UNSPECIFIED) {
	    gender = "UNSPECIFIED";
	}

	return "size: " + SIZE + "cm, " + "weight: "
		+ WEIGHT + "kg, age: " + AGE + " years, gender: " + gender;
    }
}
