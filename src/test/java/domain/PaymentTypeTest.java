package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PaymentTypeTest {

	@DisplayName("입력에 맞는 Payment타입을 확인한다.")
	@CsvSource(value = {"1,CARD", "2,CACHE"})
	@ParameterizedTest
	void of(int type, PaymentType actual) {
		PaymentType paymentType = PaymentType.of(type);

		assertThat(paymentType).isEqualTo(actual);
	}

	@DisplayName("잘못된 타입을 입력하면 에러가 발생한다.")
	@Test
	void name() {
		assertThatThrownBy(() -> PaymentType.of(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("찾을 수 없는 결제방식입니다");
	}
}