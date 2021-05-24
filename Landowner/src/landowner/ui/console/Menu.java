package landowner.ui.console;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class Menu implements OperationRole {

	private String message;
	private Scanner scanner;
	private Map<Integer, OperationRole> operationMap;

	public Menu(String message, Scanner scanner, Map<Integer, OperationRole> operationMap) {
		this.message = message;
		this.scanner = scanner;
		this.operationMap = operationMap;
	}

	public void run() {
		OperationRole operation;
		do {
			displayMessages();
			System.out.print("Your option: ");
			int operationCode = scanner.nextInt();
			System.out.println("");
			operation = operationMap.get(operationCode);
			if (operation != null)
				operation.run();
			else {
				operation = operationMap.get(-1);
				operation.run();
			}
		} while (operation.doContinue());
	}

	public String getMessage() {
		return message;
	}

	public boolean doContinue() {
		return true;
	}

	public void displayMessages() {
		Collection<OperationRole> values = operationMap.values();
		for (OperationRole operation : values) {
			System.out.println(operation.getMessage());
		}
	}

}
