package services;

import entities.IProduct;

public interface IProductManagementService {

	IProduct[] getProducts();

	IProduct getProductById(int productIdToAddToCart);

}
