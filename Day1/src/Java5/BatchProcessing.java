package Java5;

import java.util.ArrayList;
import java.util.List;


public class BatchProcessing {
	public static void main(String args[]) {
		Orderprocess orderProces = new Orderprocess();
		List<Order> orders = new ArrayList<Order>(10);
		for (int i = 0; i < 10; i++) {
			orders.add(new Order(i, "payload-" + i));
		}
		BatchSummary result1 = orderProces.orderprocessing(orders, 4);
		System.out.println(result1.toString());
		BatchSummary result2 = orderProces.orderprocessing(orders, 4);
		System.out.println(result2.toString());
		BatchSummary result3 = orderProces.orderprocessing(orders, 4);
		System.out.println(result3.toString());

	}

}
