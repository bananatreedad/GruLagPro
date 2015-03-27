package ch.banananatreedad.grulagpro.bodydatabasic.unittest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import ch.banananatreedad.grulagpro.bodydatabasic.BodyData;
import ch.banananatreedad.grulagpro.bodydatabasic.BodyData.Gender;

public class TestBodyData {

    // Testsets
    BodyData testDataNormalMaleTeen = new BodyData(183, 71, Gender.MALE, 19);
    BodyData testDataNormalFemaleTeen = new BodyData(170, 60, Gender.FEMALE, 20);
    BodyData testDataNormalUncspecified = new BodyData(170, 60,
	    Gender.UNSPECIFIED, 20);
    BodyData testDataTooTallMale = new BodyData(200, 120, Gender.MALE, 30);
    BodyData testDataTooSmallFemale = new BodyData(130, 40, Gender.FEMALE, 10);
    BodyData testDataTooTallUnspecified = new BodyData(210, 120,
	    Gender.UNSPECIFIED, 28);
    BodyData testDataTooSmallUnspecified = new BodyData(130, 60,
	    Gender.UNSPECIFIED, 35);

    // Additional testsets for BSA testing
    BodyData testDataNormalMaleAdult = new BodyData(183, 71, Gender.MALE, 30);
    BodyData testDataNormalFemaleAdult = new BodyData(170, 60, Gender.FEMALE,
	    30);
    BodyData testDataNormalMaleKid = new BodyData(140, 60, Gender.MALE, 13);
    BodyData testDataNormalFemaleKid = new BodyData(140, 40, Gender.FEMALE, 13);

    /**
     * Contains no tests but prints the used test variables to the console.<br>
     * Uncomment @Test to run or not.
     */
    // @Test
    public void printAllTestVariables() {
	System.out.println("testDataNormalMale: " + testDataNormalMaleTeen);
	System.out.println("testDataNormalFemale: " + testDataNormalFemaleTeen);
	System.out.println("testDataNormalUncspecified: + "
		+ testDataNormalUncspecified);
	System.out.println("testDataToTallMale: " + testDataTooTallMale);
	System.out.println("testDataTooSmallFemale: " + testDataTooSmallFemale);
	System.out.println("testDataTooTallUnspecified: "
		+ testDataTooTallUnspecified);
	System.out.println("testDataTooSmallUnspecified: "
		+ testDataTooSmallUnspecified);
    }

    /**
     * Tests some arithmetic exceptions.
     */
    @Test
    public void testArithmeticExpressions() {

	double test = 5 / 8;
	System.out.println("5 / 8 = " + test);
	assertTrue(test != 0.625);

	test = 5 / 8.0;
	System.out.println("5 / 8.0 = " + test);
	assertTrue(test == 0.625);
    }

    /**
     * Tests the functionality of {@code BodyData.getBMI()}
     */
    @Test
    public void testBMI() {
	double bmi = testDataNormalFemaleTeen.getBMI();
	System.out.println("testDataNormalFemale.getBMI(): " + bmi);
	assertTrue(bmi == 20.76);
	bmi = testDataNormalMaleTeen.getBMI();
	System.out.println("testDataNormalMale.getBMI(): " + bmi);
	assertTrue(bmi == 21.2);
	bmi = testDataNormalUncspecified.getBMI();
	System.out.println("testDataNormalUncspecified.getBMI(): " + bmi);
	assertTrue(bmi == 20.76);
	bmi = testDataTooSmallFemale.getBMI();
	System.out.println("testDataTooSmallFemale.getBMI(): " + bmi);
	assertTrue(bmi == 23.67);
	bmi = testDataTooSmallUnspecified.getBMI();
	System.out.println("testDataTooSmallUnspecified.getBMI(): " + bmi);
	assertTrue(bmi == 35.5);
	bmi = testDataTooTallUnspecified.getBMI();
	System.out.println("testDataTooTallUnspecified.getBMI(): " + bmi);
	assertTrue(bmi == 27.21);
	bmi = testDataTooTallMale.getBMI();
	System.out.println("testDataTooTallMale.getBMI(): " + bmi);
	assertTrue(bmi == 30.0);
    }

    /**
     * Tests the functionality of {@code BodyData.getBSA()}
     */
    @Test
    public void testBSA() {

	double bsa = testDataNormalFemaleAdult.getBSA();
	System.out.println("testDataNormalFemaleAdult.getBSA(): " + bsa);
	assertTrue(bsa == 1.69);
	bsa = testDataNormalFemaleKid.getBSA();
	System.out.println("testDataNormalFemaleKid.getBSA(): " + bsa);
	assertTrue(bsa == 1.25);
	bsa = testDataNormalFemaleTeen.getBSA();
	System.out.println("testDataNormalFemaleTeen.getBSA(): " + bsa);
	assertTrue(bsa == 1.69);
	bsa = testDataNormalMaleAdult.getBSA();
	System.out.println("testDataNormalMaleAdult.getBSA(): " + bsa);
	assertTrue(bsa == 1.92);
	bsa = testDataNormalMaleKid.getBSA();
	System.out.println("testDataNormalMaleKid.getBSA(): " + bsa);
	assertTrue(bsa == 1.53);
	bsa = testDataNormalMaleTeen.getBSA();
	System.out.println("testDataNormalMaleTeen.getBSA(): " + bsa);
	assertTrue(bsa == 1.91);

    }

    /**
     * Tests the functionality of {@code BodyData.getIBW()}
     */
    @Test
    public void testIBW() {

    }

    /**
     * Tests the functionality of {@code BodyData.getNBW()}
     */
    @Test
    public void testNBW() {
	int nbw = testDataNormalFemaleAdult.getNBW();
	System.out.println("testDataNormalFemaleAdult.getNBW(): " + nbw);
	assertTrue(nbw == 70);
    }

}
