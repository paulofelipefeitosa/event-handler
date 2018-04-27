package eventhandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import models.order.Order;
import models.order.OrderController;
import models.processqueue.Operation;
import models.processqueue.OrderOperationQueue;

public class EventHandler implements Runnable {

	List<OrderOperationQueue> toProcessOperationList;
	Map<Operation, OrderOperationQueue> inProcessingOperationQueueMap;

	OrderController orderController;
	
	long sleepTime;

	public EventHandler(OrderController orderController) {
		this.toProcessOperationList = new LinkedList<OrderOperationQueue>();
		this.inProcessingOperationQueueMap = new HashMap<Operation, OrderOperationQueue>();

		this.orderController = orderController;
		
		this.sleepTime = TimeUnit.SECONDS.toMillis(1);
	}

	@Override
	public void run() {
		while (true) {
			try {
				for (OrderOperationQueue orderOperationQueue : this.toProcessOperationList) {
					String orderId = orderOperationQueue.getOrderId();
					Operation operation = orderOperationQueue.getNextOperation();
					
					if (!this.operationIsBeingPerfomed(operation)) {
						Order order = this.orderController.getOrderById(orderId);
						
						this.setOperationBeingPerformed(operation, orderOperationQueue);
						
						Thread processThread = this.operationThread.get(operation);
						
					}
				}
				Thread.sleep(this.sleepTime);
			} catch (Throwable e) {

			}
		}

	}

	private boolean operationIsBeingPerfomed(Operation operation) {
		return this.inProcessingOperationQueueMap.containsKey(operation);
	}
	
	private void setOperationBeingPerformed(Operation operation, OrderOperationQueue orderOperationQueue) {
		this.toProcessOperationList.remove(orderOperationQueue);
		this.inProcessingOperationQueueMap.put(operation, orderOperationQueue);
	}
	
	private Thread getThreadByOperation(Operation operation) {
		
	}
}
