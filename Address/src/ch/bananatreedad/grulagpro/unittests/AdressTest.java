package ch.bananatreedad.grulagpro.unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.bananatreedad.grulagpro.address.Address;
import ch.bananatreedad.grulagpro.address.Address.Country;

public class AdressTest {

	@Test
	public void testAdress() {

		Address ad1 = new Address("Meier", "Johnny", "That street there 1337",
				9000, "Coolest City Evar", Address.Country.SWITZERLAND);

		System.out.println("Initiated following Address:");
		System.out.println(ad1.toString());

		// String tests
		assertTrue(ad1.getCity() == "Coolest City Evar");
		assertTrue(ad1.getCountry() == Country.SWITZERLAND);
		assertTrue(ad1.getName() == "Meier");
		assertTrue(ad1.getPrename() == "Johnny");
		assertTrue(ad1.getPostalCode() == 9000);
		assertTrue(ad1.getStreet() == "That street there 1337");

		assertTrue(ad1
				.toString()
				.equals("Johnny Meier, That street there 1337, 9000 Coolest City Evar, SWITZERLAND"));

		// clone tests
		ad1.setOldAddress(ad1);

		System.out.println(ad1.hashCode());
		System.out.println(ad1);
		System.out.println(ad1.getOldAddress().hashCode());
		System.out.println(ad1.getOldAddress());

		assertTrue(ad1 != ad1.getOldAddress());
		assertTrue(ad1.getClass() == ad1.getOldAddress().getClass());

		ad1.setCity("new city");
		ad1.setStreet("new street");
		ad1.setPostalCode(9999);

	}

}
