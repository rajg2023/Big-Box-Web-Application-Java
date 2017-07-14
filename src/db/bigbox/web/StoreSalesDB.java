package db.bigbox.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.bigbox.web.Store;
import business.bigbox.web.StoreSales;
import storesales.bigbox.web.StoreSalesDAO;
import util.bigbox.web.DBUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreSalesDB.
 */
public class StoreSalesDB implements StoreSalesDAO {

	/* (non-Javadoc)
	 * @see bigbox.store_sales.StoreSalesReader#getStoreSales()
	 */
	public ArrayList<StoreSales> getStoreSales() {
		String sql = " SELECT * FROM store_sales ";
		ArrayList<StoreSales> storeSales = new ArrayList<>();
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				StoreSales ss = getStoreSalesFromRow(rs);
				storeSales.add(ss);

			}
			return storeSales;
		} catch (SQLException e) {
			System.err.println("Something is not right" + e);
		}
		return storeSales;
	}

	/* (non-Javadoc)
	 * @see bigbox.store_sales.StoreSalesReader#getStoreSalesYear(java.lang.String)
	 */
	public String getStoreSalesYear(String inYear) {
		String sql = " SELECT year FROM store_sales "
	               + " WHERE StoreID = ? ";
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, inYear);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				inYear = rs.getString(1);

			}
			return inYear;
		} catch (SQLException e) {
			System.err.println("Something is not right" + e);
		}
		return inYear;
	}

	/* (non-Javadoc)
	 * @see bigbox.store_sales.StoreSalesReader#getStoreSales(bigbox.business.Store)
	 */
	//
	public double getStoreSales(Store inStore) {
		double sales = 0;
		String sql = "SELECT SUM(sales) from store_sales " 
		           + " WHERE StoreID = " + inStore.getId();
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				sales = rs.getDouble(1);
		} catch (SQLException sqle) {
			System.err.println("Error getting store sales for storeID: " + inStore.getId());
			sqle.printStackTrace();
		}
		return sales;
	}

	/* (non-Javadoc)
	 * @see bigbox.store_sales.StoreSalesReader#getAllStoreSalesWithInDivison(java.lang.String)
	 */
	public double getAllStoreSalesWithInDivison(String inDiv) {
		double totalDivisionSales = 0;
		String sql = "SELECT DivisionNumber, sum(sales) as TOTAL "
		           + " FROM stores s, store_sales ss, divisions d "
				   + " WHERE s.ID = ss.StoreID " 
		           + " AND d.ID = s.DivisionID " 
				   + " AND DivisionNumber = ? "
				   + " GROUP BY DivisionNumber ";
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, inDiv);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				totalDivisionSales = rs.getDouble(2);
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return totalDivisionSales;
	}

	/* (non-Javadoc)
	 * @see bigbox.store_sales.StoreSalesReader#getAllStoreSales(java.lang.String, java.lang.String)
	 */
	public double getAllStoreSales(String inDiv, String inStore) {
		double totalDivisionSales = 0;
		String sql = "SELECT DivisionNumber, StoreNumber, sum(sales) as TOTAL "
				   + " FROM stores s, store_sales ss, divisions d " + " WHERE s.ID = ss.StoreID "
			       + " AND d.ID = s.DivisionID "  
				   + " AND DivisionNumber = ?" 
			       + " AND StoreNumber = ? "
			       + " GROUP BY DivisionNumber,StoreNumber ";
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, inDiv);
			ps.setString(2, inStore);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				totalDivisionSales = rs.getDouble(3);
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return totalDivisionSales;
	}

	/* (non-Javadoc)
	 * @see bigbox.store_sales.StoreSalesReader#getAllStoreSalesWithInDivisonPerYear(java.lang.String, java.lang.String, java.lang.String)
	 */
	public double getAllStoreSalesWithInDivisonPerYear(String inDiv, String inStore, String inYear) {
		double totalDivisionSales = 0;
		String sql =  "SELECT DivisionNumber,StoreNumber,Year, sum(sales) as TOTAL "
					+ " FROM stores s, store_sales ss, divisions d " 
				    + " WHERE s.ID = ss.StoreID "
					+ " AND d.ID = s.DivisionID " 
				    + " AND DivisionNumber = ?" 
					+ " AND StoreNumber = ?" 
				    + " AND Year = ? "
					+ " GROUP BY StoreNumber";
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, inDiv);
			ps.setString(2, inStore);
			ps.setString(3, inYear);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				totalDivisionSales = rs.getDouble(4);
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return totalDivisionSales;
	}

	/**
	 * Gets the store sales from row.
	 *
	 * @param rs the rs
	 * @return the store sales from row
	 * @throws SQLException the SQL exception
	 */
	public static StoreSales getStoreSalesFromRow(ResultSet rs) throws SQLException {
		StoreSales ss = null;
		try {
			String id = rs.getString(1);
			String storeID = rs.getString(2);
			String year = rs.getString(3);
			String week = rs.getString(4);
			String sales = rs.getString(5);

			ss = new StoreSales(id, storeID, year, week, sales);
			ss.setId(id);
			ss.setStoreID(storeID);
			ss.setYear(year);
			ss.setWeek(week);
			ss.setSales(sales);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ss;
	}

}
