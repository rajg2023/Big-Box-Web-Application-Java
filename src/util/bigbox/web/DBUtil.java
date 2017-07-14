package util.bigbox.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class DBUtil.
 */
public class DBUtil {
	
	/** The connection. */
	private static Connection connection;

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public static synchronized Connection getConnection() {
		if (connection != null) {
			return connection;
		} else {
			try {
				/*// set the mysql db url, username, and password
				String url = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/heroku_16321952b3b6233";
				String username = "b2c97f0ad39bc8";
				String password = "f6efb39d";*/
				/*Class.forName("com.mysql.jdbc.Driver");*/
				// set the postgres db url, username, and password
				String url = "jdbc:postgresql://ec2-107-21-109-15.compute-1.amazonaws.com:5432/d27bouqkiqmpvo?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
				String username = "xilcnxysskonte";
				String password = "6628c6fd6068b12f9a251b57aa05a9e0e50268e270b044d75052d57771d55881";
				 Class.forName("org.postgresql.Driver");
				// get and return connection
				connection = DriverManager.getConnection(url, username, password);
				// return connection;
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println("Error with connection" + e);
			}
		}
		return connection;

	}

	/**
	 * Close connection.
	 */
	public static synchronized void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println(e);
				;
			} finally {
				connection = null;
			}
		}
	}

	/**
	 * Fix DB string.
	 *
	 * @param s the s
	 * @return the string
	 */
	// handle strings that contain one or more single quotes (')
	public static String fixDBString(String s) {
		// if the string is null, return it
		if (s == null)
			return s;

		// add a single quote immediately before it
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			if (ch == 39) // 39 is the ASCII code for a single quote
				sb.insert(i++, "'");
		}
		return sb.toString();
	}
}