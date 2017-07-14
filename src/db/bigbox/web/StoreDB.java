package db.bigbox.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.bigbox.web.Division;
import business.bigbox.web.Store;
import stores.bigbox.web.StoreDAO;
import util.bigbox.web.DBUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreDB.
 */
public class StoreDB implements StoreDAO {

	/* (non-Javadoc)
	 * @see bigbox.stores.StoreReader#getStores()
	 */
	public ArrayList<Store> getStores() {
		String sql = " SELECT * FROM stores ";
		ArrayList<Store> stores = new ArrayList<>();
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Store s = getStoreFromRow(rs);
				stores.add(s);
			}
			return stores;
		} catch (SQLException e) {
			System.err.println("Something is not right" + e);
		}
		return stores;
	}

	/* (non-Javadoc)
	 * @see bigbox.stores.StoreReader#getAllStoresWithInDivison(java.lang.String)
	 */
	public ArrayList<Store> getAllStoresWithInDivison(String inDiv) {
		String sql = " SELECT * FROM stores s " 
	               + " JOIN divisions d " 
				   + " ON d.ID = s.DivisionID ";
		ArrayList<Store> stores = new ArrayList<>();
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Store s = getStoreFromRow(rs);
				stores.add(s);
			}
			return stores;
		} catch (SQLException e) {
			System.err.println("Something is not right" + e);
		}
		return stores;
	}

	/**
	 * Gets the store from row.
	 *
	 * @param rs the rs
	 * @return the store from row
	 * @throws SQLException the SQL exception
	 */
	public static Store getStoreFromRow(ResultSet rs) throws SQLException {
		Store s = null;
		try{
			String id = rs.getString(1);
			String divisionID = rs.getString(2);
			String storeNumber = rs.getString(3);
			String name = rs.getString(4);
			String address = rs.getString(5);
			String city = rs.getString(6);
			String state = rs.getString(7);
			String zipcode = rs.getString(8);   

			s = new Store(storeNumber, name, address, city, state, zipcode);
			s.setId(id);
			s.setDivisionID(divisionID);
			s.setStoreNumber(storeNumber);
			s.setName(name);
			s.setAddress(address);
			s.setCity(city);
			s.setState(state);
			s.setZipCode(zipcode);
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return s;
	}

	/* (non-Javadoc)
	 * @see bigbox.stores.StoreReader#getStore(java.lang.String, java.lang.String)
	 */
	public Store getStore(String inDiv, String inStore) {
		String sql = "SELECT * FROM stores";
		@SuppressWarnings("unused")
		ArrayList<Store> stores = new ArrayList<>();
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				getStoreFromRow(rs);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see bigbox.stores.StoreWriter#addStore(bigbox.business.Store)
	 */
	public boolean addStore(Store s) {
		
		@SuppressWarnings("unused")
		Division d = null;
		String sql = "INSERT INTO stores (divisionID,StoreNumber,Name,Address,City,State,ZipCode) "
				   + " VALUES (?,?, ?, ?, ?, ?, ?)";
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			// set a string for the division id
			ps.setString(1, s.getDivisionID());
			ps.setString(2, s.getStoreNumber());
			ps.setString(3, s.getName());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getCity());
			ps.setString(6, s.getState());
			ps.setString(7, s.getZipCode());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return false;
	}

	/*public boolean updateStore(Store s) {
		String sql = "UPDATE Store SET " 
		           + "DivisonID = ?, " 
				   + "StoreNumber = ?, " 
		           + "Name = ?, " 
				   + "Address = ?, "
				   + "City = ? "
				   + "State = ?, " 
				   + "ZipCode = ?" 
				   + "WHERE DivisionID = ?";
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, s.getDivisionID());
			ps.setString(2, s.getStoreNumber());
			ps.setString(3, s.getName());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getCity());
			ps.setString(6, s.getState());
			ps.setString(7, s.getZipCode());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return false;
	}*/

	/* (non-Javadoc)
	 * @see bigbox.stores.StoreWriter#deleteStore(bigbox.business.Store)
	 */
	public boolean deleteStore(Store s) {
		String sql = " DELETE FROM Stores " 
	               + " WHERE DivisionID = ? " 
				   + " AND StoreNumber = ? ";
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, s.getDivisionID());
			ps.setString(2, s.getStoreNumber());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return false;
	}

}
