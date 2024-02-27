package travelagency.admin.viewmodel;

import travelagency.admin.view.AddNewLocationView;
import travelagency.dto.Location;
import travelagency.repository.TravelAgencyRepository;

public class AddNewLocationViewModel {
	private AddNewLocationView addNewLocationView;

	public AddNewLocationViewModel(AddNewLocationView addNewLocationView) {
		this.addNewLocationView = addNewLocationView;
	}

	public void addNewLocation(Location newLoc) {
		boolean res = TravelAgencyRepository.getInstance().addNewLocation(newLoc);

		if (res) {
			addNewLocationView.onSuccess("Location Added Successful ...");
		} else {
			addNewLocationView.showError("Location Added Failed");
		}
	}

}
