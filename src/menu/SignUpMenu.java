package menu;
import java.util.Scanner;

import configs.ApplicationContext;
import entities.User;
import services.UserManagementService;
import services.IUserManagementService;

public class SignUpMenu implements Menu {

	private IUserManagementService userManagementService;
	private ApplicationContext context;

	{
		userManagementService = UserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();

        Scanner sc = new Scanner(System.in);
        System.out.println("Input the first name");
        String firstName = sc.next();
        
        System.out.println("Input the last name");
        String lastName = sc.next();

        sc.nextLine();
        System.out.println("Input the email");
        String email = sc.nextLine();

        System.out.println("Input the password");
        String password = sc.next();

        User user = new User(
            firstName,
            lastName,
            password,
            email
        );

        String error_message = userManagementService.registerUser(user);
        if (error_message == "") {
            userManagementService.registerUser(user);
            System.out.println("Successful! A new user is created");
        } else {
            System.out.println(error_message);
        }
    }

	@Override
	public void printMenuHeader() {
		System.out.println("\n***** SIGNUP MENU *****");
	}

}
