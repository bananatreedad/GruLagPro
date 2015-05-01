package ch.bfh;

import java.util.ArrayList;

/**
 * The class <code>BodyDataTester</code> demonstrates the <code>BodyData</code>
 * class by calculating and printing some indices based on the <i>size</i> and
 * the <i>weight</i> of a human.
 * <p>
 * The test data are defined in an <code>ArrayList</code>.
 * <p>
 * Expected format of every element (dataset) of the <code>ArrayList</code>
 * (<i>Delimiter</i>: one or more BLANK(s)): example: <i>f 16 160 65.001 25.3910
 * 1.6997 48 60</i>
 * <p>
 * f</i>: gender; <i>16</i>: age; <i>160</i>: size; <i>65.001</i>: weight
 * <p>
 * Expected values: <br>
 * <i>25.3910</i>: BMI; <i>1.6997</i>: BSA; <i>48</i>: IBW; <i>60</i>: NBW
 * 
 * @author hans.roethlisberger@bfh.ch
 * @version V11.11.2013
 */
public class BodyDataTester {
	/**
	 * Constructs a <code>BodyData</code> object, gets the indices and prints
	 * them out.
	 * <p>
	 * Some indices are also formatted with <i>printf()</i>.
	 */
	public static void main(String[] args) {
		final char GENDER = 0; // Position of "gender" in a dataset.
		final int AGE = 1; // Position of "age" in a dataset.
		final int SIZE = 2; // Position of "size" in a dataset.
		final int WEIGHT = 3; // Position of "weight" in a dataset..
		final int BMI_EXP = 4; // Position of expected "BMI" in a dataset.
		final int BSA_EXP = 5; // Position of expected "BSA" in a dataset.
		final int IBW_EXP = 6; // Position of expected "IBW" in a dataset.
		final int NBW_EXP = 7; // Position of expected "NBW" in a dataset.
		final String REGEX_DATA = " +"; // Delimiter to split a dataset.

		final ArrayList<String> data = new ArrayList<>();

		// given: gender age size weight
		// expected: BMI BSA IBW NBW
		data.add(0, "f  16  160  65.001   25.3910  1.6997  48  60");
		data.add(1, "f  17  160  65       25.3906  1.6889  48  60");
		data.add(2, "M  18  160  65       25.3906  1.6889  54  60");
		data.add(3, "m  21  160  65       25.3906  1.6889  54  60");
		data.add(4, "f  22  160  65       25.3906  1.6782  48  60");
		data.add(5, "f  23  160  65       25.3906  1.6782  48  60");
		data.add(6, "m  52  182  69       20.8308  1.8899  74  82");

		for (int i = 0; i < data.size(); i++) {
			String[] splittedData = data.get(i).trim().split(REGEX_DATA);
			char gender = splittedData[GENDER].charAt(GENDER);
			int age = Integer.parseInt(splittedData[AGE]);
			int size = Integer.parseInt(splittedData[SIZE]);
			double weight = Double.parseDouble(splittedData[WEIGHT]);
			System.out.println("\nDataset: " + i + "\nInput data, gender: "
					+ gender + "  age: " + age + "  size: " + size + "  weight: "
					+ weight);
			BodyData bodyData = new BodyData(gender, age, size, weight);
			System.out.printf("-BMI: %.4f  expected: %s%n", bodyData.getBMI(),
					splittedData[BMI_EXP]);
			System.out.printf("-BSA: %.4f  expected: %s%n", bodyData.getBSA(),
					splittedData[BSA_EXP]);
			System.out.println("-IBW: " + bodyData.getIBW() + "  expected: "
					+ splittedData[IBW_EXP]);
			System.out.println("-NBW: " + bodyData.getNBW() + "  expected: "
					+ splittedData[NBW_EXP]);
		}
	}
}
