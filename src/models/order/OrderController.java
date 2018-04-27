package models.order;

import java.util.LinkedList;
import java.util.List;

public final class OrderController {
	List<Order> ordersList;

	public OrderController() {
		this.ordersList = new LinkedList<Order>();
	}

	public Order getOrderById(String id) {
		for (Order order : this.ordersList) {
			if (order.getId().equals(id)) {
				return order;
			}
		}
		return null;
	}
}
