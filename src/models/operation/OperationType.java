package models.operation;

public enum OperationType {

	OPEN(1), SPAWNING(2), FULFILLED(3), DELETE(0);

	private int priority;

	OperationType(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return this.priority;
	}
}
