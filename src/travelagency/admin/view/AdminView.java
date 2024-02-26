package travelagency.admin.view;

import java.util.Scanner;

import travelagency.admin.viewmodel.AdminViewModel;
import travelagency.dto.Admin;

public class AdminView {
	private AdminViewModel adminViewModel;

	public AdminView() {
		adminViewModel = new AdminViewModel(this);
	}

	public void init() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name : ");
		String name = sc.nextLine();
		System.out.print("Enter the Password : ");
		String password = sc.nextLine();

		Admin admin = new Admin(name, password);

		boolean res = adminViewModel.check(admin);

		if (res) {
			System.out.println("Welcome " + admin.getName());
			boolean flag = true;
			int chioce;
			do {
				info();
				chioce = sc.nextInt();

				switch (chioce) {
				case 1 -> {
					AddNewPlaceView addPlace = new AddNewPlaceView();
					addPlace.add();
				}
				case 2 -> {
					ListBookingView listBooking = new ListBookingView();
					listBooking.listBookings();
				}
				case 3 -> {
					AddAdminView addAdmin = new AddAdminView();
					addAdmin.addNewAdmin();
				}
				case 0 -> {
					System.exit(chioce);
				}
				case -1 -> {
					flag = false;
				}
				default -> {
					System.err.println("Invalid choice. Please Enter Valid Choice.");
				}
				}
			} while (flag);
		} else {
			System.err.println("Something went wrong.");
		}
	}

	public void info() {
		System.out.println("+------------------------+");
		System.out.println("|       Admin Page       |");
		System.out.println("+------------------------+");
		System.out.println("|  1.Add New Place       |");
		System.out.println("|  2.List Booking        |");
		System.out.println("|  3.Add New Admin       |");
		System.out.println("|  0.Exit                |");
		System.out.println("| -1.Back                |");
		System.out.println("+------------------------+");
		System.out.print("  Enter the choice : ");
	}
}
