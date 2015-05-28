package ch.bananatreedad.grulagpro.inht;

public class Person {

	String firstName;
	String name;
	
	public Person(String firstName, String name) {
		this.firstName = firstName;
		this.name = name;
	}

	public String getFirstName() {
		return this.firstName;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.firstName + " " + this.name;
	}
}
