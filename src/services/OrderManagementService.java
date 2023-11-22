package services;

import java.util.Arrays;

import entities.IOrder;
import entities.Order;

public class OrderManagementService implements IOrderManagementService {

	private static final int DEFAULT_ORDER_CAPACITY = 10;

	private static OrderManagementService instance;

	private IOrder[] orders;
	private int lastOrderIndex;

    {
        orders = new IOrder[DEFAULT_ORDER_CAPACITY];
        lastOrderIndex = 0;
    }

	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new OrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(IOrder order) {
		orders[lastOrderIndex++] = order;
	}

	@Override
	public IOrder[] getOrdersByUserId(int userId) {
		int amountOfUserOrders = 0;
		for (IOrder order : orders) {
			if (order != null && order.getCustomerId() == userId) {
				amountOfUserOrders++;
			}
		}
		
		IOrder[] userOrders = new Order[amountOfUserOrders];
		
		int index = 0;
		for (IOrder order : orders) {
			if (order != null && order.getCustomerId() == userId) {
				userOrders[index++] = order;
			}
		}
		
		return userOrders;
	}

	@Override
	public IOrder[] getOrders() {
        int cnt = 0;
        for (IOrder order : orders ) {
            if (order != null) {
                cnt++;
            }
        }

		return Arrays.copyOf(orders, cnt);
	}
	
	void clearServiceState() {
		// <write your code here>
	}
}
