package landowner.ui.console;

import java.util.Scanner;

import landowner.bussiness.IShape;
import landowner.bussiness.Landowner;
import landowner.construction.TriangleFactoryRole;

public class TriangleOperation implements OperationRole {

	private String message;
	private String enterSide1;
	private String enterSide2;
	private String enterSide3;
	private Landowner landowner;
	private Scanner scanner;
	private TriangleFactoryRole triangleFactory;

	public TriangleOperation(String message, String enterSide1, String enterSide2, String enterSide3,
			Landowner landowner, Scanner scanner, TriangleFactoryRole triangleFactory) {
		this.message = message;
		this.enterSide1 = enterSide1;
		this.enterSide2 = enterSide2;
		this.enterSide3 = enterSide3;
		this.scanner = scanner;
		this.landowner = landowner;
		this.triangleFactory = triangleFactory;
	}

	public void run() {
		System.out.print(enterSide1);
		double side1 = scanner.nextDouble();

		System.out.print(enterSide2);
		double side2 = scanner.nextDouble();

		System.out.print(enterSide3);
		double side3 = scanner.nextDouble();

		IShape shape = triangleFactory.create(side1, side2, side3);
		landowner.add(shape);
	}

	public String getMessage() {
		return this.message;
	}

	public boolean doContinue() {
		return true;
	}

}
