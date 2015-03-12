package ch.bananatreedad.grulagpro.address;

/**
 * An <code>Address</code> encapsulates all data which an Address holds.
 * 
 * @author seed@bananatreedad.ch
 * @version 1.0
 */
public class Address {

	private String name;
	private String prename;
	private String street;
	private int postalCode;
	private String city;
	private Country country;

	/**
	 * All allowed countries.
	 * 
	 */
	public enum Country {
		SWITZERLAND, GERMANY, AUSTRIA
	}

	/**
	 * 
	 * @param name
	 *            the name of the address
	 * @param prename
	 *            the prename of the address
	 * @param street
	 *            the street where the address
	 * @param postalCode
	 *            the postal code of the address
	 * @param city
	 *            the city of the address
	 * @param country
	 *            the country of the address
	 */
	public Address(String name, String prename, String street, int postalCode,
			String city, Country country) {
		super();
		this.name = name;
		this.prename = prename;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the prename
	 */
	public String getPrename() {
		return prename;
	}

	/**
	 * @param prename
	 *            the prename to set
	 */
	public void setPrename(String prename) {
		this.prename = prename;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the postalCode
	 */
	public int getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 * 
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * String repesentation of this address in the following format: <br>
	 * PRENAME NAME, STREET, POSTALCODE CITY, COUNTRY<br>
	 * <br>
	 * 
	 * Example:<br>
	 * Johnny Meier, That street there 1337, 9000 Coolest City Evar, Switzerland
	 * 
	 */
	@Override
	public String toString() {

		return this.prename + " " + this.name + ", " + this.street + ", "
				+ this.postalCode + " " + this.city + ", " + this.country;
	}

}
