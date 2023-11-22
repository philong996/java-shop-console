package menu;

import java.util.Scanner;

import configs.ApplicationContext;

public class MainMenu implements Menu {

	public static final String MENU_COMMAND = "menu";
	
	private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed." + System.lineSeparator()
			+ "1. Sign Up" + System.lineSeparator() + "2. Sign In"
			+ System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
			+ "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() + 
			"6. Customer List";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed." + System.lineSeparator()
			+ "1. Sign Up" + System.lineSeparator() + "2. Sign Out"
			+ System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
			+ "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() + 
			"6. Customer List";;

	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		while (true) {
            if (context.getMainMenu() == null) {
                context.setMainMenu(this);
            }

            Menu choosedMenu = null;

            choiceLoop: while (true) {
                printMenuHeader();
                Scanner sc = new Scanner(System.in);

                System.out.println("Choose the menu: ");
                String userInput = sc.next();

                if (userInput.equalsIgnoreCase("exit")) {
                    System.exit(0);
                }

                switch (userInput) {
                    case "1":
                        choosedMenu = new SignUpMenu();
                        break choiceLoop;
                
                    case "2":
                        if (context.getLoggedInUser() == null) {
                            choosedMenu = new SignInMenu();
                        } else {
                            choosedMenu = new SignOutMenu();
                        }
                        
                        break choiceLoop;
                    
                    case "3":
                        choosedMenu = new ProductCatalogMenu();

                        break choiceLoop;

                    case "4":
                        choosedMenu = new OrderMenu();

                        break choiceLoop;

                    default:
                        System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time");
                        continue;
                }
            } 

            choosedMenu.start();
        }
		
	}

	@Override
	public void printMenuHeader() {
        System.out.println("\n***** MAIN MENU *****");
        if (context.getLoggedInUser() == null) {
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
        } else {
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
        }
	}
}
