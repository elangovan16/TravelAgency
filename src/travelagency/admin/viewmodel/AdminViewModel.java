package travelagency.admin.viewmodel;

import travelagency.admin.view.AdminView;
import travelagency.dto.Admin;
import travelagency.repository.TravelAgencyRepository;

public class AdminViewModel {
	private AdminView adminView;

	public AdminViewModel(AdminView adminView) {
		this.adminView = adminView;
	}

	public boolean check(Admin admin) {
		return TravelAgencyRepository.getInstance().isAdmin(admin);
	}

}
