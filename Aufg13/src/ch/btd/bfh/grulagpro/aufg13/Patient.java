package ch.btd.bfh.grulagpro.aufg13;

public class Patient implements Person {
    private String name;
    private String preName;

    public Patient(String name, String preName) {
	this.name = name;
	this.preName = preName;
    }

    @Override
    public String getName() {
	return this.name;
    }

    @Override
    public String getPreName() {
	return this.preName;
    }
    
    @Override
    public String toString() {
	return this.preName + " " + this.name;
    }
}
