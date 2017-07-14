package business.bigbox.web;


// TODO: Auto-generated Javadoc
/**
 * The Class StoreSales.
 */
public class StoreSales {
	
	/*
	 * Please note that id's are assigned as String instead of integer for testing purpose.
	 */
	/** The id. */
	private String id;
	
	/** The store ID. */
	private String storeID;
	
	/** The year. */
	private String year;
	
	/** The week. */
	private String week;
	
	/** The sales. */
	private String sales;

	/**
	 * Instantiates a new store sales.
	 *
	 * @param id the id
	 * @param storeID the store ID
	 * @param year the year
	 * @param week the week
	 * @param sales the sales
	 */
	public StoreSales(String id, String storeID, String year, String week, String sales) {
		super();
		this.id = id;
		this.storeID = storeID;
		this.year = year;
		this.week = week;
		this.sales = sales;
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
	 * Gets the store ID.
	 *
	 * @return the store ID
	 */
	public String getStoreID() {
		return storeID;
	}

	/**
	 * Sets the store ID.
	 *
	 * @param storeID the new store ID
	 */
	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * Gets the week.
	 *
	 * @return the week
	 */
	public String getWeek() {
		return week;
	}

	/**
	 * Sets the week.
	 *
	 * @param week the new week
	 */
	public void setWeek(String week) {
		this.week = week;
	}

	/**
	 * Gets the sales.
	 *
	 * @return the sales
	 */
	public String getSales() {
		return sales;
	}

	/**
	 * Sets the sales.
	 *
	 * @param sales the new sales
	 */
	public void setSales(String sales) {
		this.sales = sales;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StoreSales [id=" + id + ", storeID=" + storeID + ", year=" + year + ", week=" + week + ", sales="
				+ sales + "]";
	}

}
