package travelagency.user.view;

import java.util.Scanner;

import travelagency.dto.Booking;
import travelagency.dto.Location;
import travelagency.dto.User;
import travelagency.user.viewmodel.BookPlaceViewModel;

public class BookPlaceView {

	private BookPlaceViewModel bookPlaceViewModel;

	public BookPlaceView() {
		bookPlaceViewModel = new BookPlaceViewModel(this);
	}

	public void booking(User user) {
		Booking b = new Booking();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Location Name : ");
		String loc = sc.nextLine();

		Location l = bookPlaceViewModel.getLoction(loc);

		b.setUserName(user.getName());
		b.setResidence(user.getResidence());
		b.setEmail(user.getEmail());
		b.setBookingDate(user.getDate());
		b.setVacationType(user.getVacationType());
		b.setLocationName(l.getLocationName());
		b.setDay(l.getDay());
		b.setNoOfPeople(user.getNoOfPeople());
		b.setTotalPrice(user.getNoOfPeople() * l.getPrice());

		bookPlaceViewModel.addBooking(b);
	}

	public void onSuccess(String s) {
		System.out.println(s);
	}

	public void showError(String errorMessage) {
		System.err.println(errorMessage);
	}

}
