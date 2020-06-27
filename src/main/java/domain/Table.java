package domain;

public class Table {
	private final int number;
	private final Order order;

	public Table(final int number, Order order) {
		this.number = number;
		this.order = order;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
