package travelagency.admin.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import travelagency.admin.viewmodel.AddNewLocationViewModel;
import travelagency.dto.Location;
import travelagency.dto.Place;

public class AddNewLocationView {
	private AddNewLocationViewModel addNewLocationViewModel;

	public AddNewLocationView() {
		addNewLocationViewModel = new AddNewLocationViewModel(this);
	}

	public void addLocation() {
		Scanner sc = new Scanner(System.in);

		List<Place> places = new ArrayList<>();
		Location newLoc = new Location();

		System.out.println("Enter the Location Name : ");
		newLoc.setLocationName(sc.nextLine());

		System.out.println("Enter How Many Day to spend : ");
		newLoc.setDay(sc.nextInt());

		System.out.println("Enter the Price : ");
		newLoc.setPrice(sc.nextInt());

		System.out.println("Enter How many place was added : ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter place name : ");
			String name = sc.nextLine();
			System.out.println("Enter about the place : ");
			String about = sc.nextLine();

			places.add(new Place(name, about));
		}
		newLoc.setPlaces(places);
		addNewLocationViewModel.addNewLocation(newLoc);
	}

	public void onSuccess(String s) {
		System.out.println(s);
	}

	public void showError(String errorMessage) {
		System.err.println(errorMessage);
	}

}
