package travelagency.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import travelagency.dto.Admin;
import travelagency.dto.Booking;
import travelagency.dto.Location;
import travelagency.dto.Place;

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

	public boolean addNewLocation(Location newLoc) {
		String query = "INSERT INTO location (l_name, day, price) VALUES (?, ?, ?)";

		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, newLoc.getLocationName());
			pstmt.setInt(2, newLoc.getDay());
			pstmt.setInt(3, newLoc.getPrice());

			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				int locationId = getLocationIdByName(newLoc.getLocationName());
				addPlacesForLocation(locationId, newLoc.getPlaces());
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void addPlacesForLocation(int locationId, List<Place> places) {
		String query = "INSERT INTO place (l_id, p_name, p_about) VALUES (?, ?, ?)";

		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmtPlace = con.prepareStatement(query);

			for (Place place : places) {
				pstmtPlace.setInt(1, locationId);
				pstmtPlace.setString(2, place.getName());
				pstmtPlace.setString(3, place.getAbout());
				pstmtPlace.addBatch();
			}

			pstmtPlace.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getLocationIdByName(String locationName) {
		String query = "SELECT l_id FROM location WHERE l_name = ?";
		int locationId = -1;
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, locationName);

			try (ResultSet resultSet = pstmt.executeQuery()) {
				if (resultSet.next()) {
					locationId = resultSet.getInt("l_id");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return locationId;
	}

	public List<Booking> getAllBookings() {
		String query = "SELECT * FROM booking";
		List<Booking> bookings = new ArrayList<>();

		try (Connection con = GetConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(query);
				ResultSet resultSet = pstmt.executeQuery()) {

			while (resultSet.next()) {
				Booking booking = new Booking();
				booking.setBookingId(resultSet.getInt("b_id"));
				booking.setUserName(resultSet.getString("user_name"));
				booking.setResidence(resultSet.getString("residence"));
				booking.setEmail(resultSet.getString("email"));
				booking.setVacationType(resultSet.getString("vaction_type"));
				booking.setLocationName(resultSet.getString("l_name"));
				booking.setDay(resultSet.getInt("day"));
				booking.setBookingDate(resultSet.getDate("b_date"));
				booking.setNoOfPeople(resultSet.getInt("no_of_people"));
				booking.setTotalPrice(resultSet.getInt("total_price"));

				bookings.add(booking);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookings;
	}
}
