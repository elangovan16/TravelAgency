package travelagency.user.viewmodel;

import travelagency.dto.Booking;
import travelagency.dto.Location;
import travelagency.repository.TravelAgencyRepository;
import travelagency.user.view.BookPlaceView;

public class BookPlaceViewModel {
	private BookPlaceView bookPlaceView;

	public BookPlaceViewModel(BookPlaceView bookPlaceView) {
		this.bookPlaceView = bookPlaceView;
	}

	public Location getLoction(String loc) {
		return TravelAgencyRepository.getInstance().getLocationByName(loc);
	}

	public void addBooking(Booking b) {
		boolean res = TravelAgencyRepository.getInstance().addBooking(b);

		if (res) {
			bookPlaceView.onSuccess("Booking Successful..");
		} else {
			bookPlaceView.showError("Booking Failed");
		}
	}

}
