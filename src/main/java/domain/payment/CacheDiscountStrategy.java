package domain.payment;

import domain.table.order.Order;

public class CacheDiscountStrategy implements DiscountStrategy {
	@Override
	public long calculate(long money, Order order) {
		return (long)((double)money * 0.95);
	}
}
