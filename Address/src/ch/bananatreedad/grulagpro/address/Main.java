package ch.bananatreedad.grulagpro.address;

import java.util.ArrayList;
import java.util.List;

import ch.bananatreedad.grulagpro.address.Address.Country;

/**
 * The main function which starts this program.
 * 
 * @author jnt
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {

		Address ad1 = new Address("Meier", "Johnny", "That street there 1337",
				9000, "Coolest city evar", Address.Country.SWITZERLAND);

		Address ad2 = new Address("Beam", "Jim", "Whiskey Lane 30",
				8888, "Lol City", Address.Country.GERMANY);
		
		Address ad3 = new Address("Shurl", "Trol", "Smokey Alley 99",
				7777, "Banana City", Address.Country.AUSTRIA);

		Address ad4 = new Address("Plokt", "Timmy", "Lobster Gate 7",
				6655, "Omnomnom County", Address.Country.SWITZERLAND);

		
		ad1.setOldAddress(ad1);
		ad1.setCity("new city");
		ad1.setStreet("new street 88");
		ad1.setCountry(Country.AUSTRIA);
		
		System.out.println("New Address:");
		System.out.println(ad1);
		System.out.println("Old Address:");
		System.out.println(ad1.getOldAddress());
		
		
		List<Address> addressList = new ArrayList<Address>();
		addressList.add(ad1);
		addressList.add(ad2);
		addressList.add(ad3);
		addressList.add(ad4);
		
		//addressList.addAll(c)

	}

}
