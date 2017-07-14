
package bigbox.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import business.bigbox.web.Division;
import business.bigbox.web.Store;
import business.bigbox.web.User;
import db.bigbox.web.DAOFactory;
import divisions.bigbox.web.DivisionDAO;
import stores.bigbox.web.StoreConstants;
import stores.bigbox.web.StoreDAO;
import storesales.bigbox.web.StoreSalesDAO;
import users.bigbox.web.UserDAO;
import util.bigbox.web.Validator;

// TODO: Auto-generated Javadoc
/**
 * Year: 2017.
 * @author Rajiv Giri
 * @version 5.0
 *  
 * <p> This project is the 5.0 version or iteration of BigBox Application version 4.0. This is a Dynamic Web application and consists of servlets, jsp and html pages which creates home page, BigBox application page where user can view list of stores, divisions,users,registration and login page.
 *  This application consists of User, Division, Store and Store Sales classes stored into their respective packages.It implements the DAO Factory Pattern and stores and gets the data from MYSQL Database. It also includes MySQL connector and other Jar files and 
 * SQL Script in bigbox.SQL package.</p>
 *<p>Since this project is a Dynamic web application User can access it online via URL and can register and login with the currently registered user name and password. You can see the home page with Welcome message and my resume and can access BigBox application from 
 *   menu and see the list of stores, divisions, users and many other features.</p>
 *   <p>Below are the pictures of how the web application looks as of today. It might look different in future and more features might be added.</p>
 *   <h2><u>Screen shots of the application</u></h2>
 *   <h3><u><b>Login Page</u></b></h3>
 *   <img src="LoginPage.JPG" alt="Login Page" style="width:100%;height:50%;"/>
 *   <h3><u><b>Registration Page</u></b></h3>
 *   <img src="RegistrationPage.JPG" alt="" style="width:100%;height:50%;"/>
 *   <h3><u><b>Home Page</u></b></h3>
 *   <img src="HomePage.JPG" alt="Application Page" style="width:100%;height:50%;"/>
 *   <h3><u><b>Application Page</u></b></h3>
 *   <img src="ApplicationPage.JPG" alt="" style="width:100%;height:50%;"/>
 *   <h3><u><b>List of all Stores Page</u></b></h3>
 *   <img src="ListofAllStores.JPG" alt="" style="width:100%;height:50%;"/>
 *   
 */


public class BigBoxApp implements StoreConstants {

	
	/** The sc. */
	private static Scanner sc = null;
	
	/** The User DAO. */
	private static UserDAO UserDAO = null;
	
	/** The Store DAO. */
	private static StoreDAO StoreDAO = null;
	
	/** The Division DAO. */
	private static DivisionDAO DivisionDAO = null;
	
	/** The Store sales DAO. */
	private static StoreSalesDAO StoreSalesDAO = null;
	/**
	 * ID HashMaps for both division and store is set to String instead of Integer. 
	 */
	private static HashMap<String, Division> divisionsIDMap = new HashMap<String, Division>();
	
	/** The divisions nbr map. */
	private static HashMap<String, Division> divisionsNbrMap = new HashMap<String, Division>();
	
	/** The stores ID map. */
	private static HashMap<String, Store> storesIDMap = new HashMap<String, Store>();
	
	/** The stores nbr map. */
	private static HashMap<String, Store> storesNbrMap = new HashMap<String, Store>();

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws SQLException the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws SQLException, IOException {
		// Print Welcome Message
		System.out.println("======================================");
		System.out.println("Welcome to Big Box App");
		System.out.println("**************************************");
		
		// set the class variables
		UserDAO = DAOFactory.getUsersDAO();
		StoreDAO = DAOFactory.getStoreDAO();
		DivisionDAO = DAOFactory.getDivisionDAO();
		StoreSalesDAO = DAOFactory.getStoreSalesDAO();
		sc = new Scanner(System.in);
		populateDivisionsMap();
		populateStoresMap();
		

		// perform 1 or more actions
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			// get the input from the user
			displayMenu();
			action = Validator.getString(sc, "Enter a command: ");
			System.out.println();

			if (action.equalsIgnoreCase("list")) {
				displayAllStores();

			} else if (action.equalsIgnoreCase("reg")) {
				registerUser();

			} else if (action.equalsIgnoreCase("login")) {
				loginUser();
			} else if (action.equalsIgnoreCase("yearly")) {
				yearlyStoreSales();

			} else if (action.equalsIgnoreCase("totalSt")) {
				totalStoreSales();

			} else if (action.equalsIgnoreCase("div") || action.equalsIgnoreCase("divison")) {
				String inDiv = Validator.getString(sc, "Enter a Divison Number: ");
				displayStoresWithInDivison(inDiv);
			} else if (action.equalsIgnoreCase("add")) {
				addStore();
			} else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("delete"))
				deleteStore();
			else if (action.equalsIgnoreCase("totalDiv")) {
				String inDiv = Validator.getString(sc, "Enter a Divison Number: ");
				totalDivisionSales(inDiv);

			} else if (action.equalsIgnoreCase("help") || action.equalsIgnoreCase("menu"))
				displayMenu();
			else if (action.equalsIgnoreCase("exit") || action.equalsIgnoreCase("quit"))
				System.out.println("Bye.\n");
			else
				System.out.println("Error! Not a valid command.\n");
		}
	}

	/**
	 * Display menu.
	 */
	public static void displayMenu() {
		System.out.println();
		System.out.println("COMMAND MENU");
		System.out.println("list    - List all Stores");
		System.out.println("reg     - Prompt user for Registration");
		System.out.println("login   - Prompt user for Login");
		System.out.println("yearly  - List yearly Stores Sales");
		System.out.println("totalSt - List all Stores Sales");
		System.out.println("div     - List all stores for a division");
		System.out.println("totalDiv- List total sales for a store");
		System.out.println("add     - Add a Store");
		System.out.println("del     - Delete a Store");
		System.out.println("help    - Show this menu");
		System.out.println("exit    - Exit this application\n");
	}

	/**
	 * Display all stores.
	 */
	private static void displayAllStores() {

		ArrayList<Store> stores = StoreDAO.getStores();

		if (stores == null || stores.isEmpty())
			System.out.println("No stores returned!");
		else {
			// Store s = null;
			System.out.println("Div #\tStore #\tName");
			System.out.println("=====\t=======\t===========================");
			for (Store s : stores) {
				Division d = divisionsIDMap.get(s.getDivisionID());
				System.out.println(d.getDivisionNumber() + "\t" + s.getStoreNumber() + "\t" + s.getName());
			}
		}
	}

	/**
	 * Display stores with in divison.
	 *
	 * @param inDiv the in div
	 */
	private static void displayStoresWithInDivison(String inDiv) {
		ArrayList<Store> stores = StoreDAO.getAllStoresWithInDivison(inDiv);
		System.out.println(
				"Div #\tStore #\tName                        \tAddress                          \tCity        \tState         \tZipCode ");
		System.out.println(
				"=====\t=======\t===========================\t==========================\t==============\t=============\t==========");
		Store s = null;
		@SuppressWarnings("unused")
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stores.size(); i++) {
			s = stores.get(i);
			Division d = divisionsIDMap.get(s.getDivisionID());
			if (d.getDivisionNumber().equals(inDiv)) {
				// Store s = null;
				for (@SuppressWarnings("unused") Store ss : stores) {
					System.out.println(d.getDivisionNumber() + "\t" + s.getStoreNumber() + "\t" + s.getName()
					+ "         \t" + s.getAddress() + "     \t" + s.getCity() + "     \t" + s.getState()
					+ "   \t" + s.getZipCode());
					break;
				}
			}
		}
	}

	/**
	 * Adds the store.
	 */
	public static void addStore() {
		// Get user Entries
		String inDiv = "";
		@SuppressWarnings("unused")
		Store s = null;
		Division d = null;
		while (d == null) {
			inDiv = Validator.getStringNumeric(sc, "Enter a division #:  ", 3);
			d = divisionsNbrMap.get(inDiv);
			if (d == null)
				System.out.println("No div found for nbr:" + inDiv);
		}

		String inStore = Validator.getStringNumeric(sc, "Enter a Store #:  ", 5);
		String inName = Validator.getString(sc, "Enter the Name of the store:  ");
		String inAddress = Validator.getString(sc, "Enter the Address of the store:  ");
		String inCity = Validator.getString(sc, "Enter the City of the store:  ");
		String inState = Validator.getString(sc, "Enter the State of the store:  ");
		String inZipCode = Validator.getString(sc, "Enter the Zip of the store:  ");
		Store store = new Store(inStore, inName, inAddress, inCity, inState, inZipCode);
		d = divisionsNbrMap.get(inDiv);
		store.setDivisionID(d.getID());
		store.setStoreNumber(inStore);
		store.setName(inName);
		store.setAddress(inAddress);
		store.setCity(inCity);
		store.setState(inState);
		store.setZipCode(inZipCode);
		StoreDAO.addStore(store);

		// StoreArray.addStore(store);
		System.out.println();
		System.out.println("The " + inDiv + " Division " + inStore + " Store has been added to the system.\n");
	}

	/**
	 * Delete store.
	 */
	public static void deleteStore() {
		String inDiv = "";
		String inStore = "";
		Division d = null;
		while (d == null) {
			inDiv = Validator.getStringNumeric(sc, "Enter a division #:  ", 3);
			d = divisionsNbrMap.get(inDiv);
			if (d == null)
				System.out.println("No div found for nbr:" + inDiv);
		}
		Store s = StoreDAO.getStore(inDiv, inStore);
		while (s == null) {
			inStore = Validator.getStringNumeric(sc, "Enter a store #:  ", 5);
			s = storesNbrMap.get(inStore);
			if (s == null)
				System.out.println("No Store found for nbr:" + inStore);
		}

		System.out.println();
		if (s != null) {
			d = divisionsNbrMap.get(inDiv);
			s = storesNbrMap.get(inStore);
			System.out.println(d.getDivisionNumber() + " and " + s.getStoreNumber() + " has been deleted.\n");
			StoreDAO.deleteStore(s);
		}
	}

	/**
	 * Total division sales.
	 *
	 * @param inDiv the in div
	 */
	// change to get total division sales instead of get total store sales
	public static void totalDivisionSales(String inDiv) {
		double storeSales = StoreSalesDAO.getAllStoreSalesWithInDivison(inDiv);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.println("Division Sales for div " + inDiv + " = " + currency.format(storeSales));
	}

	/**
	 * Yearly store sales.
	 */
	public static void yearlyStoreSales() {
		String inDiv = "";
		String inStore = "";
		@SuppressWarnings("unused")
		String inStoreSales = "";
		String inYear = "";
		Division d = null;
		String ss = null;
		while (d == null) {
			inDiv = Validator.getStringNumeric(sc, "Enter a division #:  ", 3);
			d = divisionsNbrMap.get(inDiv);
			if (d == null)
				System.out.println("No div found for nbr:" + inDiv);
		}
		Store s = StoreDAO.getStore(inDiv, inStore);
		while (s == null) {
			inStore = Validator.getStringNumeric(sc, "Enter a store #:  ", 5);
			s = storesNbrMap.get(inStore);
			if (s == null)
				System.out.println("No Store found for nbr:" + inStore);
		}
		while (ss == null) {
			inYear = Validator.getStringNumeric(sc, "Enter Year:  ", 4);
			ss = StoreSalesDAO.getStoreSalesYear(inYear);

			if (ss == null)
				System.out.println("No sales found for year:" + inYear);
		}

		double storeSales = StoreSalesDAO.getAllStoreSalesWithInDivisonPerYear(inDiv, inStore, inYear);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.println(
				"Division Sales for div " + inDiv + " and for Year " + inYear + " = " + currency.format(storeSales));

	}

	/**
	 * Total store sales.
	 */
	public static void totalStoreSales() {

		String inStore = "";

		String inDiv = "";
		Division d = null;

		while (d == null) {
			inDiv = Validator.getStringNumeric(sc, "Enter a division #:  ", 3);
			d = divisionsNbrMap.get(inDiv);
			if (d == null)
				System.out.println("No div found for nbr:" + inDiv);
		}
		Store s = StoreDAO.getStore(inDiv, inStore);
		while (s == null) {
			inStore = Validator.getStringNumeric(sc, "Enter a store #:  ", 5);
			s = storesNbrMap.get(inStore);
			if (s == null)
				System.out.println("No Store found for nbr:" + inStore);
		}
		double storeSales = StoreSalesDAO.getAllStoreSales(inDiv, inStore);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.println("Store Sales for div " + inDiv + " Store " + inStore + " = " + currency.format(storeSales));

	}

	// Populate  Division HashMaps from all divisions in the db

	/**
	 * Populate divisions map.
	 */
	private static void populateDivisionsMap() {
		ArrayList<Division> divisions = DivisionDAO.getDivisions();
		for (Division d : divisions) {
			divisionsIDMap.put(d.getID(), d);
			divisionsNbrMap.put(d.getDivisionNumber(), d);

		}
	}


	/**
	 * Populate stores map.
	 */
	// Populate Store HashMaps from all stores in the db
	private static void populateStoresMap() {
		ArrayList<Store> stores = StoreDAO.getStores();
		for (Store s : stores) {
			storesIDMap.put(s.getId(), s);
			storesNbrMap.put(s.getStoreNumber(), s);

		}
	}

	/**
	 * Register user.
	 */
	public static void registerUser() {
		String un = Validator.getString(sc, "Enter your user name: ");
		String pass = Validator.getString(sc, "Enter your password: ");
		String fn = Validator.getString(sc, "Enter your first name: ");
		String ln = Validator.getString(sc, "Enter your last name: ");
		String ph = Validator.getString(sc, "Enter your phone number: ");
		String em = Validator.getString(sc, "Enter your email :   ");
		User u = new User(un, pass, fn, ln, ph, em);
		u.setUserName(un);
		u.setPassword(pass);
		u.setFirstName(fn);
		u.setLastName(ln);
		u.setPhone(ph);
		u.setEmail(em);
		UserDAO.addUser(u);
		System.out.println();
		System.out.println("The user " + un + " has been added to the system.\n");

	}

	/**
	 * Login user.
	 *
	 * @throws SQLException the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void loginUser() throws SQLException, IOException {
		String username = null;
		String password = null;
		System.out.println("Enter your user name: ");
		username = sc.next();
		System.out.println("Enter your password: ");
		password = sc.next();
		boolean users = UserDAO.loginUser(username, password);
		if (users == false) {
			System.out.println("User or password do not match");
		} else {
			users = true;
			System.out.println("Login Successful");

		}

	}

	/**
	 * The Class input.
	 */
	public static class input {
		
		/**
		 * Gets the string.
		 *
		 * @return the string
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static String getString() throws IOException {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}

		/**
		 * Gets the int.
		 *
		 * @return the int
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static int getInt() throws IOException {
			return Integer.parseInt(getString());

		}
	}

	/**
	 * Pad with spaces.
	 *
	 * @param string the string
	 * @param length the length
	 * @return the string
	 */
	public static String padWithSpaces(String string, int length) {
		if (string.length() < length) {
			StringBuilder sb = new StringBuilder(string);
			while (sb.length() < length) {
				sb.append(" ");
			}
			return sb.toString();
		} else {
			return string.substring(0, length);
		}
	}

	/**
	 * Pad with spaces 1.
	 *
	 * @param s the s
	 * @return the string
	 */
	public static String padWithSpaces1(String s) {
		if (s.length() < NAME_SIZE) {
			StringBuilder sb = new StringBuilder(s);
			while (sb.length() < NAME_SIZE) {
				sb.append(" ");
			}
			return sb.toString();
		} else {
			return s.substring(0, NAME_SIZE);
		}
	}
}