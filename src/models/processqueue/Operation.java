package models.processqueue;

public enum Operation {
	OPEN(1), SPAWNING(2), FULFILLED(3), DELETE(0);

	private int priority;

	Operation(int value) {
		this.priority = value;
	}

	public int getPriority() {
		return this.priority;
	}
}
