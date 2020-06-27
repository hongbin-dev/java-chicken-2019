package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Menus;
import domain.OrderCount;
import domain.PaymentType;
import domain.PosMenu;
import domain.Table;
import domain.TableRepository;
import domain.Tables;
import view.InputView;
import view.OutputView;

public class ChickenController {
	private final InputView inputView;
	private final OutputView outputView;

	public ChickenController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		outputView.printMain();

		Menus menus = new Menus(MenuRepository.menus());
		Tables tables = new Tables(TableRepository.tables());

		while (true) {
			int function = inputView.inputSelectFunction();
			PosMenu posMenu = PosMenu.of(function);
			if (PosMenu.ORDER == posMenu) {
				outputView.printTables(tables);
				Table table = tables.getTable(inputView.inputTableNumber());

				outputView.printMenus(menus);
				Menu menu = menus.getOrThrow(inputView.inputSelectMenu());

				OrderCount orderCount = OrderCount.of(inputView.inputMenuAmount());

				table.addOrder(menu, orderCount);
			} else if (PosMenu.PAYMENT == posMenu) {
				outputView.printTables(tables);
				Table table = tables.getOrderedTable(inputView.inputTableNumber());

				outputView.printOrderHistory(table);
				PaymentType paymentType = PaymentType.of(inputView.inputSelectPayment(table));

				long price = paymentType.calculatePrice(table.getOrder());
				outputView.printPrice(price);

				table.clear();
			} else if (PosMenu.EXIT == posMenu) {
				System.exit(0);
			}
		}
	}
}
