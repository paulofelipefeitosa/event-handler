package models.operation;

import models.order.Order;

public abstract class Operation implements Comparable<Operation> {

	private OperationType operationType;

	public Operation(OperationType operationType) {
		this.operationType = operationType;
	}

	public abstract Thread getOperationThread(Order order);

	public OperationType getOperationType() {
		return operationType;
	}

	@Override
	public int compareTo(Operation otherOperation) {
		return this.operationType.getPriority() - otherOperation.getOperationType().getPriority();
	}

}
