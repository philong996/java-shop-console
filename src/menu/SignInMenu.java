package menu;

import java.util.Scanner;

import configs.ApplicationContext;
import entities.IUser;
import entities.User;
import services.IUserManagementService;
import services.UserManagementService;

public class SignInMenu implements Menu {

	private ApplicationContext context;
	private IUserManagementService userManagementService;

	{
		context = ApplicationContext.getInstance();
		userManagementService = UserManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();

        Scanner sc = new Scanner(System.in);

        System.out.println("Input the email");
        String email = sc.nextLine();

        System.out.println("Input the password");
        String password = sc.next();

        IUser user = userManagementService.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            context.setLoggedInUser(user);
            System.out.printf("Glad to see you back %s %s", user.getFirstName(), user.getLastName());
        } else {
            System.out.println("Unfortunately, such login and password doesn't exist");
        }
	}

	@Override
	public void printMenuHeader() {
		System.out.println("\n***** SIGNUP IN *****");
	}

}