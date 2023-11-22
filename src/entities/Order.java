package entities;

import java.util.Arrays;

public class Order implements IOrder {

	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;
	
	private String creditCardNumber;
	private IProduct[] products;
	private int customerId;

	@Override
	public boolean isCreditCardNumberValid(String creditCardNumber) {
		if ((creditCardNumber.length() == Order.AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER) && (!creditCardNumber.contains(" ")) && (Long.parseLong(creditCardNumber) > 0)) {
            return true;
        } 
		return false;
	}

	@Override
	public void setCreditCardNumber(String creditCardNumber) {
		if (creditCardNumber == null) {
            return;
        }
        this.creditCardNumber = creditCardNumber;
	}

	@Override
	public void setProducts(IProduct[] products) {
		this.products = products;
	}

	@Override
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	@Override
	public int getCustomerId() {
		return this.customerId;
	}
	
	@Override
	public String toString() {
		return "Order: customer id - " + this.customerId + "\t" +
					"credit card number - " + this.creditCardNumber + "\t" + 
					"products - " + Arrays.toString(this.products);
	}
}
