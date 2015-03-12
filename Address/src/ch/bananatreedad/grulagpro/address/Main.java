package ch.bananatreedad.grulagpro.address;

/**
 * The main function which starts this program.
 * 
 * @author jnt
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {

		Address ad1 = new Address("Johnny", "Meier",
				"That street there 1337", 9000, "Coolest city evar",
				Address.Country.SWITZERLAND);

		System.out.println(ad1);

	}

}
