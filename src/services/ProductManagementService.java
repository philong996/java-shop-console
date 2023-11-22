package services;

import entities.IProduct;
import entities.Product;

public class ProductManagementService implements IProductManagementService {
    
	private static ProductManagementService instance;
	
	private static IProduct[] products;
	
	static {
		initProducts();
	}

	private static void initProducts() {
		products = new IProduct[] {
				new Product("Hardwood Oak Suffolk Internal Door", "Doors", 109.99),
				new Product("Oregon Cottage Interior Oak Door", "Doors", 179.99),
				new Product("Oregon Cottage Horizontal Interior White Oak Door", "Doors", 189.99),
				new Product("4 Panel Oak Deco Interior Door", "Doors", 209.09),
				new Product("Worcester 2000 30kW Ng Combi Boiler Includes Free Comfort+ II controller", "Boilers", 989.99),
				new Product("Glow-worm Betacom 4 30kW Combi Gas Boiler ERP", "Boilers", 787.99),
				new Product("Worcester 2000 25kW Ng Combi Boiler with Free Comfort+ II controller", "Boilers", 859.99),
				new Product("Wienerberger Terca Class B Engineering Brick Red 215mm x 102.5mm x 65mm (Pack of 504)", "Bricks", 402.99),
				new Product("Wienerberger Terca Engineering Brick Blue Perforated Class B 65mm (Pack of 400)", "Bricks", 659.99),
				new Product("Wienerberger Engineering Brick Red Smooth Class B 73mm - Pack of 368", "Bricks", 523.99)
		};
	}
	
	private ProductManagementService() {
		
	}

	public static ProductManagementService getInstance() {
		if (instance == null) {
			instance = new ProductManagementService();
		}
		return instance;
	}

	@Override
	public IProduct[] getProducts() {
		return products;
	}

	@Override
	public IProduct getProductById(int productIdToAddToCart) {
		for (IProduct product : products) {
            if (product.getId() == productIdToAddToCart) {
                return product;
            }
        }
		return null;
	}
}
