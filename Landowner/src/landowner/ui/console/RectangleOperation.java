package landowner.ui.console;

import java.util.Scanner;

import landowner.bussiness.IShape;
import landowner.bussiness.Landowner;
import landowner.construction.RectangleFactoryRole;

public class RectangleOperation implements OperationRole {

	private String message;
	private String enterLength;
	private String enterWidth;
	private Scanner scanner;
	private Landowner landowner;
	private RectangleFactoryRole rectangleFactory;

	/**
	 * This method creates a rectangle and stores it in the landowner's ArrayList
	 * 
	 * @param message
	 * @param enterLength
	 * @param enterWidth
	 * @param scanner
	 * @param landowner
	 * @param rectangleFactory
	 */
	public RectangleOperation(String message, String enterLength, String enterWidth, Scanner scanner,
			Landowner landowner, RectangleFactoryRole rectangleFactory) {
		this.message = message;
		this.enterLength = enterLength;
		this.enterWidth = enterWidth;
		this.scanner = scanner;
		this.landowner = landowner;
		this.rectangleFactory = rectangleFactory;
	}

	public void run() {
		System.out.print(enterLength);
		double length = scanner.nextDouble();
		System.out.print(enterWidth);
		double width = scanner.nextDouble();
		IShape shape = rectangleFactory.create(length, width);
		landowner.add(shape);
	}

	public String getMessage() {
		return this.message;
	}

	public boolean doContinue() {
		return true;
	}

}
