package entities;

public class Product implements IProduct {
	private static int nextId=0;

	private int id;
	private String productName;
	private String categoryName;
	private double price;

	{
		this.id = ++Product.nextId;
	}

	public Product() {
	}
	
	public Product(String productName, String categoryName, double price) {
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product {id: " + id + ", " +
			   "Name: " + productName + ", " +
			   "Category: " + categoryName + ", " +
			   "Price: " + price + " }";
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