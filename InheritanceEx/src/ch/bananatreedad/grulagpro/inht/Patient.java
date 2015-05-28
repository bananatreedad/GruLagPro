package ch.bananatreedad.grulagpro.inht;

import ch.bananatreedad.grulagpro.address.address.Address;

public class Patient extends Person {
	
	long pin;
	Address address;

	public Patient(String firstName, String name, long pin, Address address) {
		super(firstName, name);
		
		this.pin = pin;
		this.address = address;
	}
	
	public long getPin() {
		return this.pin;
	}
	
	public Address getAddress() {
		return this.address;
	}
}
