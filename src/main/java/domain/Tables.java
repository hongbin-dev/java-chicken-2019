package domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;

public class Tables {
	private final Map<Integer, Table> tableById;

	public Tables(List<Table> tables) {
		this.tableById = tables.stream()
			.collect(toMap(Table::getNumber, table -> table));
	}

	public Table getTable(int tableNumber) {
		if (!tableById.containsKey(tableNumber)) {
			throw new IllegalArgumentException("찾을 수 없는 테이블입니다. tableNumber =" + tableNumber);
		}
		return tableById.get(tableNumber);
	}

	public Map<Integer, Table> getTableById() {
		return tableById;
	}

	public Table getOrderedTable(int tableNumber) {
		Table table = getTable(tableNumber);

		if (table.isEmpty()) {
			throw new IllegalArgumentException("주문되지 않는 테이블입니다. tableNumber =" + tableNumber);
		}

		return table;
	}
}
