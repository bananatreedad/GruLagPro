package ch.btd.bfh.grulagpro.aufg13;

public class Doctor implements Person {

    private String name;
    private String preName;
    private String title;
    
    public Doctor(String name, String preName, String title) {
	this.name = name;
	this.preName = preName;
	this.title = title;
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
	return this.title + " " + this.preName + " " + this.name; 
    }
}
