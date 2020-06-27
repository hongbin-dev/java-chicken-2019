package domain.payment;

import java.util.Arrays;
import java.util.List;

import domain.table.order.Order;

public enum PaymentType {
	CARD(1, Arrays.asList(new ChickenDiscountStrategy())),
	CACHE(2, Arrays.asList(new ChickenDiscountStrategy(), new CacheDiscountStrategy()));

	private final int type;
	private final List<DiscountStrategy> discountStrategies;

	PaymentType(int type, List<DiscountStrategy> discountStrategies) {
		this.type = type;
		this.discountStrategies = discountStrategies;
	}

	public static PaymentType of(int type) {
		return Arrays.stream(values())
			.filter(paymentType -> paymentType.type == type)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 결제방식입니다. type =" + type));
	}

	public long calculatePrice(Order order) {
		long money = order.calculateTotalMoney();
		for (DiscountStrategy discountStrategy : discountStrategies) {
			money = discountStrategy.calculate(money, order);
		}
		return money;
	}
}
