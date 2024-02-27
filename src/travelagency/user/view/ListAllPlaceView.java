package travelagency.user.view;

import java.util.List;

import travelagency.dto.Location;
import travelagency.dto.Place;
import travelagency.user.viewmodel.ListAllPlaceViewModel;

public class ListAllPlaceView {

	private ListAllPlaceViewModel listAllPlaceViewModel;

	public ListAllPlaceView() {
		listAllPlaceViewModel = new ListAllPlaceViewModel(this);
	}

	public void listAllPlace() {
		List<Location> locations = listAllPlaceViewModel.getAllLocations();

		System.out.println("#################################");
		System.out.println("#         All Locations         #");
		System.out.println("#################################");

		for (Location l : locations) {
			System.out.println("\t-----------------------------");
			System.out.println("Location Name : " + l.getLocationName());
			System.out.println("Time Duration : " + l.getDay() + " Days");
			System.out.println("Price for 1 person : " + l.getPrice());

			System.out.println("+-----------------+");
			System.out.println("|  Time Schedule  |");
			System.out.println("+-----------------+");

			for (Place p : l.getPlaces()) {
				System.out.println(p.getName());
				System.out.println(p.getAbout());
				System.out.println();
			}

			System.out.println("\t-----------------------------");
		}
	}

	public void onSuccess(String s) {
		System.out.println(s);
	}

	public void showError(String errorMessage) {
		System.err.println(errorMessage);
	}
}
