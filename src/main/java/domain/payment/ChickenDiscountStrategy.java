package domain.payment;

import domain.table.order.Order;

public class ChickenDiscountStrategy implements DiscountStrategy {
	@Override
	public long calculate(long money, Order order) {
		int count = order.calculateChickenCount();
		int discount = (count / 10) * 10000;
		return money - discount;
	}
}
