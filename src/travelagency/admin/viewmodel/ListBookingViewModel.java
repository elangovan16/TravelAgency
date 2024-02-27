package travelagency.admin.viewmodel;

import java.util.List;

import travelagency.admin.view.ListBookingView;
import travelagency.dto.Booking;
import travelagency.repository.TravelAgencyRepository;

public class ListBookingViewModel {
	private ListBookingView listBookingView;

	public ListBookingViewModel(ListBookingView listBookingView) {
		this.listBookingView = listBookingView;
	}

	public List<Booking> listBookings() {
		return TravelAgencyRepository.getInstance().getAllBookings();
	}

}
