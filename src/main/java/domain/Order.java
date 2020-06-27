package domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
	private static final int MAX_COUNT = 99;

	private final Map<Menu, OrderCount> orderByCount;

	public Order() {
		this.orderByCount = new HashMap<>();
	}

	public void add(Menu menu, OrderCount orderCount) {
		int weight = 0;

		if (orderByCount.containsKey(menu)) {
			weight = orderByCount.get(menu).getAmount();
		}

		orderByCount.put(menu, orderCount.add(weight));
	}

	public Map<Menu, OrderCount> getOrderByCount() {
		return orderByCount;
	}
}
