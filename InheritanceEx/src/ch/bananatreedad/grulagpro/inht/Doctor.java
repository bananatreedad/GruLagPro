package ch.bananatreedad.grulagpro.inht;

public class Doctor extends Person {

	String title;
	String phone;

	public Doctor(String firstName, String name, String title, String phone) {
		super(firstName, name);
		this.title = title;
		this.phone = phone;
	}
	
	String getTitle() {
		return this.title;
	}

	String getPhone() {
		return this.phone;
	}
}
