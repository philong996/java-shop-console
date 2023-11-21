package entities;

public class Product implements IProduct {
	
	private int id;
	private String productName;
	private String categoryName;
	private double price;

	public Product() {
	}
	
	public Product(int id, String productName, String categoryName, double price) {
		// <write your code here>
	}

	@Override
	public String toString() {
		// <write your code here>
		return null;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}

	
}