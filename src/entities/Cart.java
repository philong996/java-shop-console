package entities;

public class Cart implements ICart {
    private static int DEFAULT_PRODUCTS_CAPACITY = 10;
	IProduct[] products;
    int lastProductIndex;

    {
        this.products = new IProduct[Cart.DEFAULT_PRODUCTS_CAPACITY];
        lastProductIndex = 0;
    }

	@Override
	public boolean isEmpty() {
        if (products[0] == null)
		    return true;
        
        return false;
	}

	@Override
	public void addProduct(IProduct product) {
		products[lastProductIndex++] = product;
	}

	@Override
	public IProduct[] getProducts() {
		return products;
	}

	@Override
	public void clear() {
		products = new Product[DEFAULT_PRODUCTS_CAPACITY];
        lastProductIndex = 0;
	}

}