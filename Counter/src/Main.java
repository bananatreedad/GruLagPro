import java.util.ArrayList;
import java.util.List;

/**
 * Main class to test {@link Counter}.
 * 
 * @author bananatreedad
 */
public class Main {

	public static void main(String[] args) {
		// initiate counter1
		Counter counter1 = new Counter();
		System.out.println("Initiated counter1.");

		// initiate counter1
		Counter counter2 = new Counter();
		System.out.println("Initiated counter1.");

		// initiate counter2
		Counter counter3 = new Counter();
		System.out.println("Initiated counter1.");

		// initiate counter3
		Counter counter4 = new Counter();
		System.out.println("Initiated counter1.");

		// initiate counter4
		Counter counter5 = new Counter();
		System.out.println("Initiated counter1.");

		// initiate counter5
		Counter counter6 = new Counter();
		System.out.println("Initiated counter1.");

		// click 4 times on counter1
		System.out.println("Click 4 times on counter1.");
		counter1.click();
		counter1.click();
		counter1.click();
		counter1.click();

		// print value of counter1
		System.out.println("Value of counter1: " + counter1.getValue());

		// create a list of counters
		List<Counter> counterList = new ArrayList<Counter>();
		counterList.add(counter1);
		counterList.add(counter2);
		counterList.add(counter3);
		counterList.add(counter4);
		counterList.add(counter5);
		counterList.add(counter6);
		
		System.out.println(counterList);
	
		// float test
		float a = (float) 0.2;
		float b = (float) 0.1;

		if (a + b == 0.3) {
			System.out.println("  gleich!");
		} else {
			System.out.printf("a: %.15f", a);
			System.out.printf("\nb: %.15f", b);
			System.out.println("\nungleich!");
		}

	}

}
