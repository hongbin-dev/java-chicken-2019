package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenusTest {

	@DisplayName("메뉴 번호에 맞는 메뉴를 가져온다.")
	@Test
	void getOrThrow() {
		Menus menus = new Menus(MenuRepository.menus());

		Menu menu = menus.getOrThrow(1);

		assertThat(menu).isNotNull();
	}

	@DisplayName("등록되지 않는 메뉴를 가져오면 에러를 발생한다.")
	@Test
	void name() {
		Menus menus = new Menus(MenuRepository.menus());

		assertThatThrownBy(() -> menus.getOrThrow(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("찾을 수 없는 메뉴입니다.");
	}
}