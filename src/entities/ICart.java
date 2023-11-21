package entities;

public interface ICart {
    boolean isEmpty();

	void addProduct(Product productById);

	Product[] getProducts();

	void clear();
}
