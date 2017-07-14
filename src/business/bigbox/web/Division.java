package business.bigbox.web;

// TODO: Auto-generated Javadoc
/**
 * The Class Division.
 */
public class Division extends Facility {
	/*
	 * Please note that id's are assigned as String instead of integer for testing purpose.
	 */
	
	/** The id. */
	private String ID;
	
	/** The Division number. */
	private String DivisionNumber;
	
	/** The Name. */
	private String Name;
	
	/** The Address. */
	public String Address;
	
	/** The City. */
	public String City;
	
	/** The State. */
	public String State;
	
	/** The Zip code. */
	public String ZipCode;

	/**
	 * Instantiates a new division.
	 *
	 * @param iD the i D
	 * @param divisionNumber the division number
	 * @param name the name
	 * @param address the address
	 * @param city the city
	 * @param state the state
	 * @param zipCode the zip code
	 */
	public Division(String iD, String divisionNumber, String name, String address, String city, String state,
			String zipCode) {
		super(iD, name, address, city, state, zipCode);
		ID = iD;
		DivisionNumber = divisionNumber;
		Name = name;
		Address = address;
		City = city;
		State = state;
		ZipCode = zipCode;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Sets the id.
	 *
	 * @param iD the new id
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * Gets the division number.
	 *
	 * @return the division number
	 */
	public String getDivisionNumber() {
		return DivisionNumber;
	}

	/**
	 * Sets the division number.
	 *
	 * @param divisionNumber the new division number
	 */
	public void setDivisionNumber(String divisionNumber) {
		DivisionNumber = divisionNumber;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#getName()
	 */
	public String getName() {
		return Name;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#setName(java.lang.String)
	 */
	public void setName(String name) {
		Name = name;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#getAddress()
	 */
	public String getAddress() {
		return Address;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#setAddress(java.lang.String)
	 */
	public void setAddress(String address) {
		Address = address;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#getCity()
	 */
	public String getCity() {
		return City;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#setCity(java.lang.String)
	 */
	public void setCity(String city) {
		City = city;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#getState()
	 */
	public String getState() {
		return State;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#setState(java.lang.String)
	 */
	public void setState(String state) {
		State = state;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#getZipCode()
	 */
	public String getZipCode() {
		return ZipCode;
	}

	/* (non-Javadoc)
	 * @see bigbox.business.Facility#setZipCode(java.lang.String)
	 */
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}

	
	/* (non-Javadoc)
	 * @see bigbox.business.Facility#print(java.lang.String)
	 */
	public void print(String varName) {
		String printString = " ID:   " + getID() + " Division Number:   " + getDivisionNumber() + "Name :  " + getName()
				+ "Address :  " + getAddress() + "City :  " + getCity() + "State :  " + getState() + "ZipCode  :  "
				+ getZipCode();
		System.out.println(printString);
	}

}
