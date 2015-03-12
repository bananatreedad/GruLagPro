/**
 * Main class to test {@link Counter}.
 * 
 * @author bananatreedad
 */
public class Main {

	public static void main(String[] args) {
		//initiate counter1
		Counter counter1 = new Counter();
		System.out.println("Initiated counter1.");

		// click 4 times on counter1
		System.out.println("Click 4 times on counter1.");
		counter1.click();
		counter1.click();
		counter1.click();
		counter1.click();

		//print value of counter1
		System.out.println("Value of counter1: " + counter1.getValue());

	}

}
