package travelagency.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import travelagency.dto.Admin;

public class TravelAgencyRepository {
	private static TravelAgencyRepository repository;

	private TravelAgencyRepository() {

	}

	public static TravelAgencyRepository getInstance() {
		if (repository == null) {
			repository = new TravelAgencyRepository();
		}
		return repository;
	}

	public boolean addAdmin(Admin newAdmin) {
		String query = "INSERT INTO admins (admin_name, admin_password) VALUES (?, ?)";
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, newAdmin.getName());
			pstmt.setString(2, newAdmin.getPassword());

			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isAdmin(Admin admin) {
		String query = "SELECT * FROM admins WHERE admin_name = ? AND admin_password = ?";

		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, admin.getName());
			pstmt.setString(2, admin.getPassword());

			ResultSet rs = pstmt.executeQuery();
			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
