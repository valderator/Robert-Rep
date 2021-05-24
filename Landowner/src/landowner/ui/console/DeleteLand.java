package landowner.ui.console;

import java.util.Scanner;

import landowner.bussiness.Landowner;

public class DeleteLand implements OperationRole {

	private String message;
	private String enterMessage;
	private Scanner scanner;
	private Landowner Landowner;

	public DeleteLand(String message, String enterMessage, Scanner scanner, Landowner landowner) {
		this.message = message;
		this.enterMessage = enterMessage;
		this.scanner = scanner;
		this.Landowner = landowner;
	}

	public void run() {
		Landowner.printMyLands();
		System.out.print(enterMessage);
		int index = scanner.nextInt();
		if (Landowner.exists(index) == true)
			Landowner.sell(index);
		else
			System.out.println("Index not accepted.");
	}

	public String getMessage() {
		return message;
	}

	public boolean doContinue() {
		return true;
	}

}
