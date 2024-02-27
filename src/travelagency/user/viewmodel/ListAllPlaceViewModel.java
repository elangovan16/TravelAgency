package travelagency.user.viewmodel;

import java.util.List;

import travelagency.dto.Location;
import travelagency.repository.TravelAgencyRepository;
import travelagency.user.view.ListAllPlaceView;

public class ListAllPlaceViewModel {
	private ListAllPlaceView listAllPlaceView;

	public ListAllPlaceViewModel(ListAllPlaceView listAllPlaceView) {
		this.listAllPlaceView = listAllPlaceView;
	}

	public List<Location> getAllLocations() {
		return TravelAgencyRepository.getInstance().getAllLocationsWithPlaces();
	}

}
