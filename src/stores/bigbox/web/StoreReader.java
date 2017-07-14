package stores.bigbox.web;

import java.util.ArrayList;

import business.bigbox.web.Store;


// TODO: Auto-generated Javadoc
/**
 * The Interface StoreReader.
 */
public interface StoreReader {

	/**
	 * Gets the store.
	 *
	 * @param inDiv the in div
	 * @param inStore the in store
	 * @return the store
	 */
	public Store getStore(String inDiv, String inStore);

	/**
	 * Gets the all stores with in divison.
	 *
	 * @param inDiv the in div
	 * @return the all stores with in divison
	 */
	public ArrayList<Store> getAllStoresWithInDivison(String inDiv);

	/**
	 * Gets the stores.
	 *
	 * @return the stores
	 */
	public ArrayList<Store> getStores();

}
