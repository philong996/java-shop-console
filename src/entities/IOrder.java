package entities;

public interface IOrder {
    boolean isCreditCardNumberValid(String userInput);

	void setCreditCardNumber(String userInput);

	void setProducts(IProduct[] products);

	void setCustomerId(int customerId);
	
	int getCustomerId();
}
