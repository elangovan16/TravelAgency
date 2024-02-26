package travelagency.admin.view;

import java.util.Scanner;

import travelagency.admin.viewmodel.AddAdminViewModel;
import travelagency.dto.Admin;

public class AddAdminView {

	private AddAdminViewModel addAdminViewModel;

	public AddAdminView() {
		addAdminViewModel = new AddAdminViewModel(this);
	}

	public void addNewAdmin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new Admin name : ");
		String name = sc.nextLine();
		System.out.println("Enter new Admin password : ");
		String password = sc.nextLine();

		Admin newAdmin = new Admin(name, password);
		addAdminViewModel.addAdmin(newAdmin);
	}

	public void onSuccess(String s) {
		System.out.println(s);
	}

	public void showError(String errorMessage) {
		System.err.println(errorMessage);
	}

}
