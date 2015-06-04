package ch.btd.bfh.grulagpro.aufg13;

/**
 * @author bananatreedad
 *
 */
public class Person {

    private String name;
    private String preName;
    
    public Person(String name, String preName) {
	this.name = name;
	this.preName = preName;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the preName
     */
    public String getPreName() {
        return preName;
    }
    
}
