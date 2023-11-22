package services;

import entities.IOrder;

public interface IOrderManagementService {
	void addOrder(IOrder order);

	IOrder[] getOrdersByUserId(int userId);
	
	IOrder[] getOrders();
}
