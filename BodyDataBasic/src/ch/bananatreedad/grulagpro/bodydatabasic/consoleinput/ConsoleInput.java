package ch.bananatreedad.grulagpro.bodydatabasic.consoleinput;

import java.util.Scanner;

import ch.bananatreedad.grulagpro.bodydatabasic.BodyData;
import ch.bananatreedad.grulagpro.bodydatabasic.BodyData.Gender;

public class ConsoleInput {

    public static void main(String[] args) {

	Scanner in = new Scanner(System.in);

	System.out.println("Hi! Enter your health data:");
	System.out.print("Size (cm): ");
	double gotTheSize = in.nextDouble();
	System.out.print("Weight (kg): ");
	double gotTheWeight = in.nextDouble();
	System.out.print("Gender (m or f): ");
	String gotTheGender = in.next();
	Gender gender = Gender.parseGender(gotTheGender);
	System.out.print("Age: ");
	int gotTheAge = in.nextInt();

	in.close();

	BodyData data = new BodyData(gotTheSize, gotTheWeight, gender,
		gotTheAge);

	System.out.printf("\nBMI:%10.1f", data.getBMI());
	System.out.printf("\nBSA:%10.1f m2", data.getBSA());

	try {
	    System.out.printf("\nIBW:%10d kg", data.getIBW());
	} catch (Exception e) {
	    System.out.printf("\nIBW is not computable - size conforms not to the standard value.");
	}

	System.out.printf("\nNBW:%10d kg", data.getNBW());
    }
}
