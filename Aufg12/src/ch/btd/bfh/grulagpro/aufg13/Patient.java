/**
 * 
 */
package ch.btd.bfh.grulagpro.aufg13;

/**
 * @author bananatreedad
 *
 */
public class Patient extends Person {

    private String ahv;

    public Patient(String name, String preName, String ahv) {
	super(name, preName);
	this.ahv = ahv;
    }

    public String getAHV() {
	return this.ahv;
    }
}
