package landowner.ui.console;

import java.util.Scanner;

import landowner.bussiness.IShape;
import landowner.bussiness.Landowner;
import landowner.construction.SquareFactoryRole;

public class SquareOperation implements OperationRole {

	private String message;
	private String enterLength;
	private Scanner scanner;
	private Landowner landowner;
	private SquareFactoryRole squareFactory;

	public SquareOperation(String message, String enterLength, Scanner scanner, Landowner landowner,
			SquareFactoryRole squareFactory) {
		this.message = message;
		this.enterLength = enterLength;
		this.scanner = scanner;
		this.landowner = landowner;
		this.squareFactory = squareFactory;
	}

	public void run() {
		System.out.print(enterLength);
		double length = scanner.nextDouble();
		IShape shape = squareFactory.create(length);
		landowner.add(shape);
	}

	public String getMessage() {
		return this.message;
	}

	public boolean doContinue() {
		return true;
	}

}
