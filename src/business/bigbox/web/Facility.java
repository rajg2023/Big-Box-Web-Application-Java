package business.bigbox.web;

// TODO: Auto-generated Javadoc
/**
 * The Class Facility.
 */
public class Facility {
	/*
	 * Please note that id's are assigned as String instead of integer for testing purpose.
	 */

	/** The id. */
	protected String id;
	
	/** The name. */
	protected String name;
	
	/** The address. */
	protected String address;
	
	/** The city. */
	protected String city;
	
	/** The state. */
	protected String state;
	
	/** The zip code. */
	protected String zipCode;

	/**
	 * Instantiates a new facility.
	 *
	 * @param id the id
	 * @param name the name
	 * @param address the address
	 * @param city the city
	 * @param state the state
	 * @param zipCode the zip code
	 */
	public Facility(String id, String name, String address, String city, String state, String zipCode) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the zip code.
	 *
	 * @return the zip code
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the zip code.
	 *
	 * @param zipCode the new zip code
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Prints the.
	 *
	 * @param varName the var name
	 */
	public void print(String varName) {
		String printString = "Facilty:  " + "id: " + getId() + "name: " + getName() + "address: " + getAddress()
		+ "city: " + getCity() + "state: " + getState() + "zip: " + getZipCode();
		System.out.println(printString);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Facility [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + "]";
	}

}
