package models.order;

import java.util.UUID;

public class Order {
	
	private String id;
	private OrderState state;
	
	public Order() {
		this.id = UUID.randomUUID().toString();
		this.state = OrderState.OPEN;
	}

	public String getId() {
		return id;
	}

	public OrderState getState() {
		return state;
	}
	
}
