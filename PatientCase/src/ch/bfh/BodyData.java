package ch.bfh;

/**
 * A <code>BodyData</code> object represents a human with the most important
 * parameters (gender, age, size, weight).
 * <p>
 * The class provides methods for calculating diverse indices.
 * <p>
 * Note: The input data are not validated.
 * 
 * @author hans.roethlisberger@bfh.ch
 * @version V09.11.2013
 */
public class BodyData {
    private final char MAN = 'm'; // for testing a condition
    private final char gender; // m, f
    private final int age; // years
    private final int size; // cm
    private final double weight; // kg

    /**
     * Constructs a <code>BodyData</code> object on the base of the
     * <i>gender</i>, <i>age</i>, <i>size</i> and <i>weight</i>.
     * 
     * @param aGender
     *            Gender of a human (should be: m, f).
     * @param anAge
     *            Age of a human in years (should be: >= 0).
     * @param aSize
     *            Size of a human in cm (should be: > 0, reasonable > 140).
     * @param aWeight
     *            Weight of a human in kg (should be: > 0).
     */
    public BodyData(char aGender, int anAge, int aSize, double aWeight) {
	gender = aGender; // m or f
	age = anAge; // years
	size = aSize; // cm
	weight = aWeight; // kg
    }

    /**
     * Returns the <i>Body Mass Index (BMI)</i> on the base of the <i>weight</i>
     * and the <i>size</i>.
     * 
     * @return Body Mass Index (BMI).
     */
    public double getBMI() {
	return weight * 10000 / size / size;
    }

    /**
     * Returns the <i>Normal Body Weight (NBW)</i> in kg according to the
     * <i>Broca index</i> on the base of the <i>size</i>.
     * <p>
     * Doesn't work well if: <i>160 > size > 190</i>.
     * 
     * @return Normal Body Weight (NBW) in kg.
     */
    public int getNBW() {
	return size - 100;
    }

    /**
     * Returns the <i>Ideal Body Weight (IBW)</i> in kg (rounded) according to
     * the <i>Broca index</i> on the base of the <i>gender</i> and the
     * <i>size</i>.
     * <p>
     * IBW(men) = NBW * 0.9; <br>
     * IBW(women) = NBW * 0.8).
     * <p>
     * Doesn't work well if: <i>160 > size > 190</i>
     * 
     * @return Ideal Body Weight (IBW) in kg.
     */
    public int getIBW() {
	final double FACTOR_MEN = 0.9;
	final double FACTOR_WOMEN = 0.8;

	if (Character.toLowerCase(gender) == MAN)
	    return (int) Math.round((size - 100) * FACTOR_MEN);
	else
	    // Now gender should be f
	    return (int) Math.round((size - 100) * FACTOR_WOMEN);
    }

    /**
     * Returns the <i>Body Surface Area (BSA)</i> in m<sup>2</sup> on the base
     * of the <i>age</i>, <i>size</i> and <i>weight</i>.
     * 
     * @return Body Surface Area (BSA) in m<sup>2</sup>.
     */
    public double getBSA() {
	final int AGE_CHILDREN = 17;
	final int AGE_ADULTS = 22;
	final double bsaChildren = Math.sqrt(weight * size / 3600);
	final double bsaAdults = (Math.pow(weight, 0.425)
		* Math.pow(size, 0.725) * 71.84) / 10000;

	double bsa;
	if (age < AGE_CHILDREN)
	    bsa = bsaChildren;
	else if (age >= AGE_ADULTS)
	    bsa = bsaAdults;
	else
	    bsa = (bsaChildren + bsaAdults) / 2;
	return bsa;
    }
}
