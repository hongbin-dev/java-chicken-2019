package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
	@DisplayName("메뉴를 추가하여 갯수를 확인한다.")
	@Test
	void name() {
		Order order = new Order();

		Menu 후라이드 = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
		order.add(후라이드, OrderCount.of(5));

		Map<Menu, OrderCount> orderByCount = order.getOrderByCount();
		OrderCount actual = orderByCount.get(후라이드);

		assertThat(actual.getAmount()).isEqualTo(5);
	}

	@DisplayName("메뉴 추가시 한 메뉴가 (기존 수량 + 입력한 수량) 값이 99를 넘지 않는다.")
	@Test
	void name2() {
		Order order = new Order();

		Menu 후라이드 = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
		order.add(후라이드, OrderCount.of(99));

		assertThatThrownBy(() -> order.add(후라이드, OrderCount.of(1)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("잘못된 범위의 값을 입력했습니다.");
	}

	@DisplayName("주문목록을 초기화한다.")
	@Test
	void clear() {
		Order order = new Order();
		Menu 후라이드 = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
		order.add(후라이드, OrderCount.of(99));

		order.clear();

		Map<Menu, OrderCount> actual = order.getOrderByCount();
		assertThat(actual.size()).isEqualTo(0);
	}

	@DisplayName("주문이 비어 있는지 확인한다.")
	@Test
	void isEmpty() {
		Order order = new Order();
		assertThat(order.isEmpty()).isTrue();
	}

	//0. 기능을 입력받는다.
	// 1. 주문등록
	//     - 테이블을 보여주고 입력받는다.
	//     - 메뉴를 보여주고 메뉴 번호를 입력받는다.
	//
	// 2. 결제하기
	//     - 테이블을 보여주고 테이블을 입력받는다.
	//         - 주문이 있는 테이블을 골라야한다.
	//     - 주문내역을 보여주고, 결제 방식을 입력받는다.
	//         - 치킨은 10마리당 만원씩 할인된다.
	//         - 추가로 현금결제시 5% 할인된다.
	//     - 최종 결제금액을보여준다.
	// 3. 게임 종료
}