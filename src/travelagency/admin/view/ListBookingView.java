package travelagency.admin.view;

import java.util.List;

import travelagency.admin.viewmodel.ListBookingViewModel;
import travelagency.dto.Booking;

public class ListBookingView {

	private ListBookingViewModel listBookingViewModel;

	public ListBookingView() {
		listBookingViewModel = new ListBookingViewModel(this);
	}

	public void listBookings() {
		List<Booking> bookings = listBookingViewModel.listBookings();
		System.out.println("################################");
		System.out.println("|          Bookings            |");
		System.out.println("################################");
		for (Booking b : bookings) {
			System.out.println("\t\t+---------------------------------+");
			System.out.println("Booking Id : " + b.getBookingId());
			System.out.println("Booking Date : " + b.getBookingDate());
			System.out.println("User Name : " + b.getUserName());
			System.out.println("User Residence " + b.getResidence());
			System.out.println("Email-id : " + b.getEmail());
			System.out.println("Vacation Type : " + b.getVacationType());
			System.out.println("Vaction place : " + b.getLocationName());
			System.out.println("Vacation duration : " + b.getDay() + " Days");
			System.out.println("No of Peoples : " + b.getNoOfPeople());
			System.out.println("Total Price : " + b.getTotalPrice());

			System.out.println("\t\t+---------------------------------+");
		}
	}

}