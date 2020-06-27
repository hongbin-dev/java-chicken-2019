package domain;

import java.util.Arrays;

public enum PaymentType {
	CARD(1),
	CACHE(2);

	private final int type;

	PaymentType(int type) {
		this.type = type;
	}

	public static PaymentType of(int type) {
		return Arrays.stream(values())
			.filter(paymentType -> paymentType.type == type)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 결제방식입니다. type =" + type));
	}

	public long calculatePrice(Order order) {
		return 0;
	}
}
