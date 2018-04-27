package models.operation.implementation;

import models.operation.Operation;
import models.operation.OperationType;
import models.order.Order;

public class OpenOperation extends Operation {

	public OpenOperation() {
		super(OperationType.OPEN);
	}

	@Override
	public Thread getOperationThread(Order order) {
		// TODO Here you should construct the Thread that handle the Operation for the
		// @order
		return new Thread();
	}

}
