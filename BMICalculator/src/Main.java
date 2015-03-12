import java.io.Console;
import java.io.IOException;
import java.text.DecimalFormat;


public class Main {

	public static void main(String[] args) throws IOException {
		double result = 0;
		
		Runtime.getRuntime().exec("clear");
		
		System.out.println("------------------------------");
		System.out.println("--------WELCOME TO THE--------");
		System.out.println("--------BMI-CALCULATOR--------");
		System.out.println("-----------BITCHEES-----------");
		System.out.println("------------------------------");
		
		System.out.println();
		System.out.println();
		System.out.print("Enter your weight: ");
		String weight = System.console().readLine();
		double weight_i = Double.parseDouble(weight);
		
		System.out.print("Enter your height: ");
		String height = System.console().readLine();
		double height_i = Double.parseDouble(height);
		
		System.out.println("Calculating...");
		result = weight_i / (height_i * height_i);
		
		DecimalFormat d = new DecimalFormat("#.##");
		
		System.out.println(String.format("%.2f", 1.0/3));
		System.out.println(d.format(result));
		
	}
	
	public String getWeightDescString(double bmi) {
		String result = "";

		
		
		
		return result;
	}

}
