package db.bigbox.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.bigbox.web.User;
import users.bigbox.web.UserDAO;
import util.bigbox.web.DBUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDB.
 */
public class UserDB implements UserDAO {

	/* (non-Javadoc)
	 * @see bigbox.users.UserReader#getUsers()
	 */
	public ArrayList<User> getUsers() {
		String sql = " SELECT * FROM users ";
		ArrayList<User> users = new ArrayList<>();
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				User u = getUserFromRow(rs);
				users.add(u);
			}
			return users;
		} catch (SQLException e) {
			System.err.println("Something is not right" + e);
		}
		return users;
	}

	/**
	 * Gets the user from row.
	 *
	 * @param rs the rs
	 * @return the user from row
	 * @throws SQLException the SQL exception
	 */
	public static User getUserFromRow(ResultSet rs) throws SQLException {
		User u = null;
		try {
			@SuppressWarnings("unused")
			int id = rs.getInt(1);
			String username = rs.getString(2);
			String password = rs.getString(3);
			String firstname = rs.getString(4);
			String lastname = rs.getString(5);
			String phone = rs.getString(6);
			String email = rs.getString(7);

			// int id = 0;
			u = new User();
			u.setUserName(username);
			u.setPassword(password);
			u.setFirstName(firstname);
			u.setLastName(lastname);
			u.setPhone(phone);
			u.setEmail(email);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return u;
	}

	/* (non-Javadoc)
	 * @see bigbox.users.UserWriter#addUser(bigbox.business.User)
	 */
	public boolean addUser(User u) {
		String sql = "INSERT INTO users (userName,password,firstName,lastName,phone,email) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getPhone());
			ps.setString(6, u.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see bigbox.users.UserReader#loginUser(java.lang.String, java.lang.String)
	 */
	public boolean loginUser(String username, String password) {
		@SuppressWarnings("unused")
		String UserName = null;
		@SuppressWarnings("unused")
		String Password = null;
		boolean status = false;
		@SuppressWarnings("unused")
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM users " 
		           + " WHERE username = ?" 
				   + " AND password = ? ";
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, username);
			ps.setString(2, password);

			rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}
