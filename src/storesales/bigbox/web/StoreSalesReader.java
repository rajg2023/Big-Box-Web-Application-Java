package storesales.bigbox.web;

import java.util.ArrayList;

import business.bigbox.web.Store;
import business.bigbox.web.StoreSales;

// TODO: Auto-generated Javadoc
/**
 * The Interface StoreSalesReader.
 */
public interface StoreSalesReader {

	/**
	 * Gets the store sales.
	 *
	 * @return the store sales
	 */
	public ArrayList<StoreSales> getStoreSales();

	/**
	 * Gets the store sales.
	 *
	 * @param inStore the in store
	 * @return the store sales
	 */
	public double getStoreSales(Store inStore);

	/**
	 * Gets the all store sales.
	 *
	 * @param inDiv the in div
	 * @param inStore the in store
	 * @return the all store sales
	 */
	double getAllStoreSales(String inDiv, String inStore);

	/**
	 * Gets the all store sales with in divison per year.
	 *
	 * @param inDiv the in div
	 * @param inStore the in store
	 * @param inYear the in year
	 * @return the all store sales with in divison per year
	 */
	double getAllStoreSalesWithInDivisonPerYear(String inDiv, String inStore, String inYear);

	/**
	 * Gets the store sales year.
	 *
	 * @param inYear the in year
	 * @return the store sales year
	 */
	public String getStoreSalesYear(String inYear);
	
	/**
	 * Gets the all store sales with in divison.
	 *
	 * @param inDiv the in div
	 * @return the all store sales with in divison
	 */
	double getAllStoreSalesWithInDivison(String inDiv);

}
