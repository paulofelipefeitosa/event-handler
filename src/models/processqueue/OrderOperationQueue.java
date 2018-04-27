package models.processqueue;

import java.util.PriorityQueue;

import models.operation.Operation;

public class OrderOperationQueue {

	private String orderId;
	private PriorityQueue<Operation> priorityQueue;

	public OrderOperationQueue(String orderId) {
		this.orderId = orderId;
		this.priorityQueue = new PriorityQueue<Operation>();
	}

	public String getOrderId() {
		return orderId;
	}

	public Operation getNextOperation() {
		Operation operation = this.priorityQueue.peek();
		return operation;
	}

	public void addOperation(Operation operation) {
		this.priorityQueue.add(operation);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderOperationQueue other = (OrderOperationQueue) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
}
