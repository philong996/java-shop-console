package configs;

import entities.ICart;
import entities.Cart;
import entities.IUser;
import menu.Menu;

public class ApplicationContext {
	
	private static ApplicationContext instance;
	
	private IUser loggedInUser;
	private Menu mainMenu;
	private ICart sessionCart;
	
	private ApplicationContext() {
	}
	
	public void setLoggedInUser(IUser user) {
		if (this.sessionCart != null) {
			this.sessionCart.clear(); // we have to clear session cart when new user is logged in
		}
		this.loggedInUser = user;
	}
	
	public IUser getLoggedInUser() {
		return this.loggedInUser;
	}
	
	public void setMainMenu(Menu menu) {
		this.mainMenu = menu;
	}
	
	public Menu getMainMenu() {
		return this.mainMenu;
	}

	public static ApplicationContext getInstance() {
		if (instance == null) {
			instance = new ApplicationContext();
		}
		return instance;
	}

	public ICart getSessionCart() {
		if (this.sessionCart == null) {
			this.sessionCart = new Cart();
		}
		return this.sessionCart;
	}

}