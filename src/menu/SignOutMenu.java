package menu;

import configs.ApplicationContext;

public class SignOutMenu implements Menu {

	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		context.setLoggedInUser(null);
        System.out.println("Have a nice day! Look forward to welcoming back!");
	}

	@Override
	public void printMenuHeader() {
		System.out.println("\n***** SIGNOUT *****");
	}

}
