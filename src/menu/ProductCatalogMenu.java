package menu;

import java.util.Scanner;

import configs.ApplicationContext;
import entities.IProduct;
import services.ProductManagementService;

public class ProductCatalogMenu implements Menu {

	private static final String CHECKOUT_COMMAND = "checkout";
	private ApplicationContext context;
	private ProductManagementService productManagementService;

	{
		context = ApplicationContext.getInstance();
		productManagementService = ProductManagementService.getInstance();
	}

	@Override
	public void start() {
		while (true) {
			printMenuHeader();

			IProduct[] products = productManagementService.getProducts();
			for (IProduct product : products) {
				System.out.println(product.toString());
			}	

			Scanner sc = new Scanner(System.in);

			System.out.println("Choose the product id or come back menu: ");
			String useInput = sc.next();

			if (useInput.equalsIgnoreCase("menu")) {
				Menu menu = context.getMainMenu();
				menu.start();
			} else {
				try {
					int productId = Integer.parseInt(useInput);

					IProduct product = productManagementService.getProductById(productId);

					if (product == null) {
						System.out.println("Your choice of ID does not exist");
					} else {
						System.out.printf("Product %s has been added to your cart. If you want to add a new product - enter the product id. If you want to proceed with checkout - enter word 'checkout' to console", product.getProductName());
					}
				} catch (NumberFormatException e) {
					System.out.println("The user input is invalid");
				}
			}
		}


		
	}

	@Override
	public void printMenuHeader() {
		System.out.println("\n***** PRODUCT LIST *****");
	}

}
