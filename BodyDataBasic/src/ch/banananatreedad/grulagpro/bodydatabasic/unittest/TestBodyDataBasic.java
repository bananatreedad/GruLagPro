package ch.banananatreedad.grulagpro.bodydatabasic.unittest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import ch.banananatreedad.grulagpro.bodydatabasic.BodyDataBasic;
import ch.banananatreedad.grulagpro.bodydatabasic.BodyDataBasic.Gender;

public class TestBodyDataBasic {

	/**
	 * This function tests a interesting case: <br>
	 * If you change a public static variable on an instance, you change this
	 * variable on ALL other instances too.
	 */
	@Test
	public void testChangePublicStaticVar() {

		BodyDataBasic johnny = new BodyDataBasic(183, 71);
		assertTrue(johnny.test == "wazzap");
		johnny.test = "otherValue";

		BodyDataBasic ludo = new BodyDataBasic(183, 71);
		assertTrue(ludo.test == "otherValue");
		assertTrue(johnny.test == "otherValue");
	}
	
	@Test
	public void testBMI() {
		BodyDataBasic testData = new BodyDataBasic(183, 71);
		System.out.println("BMI of a person with size 183cm and weight 71kg: " + testData.getBMI());
	}
	
	@Test
	public void testBSA() {
		BodyDataBasic testAdult = new BodyDataBasic(182,  71);
		double bsaAdult = testAdult.getBSAadults();
		
		System.out.println("BSA of an adult with size 182cm and weight 71kg: " + bsaAdult + "m2");
		assertTrue(bsaAdult == 1.91);
		
		
		BodyDataBasic testKid = new BodyDataBasic(130, 35);
		double bsaKid = testKid.getBSAchildren();
		System.out.println("BSA of an kid with size 130cm and weight 39kg: " + bsaKid + "m2");
		assertTrue(bsaKid == 1.12);
		
		BodyDataBasic testYoungAdult = new BodyDataBasic(170, 60);
		double bsaYoungAdult = testYoungAdult.getBSAyoungAdults();
		System.out.println("BSA of a young adult with size 170cm and weight 60kg: " + bsaYoungAdult + "m2");
		assertTrue(bsaYoungAdult == 1.69);
		
	}
	
	@Test
	public void testIBW() {
		BodyDataBasic testNormalWoman = new BodyDataBasic(165, 60);
		int ibw = testNormalWoman.getIBWperson(Gender.FEMALE);
		System.out.println("IBW of a woman with the size 165cm: " + ibw);
		assertTrue(ibw == 59);
		
		BodyDataBasic testNormalMan = new BodyDataBasic(175, 70);
		ibw = testNormalMan.getIBWperson(Gender.MALE);
		System.out.println("IBW of a man with the size 175cm: " + ibw);
		assertTrue(ibw == 60);
	}
}
