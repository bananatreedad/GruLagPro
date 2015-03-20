package ch.bananatreedad.grulagpro.bodydatabasic.consoleinput;

import java.util.Scanner;

import ch.banananatreedad.grulagpro.bodydatabasic.BodyDataBasic;
import ch.banananatreedad.grulagpro.bodydatabasic.BodyDataBasic.Gender;

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

		BodyDataBasic data = new BodyDataBasic(gotTheSize, gotTheWeight);

		System.out.printf("\nBMI:%10.1f", data.getBMI());
		System.out.printf("\nBSA:%10.1f", data.getBSAofAnyPerson(gotTheAge));
		System.out.printf("\nIBW:%10d", data.getIBWperson(gender));
		System.out.printf("\nNBW:%10d", data.getNBW());

	}

}
