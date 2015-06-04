import java.util.ArrayList;

import ch.btd.bfh.grulagpro.aufg13.Doctor;
import ch.btd.bfh.grulagpro.aufg13.Patient;
import ch.btd.bfh.grulagpro.aufg13.Person;

public class Main {

    public static void main(String[] args) {

	ArrayList<Person> persons = new ArrayList<Person>();
	
	persons.add(new Doctor("Carstens", "Chris", "Doc. Med")); 
	persons.add(new Patient("Meier", "Johnny"));
	persons.add(new Patient("Degen", "Gian-Andrea"));
	
	for(Person p : persons) {
	    System.out.println(p);
	    
	    if(p instanceof Patient) {
		System.out.println("is a patient!");
	    }
	}
    }
}
