package menu;

import java.util.Scanner;

import configs.ApplicationContext;
import entities.ICart;
import entities.IOrder;
import entities.Order;
import services.IOrderManagementService;
import services.OrderManagementService;

public class CheckoutMenu implements Menu {
    static final String CHECKOUT_COMMAND = "checkout";
    private ApplicationContext context;
	private IOrderManagementService orderManagementService;
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = OrderManagementService.getInstance();
	}

    private boolean createOrder(String creditCardNumber) {
        IOrder order = new Order();

        if (!order.isCreditCardNumberValid(creditCardNumber)) {
            return false;
        }
        
        order.setCreditCardNumber(creditCardNumber);
        order.setCustomerId(context.getLoggedInUser().getId());
        order.setProducts(context.getSessionCart().getProducts());
        orderManagementService.addOrder(order);
        return true;
    }
	
	@Override
	public void start() {
        printMenuHeader();
		while (true) {

            ICart cart = context.getSessionCart();
            if (cart.isEmpty()) {
                System.out.println("Your cart is empty. Please, add product to cart first and then proceed with checkout");
                break;
            }

            System.out.println("Enter your credit card number without spaces and press enter if you confirm purchase");

            Scanner sc = new Scanner(System.in);
            String userCard = sc.next();

            if (createOrder(userCard)) {
                System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email");
                break;
            } else {
                System.out.println("Your card is invalid");
            }
        }
        
    
	}

	@Override
	public void printMenuHeader() {
		System.out.println("\n***** CHECKOUT PAGE *****");
	}
}
