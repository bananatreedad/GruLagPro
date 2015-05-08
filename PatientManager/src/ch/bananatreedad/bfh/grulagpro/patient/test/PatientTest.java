/**
 * 
 */
package ch.bananatreedad.bfh.grulagpro.patient.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.bananatreedad.bfh.grulagpro.patient.Patient;
import ch.bananatreedad.grulagpro.address.address.Address;

/**
 * @author bananatreedad
 *
 */
public class PatientTest {
    
    private long currentId = -1L;

    @Test
    public void testToString() {
	Address address = new Address("Meier", "Jonathan", "Teststr. 4", 9999, "Examplehausen", Address.Country.SWITZERLAND); 
	Patient patient = new Patient(getNextId(), address.getPrename(), address.getName(), "16.04.1992", 'm', address);
	
	System.out.println(patient);
    }

    private long getNextId() {
	this.currentId++;
	return this.currentId;
    }
}
