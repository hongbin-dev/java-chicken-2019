package domain.table.order;

import java.util.HashMap;
import java.util.Map;

import domain.table.order.menu.Menu;

public class Order {
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

	public void clear() {
		orderByCount.clear();
	}

	public boolean isEmpty() {
		return orderByCount.isEmpty();
	}
}
