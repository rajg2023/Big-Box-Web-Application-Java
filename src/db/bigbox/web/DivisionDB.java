package db.bigbox.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.bigbox.web.Division;
import divisions.bigbox.web.DivisionDAO;
import util.bigbox.web.DBUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class DivisionDB.
 */
public class DivisionDB implements DivisionDAO {

	/* (non-Javadoc)
	 * @see bigbox.divisions.DivisionReader#getDivisions()
	 */
	public ArrayList<Division> getDivisions() {
		String sql = " SELECT * FROM  divisions ";
		ArrayList<Division> divisions = new ArrayList<>();
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Division d = getProductFromRow(rs);
				divisions.add(d);

			}
			return divisions;
		} catch (SQLException e) {
			System.err.println("Something is not right" + e);
		}
		return divisions;
	}
	
	/**
	 * Gets the product from row.
	 *
	 * @param rs the rs
	 * @return the product from row
	 * @throws SQLException the SQL exception
	 */
	public static Division getProductFromRow(ResultSet rs) throws SQLException {
		Division d = null;
		try{
			String id = rs.getString(1);
			String divisionNumber = rs.getString(2);
			String name = rs.getString(3);
			String address = rs.getString(4);
			String city = rs.getString(5);
			String state = rs.getString(6);
			String zipcode = rs.getString(7);   

			d = new Division(id, divisionNumber, name, address, city, state, zipcode);
			d.setID(id);
			d.setDivisionNumber(divisionNumber);
			d.setName(name);
			d.setAddress(address);
			d.setCity(city);
			d.setState(state);
			d.setZipCode(zipcode);
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return d;
	}

	/**
	 * Adds the division.
	 *
	 * @param d the d
	 * @return true, if successful
	 */
	public boolean addDivision(Division d) {
		String sql = "INSERT INTO divisions (ID,DivisionNumber,Name,Address,City,State,ZipCode) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?) ";
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, d.getDivisionNumber());
			ps.setString(2, d.getName());
			ps.setString(3, d.getAddress());
			ps.setString(4, d.getCity());
			ps.setString(5, d.getState());
			ps.setString(6, d.getZipCode());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return false;
	}

	/**
	 * Delete divison.
	 *
	 * @param d the d
	 * @return true, if successful
	 */
	public boolean deleteDivison(Division d) {
		String sql = "DELETE FROM divisions "
	                 + " WHERE ID = ? ";
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return false;
	}
}
