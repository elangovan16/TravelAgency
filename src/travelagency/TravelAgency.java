package travelagency;

import java.util.Scanner;

import travelagency.admin.view.AdminView;
import travelagency.user.view.UserView;

public class TravelAgency {
	public static void main(String[] args) {
		TravelAgency travelAgency = new TravelAgency();
		travelAgency.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int choice;
		do {
			info();
			choice = sc.nextInt();
			switch (choice) {
			case 1 -> {
				AdminView admin = new AdminView();
				admin.init();
			}
			case 2 -> {
				UserView user = new UserView();
				user.init();
			}
			case 0 -> {
				flag = false;
			}
			default -> {
				System.err.println("Invalid choice. Please Enter Valid Choice.");
			}
			}
		} while (flag);
	}

	private void info() {
		System.out.println("+-----------------------+");
		System.out.println("|     Travel Agency     |");
		System.out.println("+-----------------------+");
		System.out.println("| 1.Admin               |");
		System.out.println("| 2.User                |");
		System.out.println("| 0.Exit                |");
		System.out.println("+-----------------------+");
		System.out.print("  Enter the choice : ");

	}

}
