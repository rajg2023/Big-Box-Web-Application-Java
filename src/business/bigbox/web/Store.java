package business.bigbox.web;

// TODO: Auto-generated Javadoc
/**
 * The Class Store.
 */
public class Store  extends Facility  {
	/*
	 * Please note that id's are assigned as String instead of integer for testing purpose.
	 */
	/** The id. */
	private String id;
	
	/** The division ID. */
	private String divisionID;
	
	/** The store number. */
	private String storeNumber;
	
	/** The name. */
	private String name;
	
	/** The address. */
	private String address;
	
	/** The city. */
	private String city;
	
	/** The state. */
	private static String state;
	
	/** The zip code. */
	private static String zipCode;

	/**
	 * Instantiates a new store.
	 *
	 * @param id the id
	 * @param divisionID the division ID
	 * @param storeNumber the store number
	 * @param name the name
	 * @param address the address
	 * @param city the city
	 */
	public Store(String id, String divisionID, String storeNumber, String name, String address, String city) {
		super(id, name, address, city, state, zipCode);
		this.id = id;
		this.divisionID = divisionID;
		this.storeNumber = storeNumber;
		this.name = name;
		this.address = address;
		this.city = city;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#getId()
	 */
	public String getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#setId(java.lang.String)
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the division ID.
	 *
	 * @return the division ID
	 */
	public String getDivisionID() {
		return divisionID;
	}

	/**
	 * Sets the division ID.
	 *
	 * @param divisionID the new division ID
	 */
	public void setDivisionID(String divisionID) {
		this.divisionID = divisionID;
	}

	/**
	 * Gets the store number.
	 *
	 * @return the store number
	 */
	public String getStoreNumber() {
		return storeNumber;
	}

	/**
	 * Sets the store number.
	 *
	 * @param storeNumber the new store number
	 */
	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#getAddress()
	 */
	public String getAddress() {
		return address;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#setAddress(java.lang.String)
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#getCity()
	 */
	public String getCity() {
		return city;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#setCity(java.lang.String)
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#getState()
	 */
	public String getState() {
		return state;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#setState(java.lang.String)
	 */
	public void setState(String state) {
		Store.state = state;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#getZipCode()
	 */
	public String getZipCode() {
		return zipCode;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#setZipCode(java.lang.String)
	 */
	public void setZipCode(String zipCode) {
		Store.zipCode = zipCode;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#print(java.lang.String)
	 */
	public void print(String varName) {
		String printString = /* " ID :   "+ getId()+ */" Division ID :   " + getDivisionID() + "Store Number:  "
				+ getName() + "Name :  " + getName() + "Address :  " + getAddress() + "City :  " + getCity()
				+ "State :  " + getState() + "ZipCode  :  " + getZipCode();
		System.out.println(printString);
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#toString()
	 */
	@Override
	public String toString() {
		return "Store [id=" + id + ", divisionID=" + divisionID + ", storeNumber=" + storeNumber + ", name=" + name
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+  "]";
	}

}
