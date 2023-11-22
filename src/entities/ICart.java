package entities;

public interface ICart {
    boolean isEmpty();

	void addProduct(IProduct productById);

	IProduct[] getProducts();

	void clear();
}
