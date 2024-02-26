package travelagency.user.view;

import java.time.LocalDate;
import java.util.Scanner;

import travelagency.dto.User;
import travelagency.user.viewmodel.UserViewModel;

public class UserView {
	private UserViewModel userViewModel;

	public UserView() {
		userViewModel = new UserViewModel(this);
	}

	public void init() {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int chioce;
		do {
			info();
			chioce = sc.nextInt();

			switch (chioce) {
			case 1 -> {
				ListAllPlaceView listPlace = new ListAllPlaceView();
				listPlace.listAllPlace();
			}
			case 2 -> {
				BookPlaceView book = new BookPlaceView();
				book.booking();
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

	}

	public void info() {
		System.out.println("+------------------------+");
		System.out.println("|       User Page        |");
		System.out.println("+------------------------+");
		System.out.println("|  1.List all place      |");
		System.out.println("|  2.Book the place      |");
		System.out.println("|  0.Exit                |");
		System.out.println("| -1.Back                |");
		System.out.println("+------------------------+");
		System.out.print("  Enter the choice : ");
	}

	public User getUser() {
		Scanner sc = new Scanner(System.in);
		User user = new User();

		System.out.println("Enter the Name of User: ");
		user.setName(sc.nextLine());

		System.out.println("Enter the Residence: ");
		user.setResidence(sc.nextLine());

		System.out.println("Enter the Email: ");
		user.setEmail(sc.nextLine());

		System.out.println("Enter the Date (YYYY-MM-DD): ");
		user.setDate(LocalDate.parse(sc.nextLine()));

		System.out.println("Enter the Number of People: ");
		user.setNoOfPeople(sc.nextInt());
		sc.nextLine();

		System.out.println("Enter the Vacation Type: ");
		user.setVacationType(sc.nextLine());

		return user;
	}

}
