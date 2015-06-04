import java.util.ArrayList;

import ch.btd.bfh.grulagpro.aufg13.Doctor;
import ch.btd.bfh.grulagpro.aufg13.Patient;
import ch.btd.bfh.grulagpro.aufg13.Person;

public class Main {

    public static void main(String[] args) {

	ArrayList<Person> persons = new ArrayList<Person>();
	
	persons.add(new Doctor("Carstens", "Chris", "Doc. Med")); 
	persons.add(new Patient("Meier", "Johnny"));
	persons.add(new Patient("Müller", "Whaat"));
	
	persons.set(2, new Doctor("lass", "knacken", "alter"));
	persons.add(1, new Doctor("peino", "lotra", "uups"));

	persons.add(new Patient("Vader", "Whaat"));
	persons.add(new Patient("Kill", "Löli"));
	persons.add(new Patient("Alterr", "Gian-Andrea"));
	
	for(Person p : persons) {
	    System.out.println(p);
	    
//	    if(p instanceof Patient) {
//		System.out.println("is a patient!");
//	    }
	}
	
	int[] test = {1,2,3,4};
	
	for(int i : test) {
	    System.out.println(i);
	}
	
	System.out.println(test.length);
    }
}
