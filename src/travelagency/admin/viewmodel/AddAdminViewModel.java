package travelagency.admin.viewmodel;

import travelagency.admin.view.AddAdminView;
import travelagency.dto.Admin;
import travelagency.repository.TravelAgencyRepository;

public class AddAdminViewModel {
	private AddAdminView addAdminView;

	public AddAdminViewModel(AddAdminView addAdminView) {
		this.addAdminView = addAdminView;
	}

	public void addAdmin(Admin newAdmin) {
		boolean res = TravelAgencyRepository.getInstance().addAdmin(newAdmin);
		if (res) {
			addAdminView.onSuccess("new Addmin added successful");
		} else {
			addAdminView.showError("Something went Wrong");
		}
	}

}
