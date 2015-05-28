package ch.bananatreedad.grulagpro.inht;

public class Main {

	public static void main(String[] args) {
		Person joni = new Person("Jonathan", "Meier");
		Doctor doc = new Doctor("Hardy", "Cox", "Doc.", "666 666 666");
		Patient pat = new Patient("Walt", "Mitty", 77, null);
		
		System.out.println(joni);
		System.out.println(doc);
		System.out.println(pat);
	}

}
